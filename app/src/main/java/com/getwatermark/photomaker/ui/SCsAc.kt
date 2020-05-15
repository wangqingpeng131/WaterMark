package com.getwatermark.photomaker.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.SimpleItemAnimator
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.adapter.ColorAdapter
import com.getwatermark.photomaker.adapter.Iidd
import com.getwatermark.photomaker.adapter.WaterMarkAdapter
import com.getwatermark.photomaker.callback.TemplateCallback
import com.getwatermark.photomaker.data.ColorBean
import com.getwatermark.photomaker.data.Data
import com.getwatermark.photomaker.data.Data.waterMarkB
import com.getwatermark.photomaker.data.WaterMarkBean
import com.getwatermark.photomaker.util.CHANGE
import com.getwatermark.photomaker.util.IMAGEURI
import com.getwatermark.photomaker.util.Util
import com.getwatermark.photomaker.util.dipToPx
import kotlinx.android.synthetic.main.activity_ed.*
import kotlinx.android.synthetic.main.tool_bar.*


class SCsAc : BaseActivity(), TemplateCallback {
    //    private lateinit var cropResultReceiver: CropIwaResultReceiver
    private var isSingleWaterMark = true
    private lateinit var waterMarkAdapter: WaterMarkAdapter
    private lateinit var colorAdapter: ColorAdapter
    private lateinit var waterMarks: List<WaterMarkBean>
    private lateinit var colorBeans: List<ColorBean>
    private var isChange: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ed)
        ic_back.setOnClickListener {
            onBackPressed()
        }
        ic_next.setOnClickListener {
            val saveUri = Util().saveTemporaryBitmap(edit_photo_group)
            val intent = Intent(this, Svc::class.java)
            intent.putExtra(IMAGEURI, saveUri.toString())
            intent.putExtra(CHANGE, isChange)
            startActivity(intent)
        }
        isSingleWaterMark()
        single_water_mark.setOnClickListener {
            isSingleWaterMark = true
            isSingleWaterMark()
        }
        multiple_water_mark.setOnClickListener {
            isSingleWaterMark = false
            isSingleWaterMark()
        }
        selector_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.water_mark_selector -> {
                    text_and_color_regulator.setBackgroundResource(android.R.color.transparent)
                    edit_input_group.visibility = View.VISIBLE
                    color_regulator.visibility = View.GONE
                    edit_select_rv.adapter = waterMarkAdapter
                    edit_select_rv.removeItemDecorationAt(0)
                    edit_select_rv.addItemDecoration(Iidd(16.dipToPx()))
                }
                R.id.color_selector -> {
                    text_and_color_regulator.setBackgroundResource(R.color.text_and_color_regulator_bg)
                    edit_input_group.visibility = View.GONE
                    color_regulator.visibility = View.VISIBLE
                    edit_select_rv.adapter = colorAdapter
                    edit_select_rv.removeItemDecorationAt(0)
                    edit_select_rv.addItemDecoration(Iidd(32.dipToPx()))
                }
            }
        }
        val url = intent.getParcelableExtra<Uri>(EXTRA_URI)
        edit_photo_iv.setImageURI(url)
        edit_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().length < 20) {
                    water_mark_tv_single.text = s.toString()
                    water_mark_tv_1.text = s.toString()
                    water_mark_tv_2.text = s.toString()
                    water_mark_tv_3.text = s.toString()
                    water_mark_tv_4.text = s.toString()
                    water_mark_tv_5.text = s.toString()
                    water_mark_tv_6.text = s.toString()
                }

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        edit_cancel.setOnClickListener {
            edit_input.setText(R.string.watermark)
        }
        waterMarks = Data.getSmallWaterMark()
        colorBeans = Data.getColors()
        waterMarkAdapter = WaterMarkAdapter(this, waterMarks)
        colorAdapter = ColorAdapter(this, this, colorBeans)
        edit_select_rv.adapter = waterMarkAdapter
        edit_select_rv.addItemDecoration(Iidd(16.dipToPx()))

        setWaterMarkAlpha(0.5.toFloat())
        ((edit_select_rv.itemAnimator) as SimpleItemAnimator).supportsChangeAnimations = false
        color_seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val alpha = progress / 100.0
                setWaterMarkAlpha(alpha.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    companion object {
        private const val EXTRA_URI = "extra_uri"
        fun callingIntent(context: Context, imageUri: Uri): Intent {
            val intent = Intent(context, SCsAc::class.java)
            intent.putExtra(EXTRA_URI, imageUri)
            return intent
        }

    }

    private fun setWaterMarkAlpha(alpha: Float) {
        water_mark_iv_single.alpha = alpha
        water_mark_iv_1.alpha = alpha
        water_mark_iv_2.alpha = alpha
        water_mark_iv_3.alpha = alpha
        water_mark_iv_4.alpha = alpha
        water_mark_iv_5.alpha = alpha
        water_mark_iv_6.alpha = alpha
        water_mark_tv_single.alpha = alpha
        water_mark_tv_1.alpha = alpha
        water_mark_tv_2.alpha = alpha
        water_mark_tv_3.alpha = alpha
        water_mark_tv_4.alpha = alpha
        water_mark_tv_5.alpha = alpha
        water_mark_tv_6.alpha = alpha
    }

    private fun isSingleWaterMark() {
        if (isSingleWaterMark) {
            water_mark_iv_single.visibility = View.VISIBLE
            water_mark_tv_single.visibility = View.VISIBLE
            multiple_water_mark_group.visibility = View.GONE
        } else {
            water_mark_iv_single.visibility = View.GONE
            water_mark_tv_single.visibility = View.GONE
            multiple_water_mark_group.visibility = View.VISIBLE
        }
    }

    override fun template(v: View?, position: Int) {
        when (v?.id) {
            R.id.item_water_mark_select_bg -> {
                water_mark_iv_single.setImageResource(waterMarkB[position])
                water_mark_iv_1.setImageResource(waterMarkB[position])
                water_mark_iv_2.setImageResource(waterMarkB[position])
                water_mark_iv_3.setImageResource(waterMarkB[position])
                water_mark_iv_4.setImageResource(waterMarkB[position])
                water_mark_iv_5.setImageResource(waterMarkB[position])
                water_mark_iv_6.setImageResource(waterMarkB[position])
                waterMarks.forEachIndexed { index, waterMarkBean ->
                    waterMarkBean.isSelect = index == position
                }
                isChange = waterMarks[position].isChange
                waterMarkAdapter.setsData(waterMarks)

            }
            R.id.item_color_select_content -> {
                colorBeans.forEachIndexed { index, colorBean ->
                    colorBean.isSelect = index == position
                }
                colorAdapter.setDataNoNotify(colorBeans)
                water_mark_iv_single.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_iv_1.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_iv_2.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_iv_3.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_iv_4.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_iv_5.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_iv_6.setColorFilter(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_single.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_1.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_2.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_3.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_4.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_5.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
                water_mark_tv_6.setTextColor(ContextCompat.getColor(this, colorBeans[position].res))
            }
        }
    }
}