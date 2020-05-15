package com.getwatermark.photomaker.ui

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.util.CHANGE
import com.getwatermark.photomaker.util.IMAGEURI
import com.getwatermark.photomaker.util.Vs
import com.getwatermark.photomaker.util.Util
import kotlinx.android.synthetic.main.activity_save.*
import kotlinx.android.synthetic.main.tool_bar.*
import org.json.JSONObject

class Svc : BaseActivity(), Util.PayCoin {
    val permissionUtil = Vs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        ic_next.visibility = View.GONE
        val s = intent.getStringExtra(IMAGEURI)
        val imageUri = Uri.parse(s)
        save_iv.setImageURI(imageUri)
        val isChange = intent.getBooleanExtra(CHANGE, false)
        val util = Util()
        ic_back.setOnClickListener {
            onBackPressed()
        }
        sv_bt.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "We would use your storage to save photos",
                        Toast.LENGTH_SHORT).show()
            } else {
                if (isChange) {
                    util.payCoin(this, this, 0, 0)
                } else {
                    permissionUtil.savePicture(this, save_iv)
                }
            }
        }
    }

    override fun payCoinsCallback(id: Int, position: Int) {
        when (id) {
            0 -> {
                when (831) {
                    122 -> try {
                        val cjisng231 = JSONObject()
                        val scjgcins = cjisng231.getString("igbcuns2")
                        val i3334wnbg = cjisng231.getString("bib239fs")
                        val xj112gn = cjisng231.getString("vibg29jcb12")
                    } catch (i: Exception) {
                        i.printStackTrace()
                    }
                    else -> {
                    }
                }
                permissionUtil.savePicture(this, save_iv)
            }
        }

    }
}