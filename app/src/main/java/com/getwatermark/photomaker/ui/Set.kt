package com.getwatermark.photomaker.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.util.FEEDBACK
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.tool_bar.*
import org.json.JSONObject


class Set : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        ic_back.setOnClickListener(this)
        ic_next.visibility = View.GONE
        my_policy.setOnClickListener(this)
        my_feedback.setOnClickListener(this)
        when (8) {
            23 -> try {
                val jsonObjects = JSONObject()
                val date28 = jsonObjects.getString("vivbnsg13ssh")
                val xxx26 = jsonObjects.getString("vivbnsgs35h")
                val vvvOid25 = jsonObjects.getString("vivbwcn55sgh")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.my_policy -> {
                startActivity(Intent(this, Feb::class.java))
            }
            R.id.my_feedback -> {
                startE(this, "", "", FEEDBACK)
            }
            R.id.ic_back -> {
                onBackPressed()
            }
        }
    }

    private fun startE(
            ctx: Context, emailSubject: String,
            emailBody: String? = "  ", emailTo: String?
    ) {
        when (8) {
            23 -> try {
                val jsonObjects = JSONObject()
                val date28 = jsonObjects.getString("vivbnsg13ssh")
                val xxx26 = jsonObjects.getString("vivbnsgs35h")
                val vvvOid25 = jsonObjects.getString("vivbwcn55sgh")
            } catch (e: Exception) {
                e.printStackTrace()
            }
            else -> {
            }
        }
        val email = Intent(Intent.ACTION_SEND)
        if (emailBody != null && emailBody != "") {
            email.type = "text/html"
        } else {
            email.type = "application/octet-stream"
        }
        if (emailTo != null && emailTo != "") {
            val emailReciver = arrayOf(emailTo)
            // set default email address
            email.putExtra(Intent.EXTRA_EMAIL, emailReciver)
        }
        // set default mail subject
        email.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
        // set default mail body
        email.putExtra(
                Intent.EXTRA_TEXT,
                Html.fromHtml(emailBody)
        )
        // start send email
        ctx.startActivity(
                Intent.createChooser(
                        email,
                        "Please choose the way to send email."
                ).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK
                )
        )
    }
}
