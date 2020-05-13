package com.getwatermark.photomaker.util

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Environment
import android.view.View
import com.getwatermark.photomaker.ui.MyApplication
import com.getwatermark.photomaker.ui.ShoppingActivity
import java.io.File
import java.io.FileOutputStream
import java.text.DecimalFormat

fun Int.dipToPx(): Int {
    val scale = MyApplication.getInstance().resources.displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

class Util {
    private var coins: Int = 0

    fun payCoin(context: Context, payCoin: PayCoin, id: Int, position: Int) {
        val sp = context.getSharedPreferences(GOLD, Context.MODE_PRIVATE)
        coins = sp.getInt(COIN, getDefaultGold())
        if (coins < PAYMENT) {
            AlertDialog.Builder(context)
                    .setMessage("Not enough coins, would you like to get more?")
                    .setPositiveButton("OK"
                    ) { _, _ -> context.startActivity(Intent(context, ShoppingActivity::class.java)) }
                    .setNegativeButton("Cancel"
                    ) { dialog, _ -> dialog.dismiss() }
                    .show()
        } else {
            AlertDialog.Builder(context)
                    .setTitle("This item will cost $PAYMENT coins.")
                    .setPositiveButton("OK"
                    ) { dialog, _ ->
                        coins -= PAYMENT
                        payCoin.payCoinsCallback(id, position)
                        sp.edit().putInt(COIN, coins).apply()
                        dialog.dismiss()
                    }
                    .setNegativeButton("CANCEL"
                    ) { dialog, _ -> dialog.dismiss() }.show()
        }
    }

    interface PayCoin {
        fun payCoinsCallback(id: Int, position: Int)
    }
    fun saveTemporaryBitmap(v: View): Uri? {
        val cache = getDiskCachePath(MyApplication.getInstance())
        var uri: Uri? = null
        if (cache != null) {
            val file = File("$cache/mCacheBitmap.png")
            file.createNewFile()
            val fOut = FileOutputStream(file)
            val bitmap = loadBitmapFromView(v)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut)
            fOut.flush()
            fOut.close()
            uri = Uri.fromFile(file)
        }
        return uri
    }

    companion object {
        fun convert(num: Int): String {
            val df = DecimalFormat()
            if (num < 1000) {
                return num.toString()
            }
            var convertNum = num.toDouble() / 1000
            return if (convertNum - 1000 >= 0) {
                convertNum /= 1000
                df.applyPattern("0.0M")
                df.format(convertNum)

            } else {
                df.applyPattern("0.0K")
                df.format(convertNum)
            }
        }

        fun getCoins(): String {
            val shared = MyApplication.getInstance()
                    .getSharedPreferences(GOLD, Context.MODE_PRIVATE)
            val num = shared.getInt(COIN, getDefaultGold())
            return convert(num)
        }

        fun buyCoins(coins: Int): String {
            val shared = MyApplication.getInstance()
                    .getSharedPreferences(GOLD, Context.MODE_PRIVATE)
            var num = shared.getInt(COIN, getDefaultGold())
            val editor = shared.edit()
            num += coins
            editor.putInt(COIN, num)
            editor.apply()
            return num.toString()
        }


        fun getDiskCachePath(context: Context): String? {
            return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
                    || !Environment.isExternalStorageRemovable()) {
                context.externalCacheDir?.path
            } else {
                context.cacheDir?.path
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

        /*fun getRealPathFromUri(context: Context, uri: Uri): String? {
            val sdkVersion = Build.VERSION.SDK_INT
            return if (sdkVersion >= 19) {
                getRealPathFromUriAboveApi19(context, uri)
            } else {
                getRealPathFromUriBelowAPI19(context, uri)
            }
        }*/

        /*private fun getRealPathFromUriBelowAPI19(context: Context, uri: Uri): String? {
            return getDataColumn(context, uri, null, null)
        }*/


        /*@TargetApi(Build.VERSION_CODES.KITKAT)
        private fun getRealPathFromUriAboveApi19(context: Context, uri: Uri): String? {
            var filePath: String? = null
            if (DocumentsContract.isDocumentUri(context, uri)) {
                val documentId = DocumentsContract.getDocumentId(uri)
                if (isMediaDocument(uri)) {
                    val id = documentId.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
                    val selection = MediaStore.Images.Media._ID + "=?"
                    val selectionArgs = arrayOf(id)
                    filePath = getDataColumn(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection, selectionArgs)
                } else if (isDownloadsDocument(uri)) {
                    val contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(documentId))
                    filePath = getDataColumn(context, contentUri, null, null)
                }
            } else if ("content".equals(uri.scheme!!, ignoreCase = true)) {
                filePath = getDataColumn(context, uri, null, null)
            } else if ("file" == uri.scheme) {
                filePath = uri.path
            }
            return filePath
        }*/

        /* private fun isDownloadsDocument(uri: Uri): Boolean {
             return "com.android.providers.downloads.documents" == uri.authority
         }

         private fun isMediaDocument(uri: Uri): Boolean {
             return "com.android.providers.media.documents" == uri.authority
         }*/

        /*private fun getDataColumn(context: Context, uri: Uri, selection: String?, selectionArgs: Array<String>?): String? {
            var path: String? = null
            val projection = arrayOf(MediaStore.Images.Media.DATA)
            var cursor: Cursor? = null
            try {
                cursor = context.contentResolver.query(uri, projection, selection, selectionArgs, null)
                if (cursor != null && cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndexOrThrow(projection[0])
                    path = cursor.getString(columnIndex)
                }
            } catch (e: Exception) {
                cursor?.close()
            }

            return path
        }*/
    }
}
