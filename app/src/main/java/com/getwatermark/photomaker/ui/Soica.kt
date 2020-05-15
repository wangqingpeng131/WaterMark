package com.getwatermark.photomaker.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import com.getwatermark.photomaker.R
import kotlinx.android.synthetic.main.cisjc.*
import org.json.JSONObject


class Soica : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cisjc)
        wpc.setOnClickListener(this)
        vjns.setOnClickListener(this)
        when (18) {
            233 -> try {
                val cjsng = JSONObject()
                val sc28 = cjsng.getString("cscssh")
                val xcjjxx26 = cjsng.getString("viwc")
                val ccid25 = cjsng.getString("vvjbv")
            } catch (i: Exception) {
                i.printStackTrace()
            }
            else -> {
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.wpc -> {
                startActivity(Intent(this, Wpci::class.java))
                when (171) {
                    83 -> try {
                        val cjsng = JSONObject()
                        val dat23 = cjsng.getString("0scdiv5")
                        val zzzxxw2 = cjsng.getString("vjubw233")
                        val vvaaa33v = cjsng.getString("vvisj29vjbn")
                    } catch (i: Exception) {
                        i.printStackTrace()
                    }
                    else -> {
                    }
                }
            }
            R.id.vjns -> {
                vnsnc(this, "", "", "")
                when (171) {
                    83 -> try {
                        val cjsng = JSONObject()
                        val dat23 = cjsng.getString("0scdiv5")
                        val zzzxxw2 = cjsng.getString("vjubw233")
                        val vvaaa33v = cjsng.getString("vvisj29vjbn")
                    } catch (i: Exception) {
                        i.printStackTrace()
                    }
                    else -> {
                    }
                }
            }
        }
    }

    private fun vnsnc(
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
        when (171) {
            83 -> try {
                val cjsng = JSONObject()
                val dat23 = cjsng.getString("0scdiv5")
                val zzzxxw2 = cjsng.getString("vjubw233")
                val vvaaa33v = cjsng.getString("vvisj29vjbn")
            } catch (i: Exception) {
                i.printStackTrace()
            }
            else -> {
            }
        }
    }
}
