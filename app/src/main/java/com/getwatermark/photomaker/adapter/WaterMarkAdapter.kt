package com.getwatermark.photomaker.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.callback.TemplateCallback
import com.getwatermark.photomaker.data.WaterMarkBean


class WaterMarkAdapter constructor(private val templateCallback: TemplateCallback,
                                   dataList: List<WaterMarkBean>) :
        BaseAdapter<WaterMarkBean>(dataList),
        ListenerWithPosition.OnClickWithPositionListener<BaseAdapter.VH> {
    override fun convert(holder: VH, t: WaterMarkBean, position: Int, payloads: MutableList<Any>) {
        val content = holder.getView<ImageView>(R.id.item_water_mark_select_content)
        val frame = holder.getView<ImageView>(R.id.item_water_mark_select_frame)
        if (t.isSelect) {
            frame?.setBackgroundResource(R.drawable.water_mark_frame)
        } else {
            frame?.setBackgroundResource(R.drawable.item_water_mark_normal_frame)
        }
        if (position >= 1) {
            content?.setImageResource(R.drawable.ic_lock)
        }else {
            content?.setImageResource(t.res)
        }
        holder.setOnClickListener(this, R.id.item_water_mark_select_bg)
    }

    override fun getLayout(viewType: Int): Int {
        return R.layout.item_water_mark
    }

    override fun onClick(v: View?, position: Int, holder: VH) {
        templateCallback.template(v, position)
    }

}