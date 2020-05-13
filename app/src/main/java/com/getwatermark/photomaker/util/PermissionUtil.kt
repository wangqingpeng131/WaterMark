package com.getwatermark.photomaker.util

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Handler
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.view.PixelCopy
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.getwatermark.photomaker.BuildConfig
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.ui.MyApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.*
import java.text.SimpleDateFormat
import java.util.*

class PermissionUtil {
    fun haveStoragePermission(vararg permissions: String): Boolean {
        var boolean = false
        permissions.forEach {
            boolean = ContextCompat.checkSelfPermission(MyApplication.getInstance(), it) ==
                    PackageManager.PERMISSION_GRANTED
            if (!boolean) return boolean
        }
        return boolean
    }


    fun requestCameraPermission(activity: Activity, vararg permissions: String) {
        ActivityCompat.requestPermissions(activity, permissions, PERMISSIONS_REQUEST_CAMERA)
    }

    fun requestAlbumPermission(activity: Activity, vararg permissions: String) {
        ActivityCompat.requestPermissions(activity, permissions, PERMISSIONS_REQUEST_ALBUM)
    }

    fun goToSettings(context: Context) {
        AlertDialog.Builder(context)
                .setMessage(MyApplication.getInstance().getString(R.string.need_photo_permission))
                .setPositiveButton("OK") { _, _ ->
                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:${context.packageName}"))
                            .apply {
                                addCategory(Intent.CATEGORY_DEFAULT)
                                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            }.also { intent ->
                                MyApplication.getInstance().startActivity(intent)
                            }
                }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .show()
    }


    fun openCamera(activity: Activity) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        var image: File? = null
        if (intent.resolveActivity(MyApplication.getInstance().packageManager) != null) {
            image = generateCachePicturePath(MyApplication.getInstance())
        }
        if (image != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        FileProvider.getUriForFile(MyApplication.getInstance(),
                                BuildConfig.APPLICATION_ID + ".fileProvider", image)
                )
                intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            } else {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image))
            }
        }
        activity.startActivityForResult(intent, CAMERA_REQUEST)
    }

    fun openAlbum(activity: Activity) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        activity.startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                PICK_REQUEST)
    }

    fun savePicture(context: Context, view: View) {
        if (ContextCompat.checkSelfPermission(context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "We would use your storage to save photos",
                    Toast.LENGTH_SHORT).show()
        } else {
//            CoroutineScope(Dispatchers.IO).launch {
                savePicture(context, loadBitmapFromView(view))
//            }
        }
    }

    fun generateCachePicturePath(context: Context): File? {
        try {
            val storageDir = getDiskCachePath(context, BuildConfig.APPLICATION_ID)
            return File(storageDir, "IMG_CACHE.jpg")
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    private fun generatePicturePath(context: Context): File? {
        try {
            val storageDir = getExternalFile(context)
            val date = Date()
            date.time = System.currentTimeMillis() + random(1, 1000)
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date)
            return File("$storageDir/${context.getString(R.string.app_name)}", "IMG_$timeStamp.jpg")
        } catch (e: Exception) {
        }
        return null
    }

    private fun savePicture(context: Context, bitmap: Bitmap?) {
        try {
            val file = getExternalFile(context)
            if (file != null) {
                saveBitmap(bitmap, file.path)
                addMediaToGallery(context, file)
                Toast.makeText(context, context.getText(R.string.save_photo_is_Success), Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getFileProviderName(context: Context): String {
        return context.packageName + FILEPROVIDER
    }

    private fun addMediaToGallery(context: Context, file: File) {
        val contentUri = Uri.fromFile(file)
        addMediaToGallery(context, contentUri)
    }

    private fun addMediaToGallery(context: Context, uri: Uri?) {
        if (uri == null) {
            return
        }
        try {
            val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            mediaScanIntent.data = uri
            context.sendBroadcast(mediaScanIntent)
        } catch (e: Exception) {
        }
    }

    private fun saveBitmap(bitmap: Bitmap?, path: String) {
        if (bitmap == null || TextUtils.isEmpty(path)) {
            return
        }
        var bos: BufferedOutputStream? = null
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(path)
            bos = BufferedOutputStream(fos)
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, bos)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            try {
                bos?.close()
                if (null != fos) {
                    fos.flush()
                    fos.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
            bitmap.recycle()
        }
    }

    private fun random(from: Int, to: Int): Int {
        return Random().nextInt((to + 1) - from) + from
    }

    fun getDiskCachePath(context: Context): String? {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
                || !Environment.isExternalStorageRemovable()) {
            context.externalCacheDir?.path
        } else {
            context.cacheDir?.path
        }
    }

    private fun getDiskCachePath(context: Context, appId: String?): File? {
        val storageDir: File?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        }
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            storageDir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), appId)
            if (!storageDir.mkdirs()) {
                if (!storageDir.exists()) {
                    return null
                }
            }
        } else {
            Toast.makeText(context,
                    "GetExternalDirectory fail ,the reason is " +
                            "sdCard nonexistence or sdCard mount fail !",
                    Toast.LENGTH_SHORT).show()
            return null
        }
        return storageDir
    }
    private fun getExternalFile(context: Context): File? {
        val date = Date()
        date.time = System.currentTimeMillis() + random(1, 1000)
        val timeString = SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.US).format(date)
        val childName = "$timeString.png"

        val permission = ActivityCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            val filesDir = context.getExternalFilesDir("file")
            if (filesDir != null) {
                val path = filesDir.path
                return getFile(childName, path)
            }
        } else {
            val filePath = (Environment.getExternalStorageDirectory().absolutePath + "/"
                    + context.getString(R.string.app_name) + "/")
            return getFile(childName, filePath)
        }
        return null
    }
    private fun getFile(childName: String, path: String): File {
        val mFile = File(path, childName)
        val pFile = mFile.parentFile
        if (!pFile.exists()) {

            pFile.mkdirs()
        }
        return mFile
    }

/*
    private fun getAlbumDir(context: Context, appId: String?): File? {
        var storageDir: File? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return context.getExternalFilesDir("file")
        }

        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            storageDir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), appId)
            if (!storageDir.mkdirs()) {
                if (!storageDir.exists()) {
                    return null
                }
            }
        }

        return storageDir
    }
*/


    fun getBitmapFromView(view: View, activity: Activity, callback: (Bitmap) -> Unit) {
        activity.window?.let { window ->
            val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
            val locationOfViewInWindow = IntArray(2)
            view.getLocationInWindow(locationOfViewInWindow)
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    PixelCopy.request(window, Rect(locationOfViewInWindow[0], locationOfViewInWindow[1], locationOfViewInWindow[0] + view.width, locationOfViewInWindow[1] + view.height), bitmap, { copyResult ->
                        if (copyResult == PixelCopy.SUCCESS) {
                            callback(bitmap)
                        }
                        // possible to handle other result codes ...
                    }, Handler())
                } else {
                    val c = Canvas(bitmap)
                    /* 如果不设置canvas画布为白色，则生成透明  */
                    c.drawColor(Color.parseColor("#00FFB2BA"))
                    view.draw(c)
                    callback(bitmap)
                }
            } catch (e: IllegalArgumentException) {
                // PixelCopy may throw IllegalArgumentException, make sure to handle it
                e.printStackTrace()
            }
        }
    }


    private fun loadBitmapFromView(v: View): Bitmap {
        val bmp = Bitmap.createBitmap(v.width, v.height, Bitmap.Config.ARGB_8888)
        val c = Canvas(bmp)
        /* 如果不设置canvas画布为白色，则生成透明  */
        c.drawColor(Color.parseColor("#00FFB2BA"))
        v.draw(c)
        return bmp
    }

}
