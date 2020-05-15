package com.getwatermark.photomaker.adapter

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.callback.TemplateCallback
import com.getwatermark.photomaker.data.ColorBean
import com.getwatermark.photomaker.util.dipToPx


class ColorAdapter constructor(private val context: Context, private val templateCallback: TemplateCallback,
                               dataList: List<ColorBean>) :
        BaseAdapter<ColorBean>(dataList),
        Pos.OnClickWithPositionListener<BaseAdapter.VH> {
    var mPosition = 0
    override fun convert(holder: VH, t: ColorBean, position: Int, payloads: MutableList<Any>) {
        val content = holder.getView<ImageView>(R.id.item_color_select_content)
        val frame = holder.getView<ImageView>(R.id.item_color_select_frame)
        val select = holder.getView<ImageView>(R.id.item_color_selected)
        if (payloads.isEmpty()) {
            if (position == 0) {
                frame?.visibility = View.GONE
            } else {
                frame?.visibility = View.VISIBLE
            }
            if (t.isSelect) {
                select?.visibility = View.VISIBLE
            } else {
                select?.visibility = View.GONE
            }
            if (content != null) {
                Glide.with(context)
                        .load(ColorDrawable(ContextCompat.getColor(context, t.res)))
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(10.dipToPx())))
                        .into(content)
            }
        } else {
            if (mPosition == position) {
                select?.visibility = View.VISIBLE
            } else {
                select?.visibility = View.GONE
            }
        }

        holder.setOnClickListener(this, R.id.item_color_select_content)
    }

    override fun getLayout(viewType: Int): Int {
        return R.layout.item_color_selector
    }

    override fun onClick(v: View?, position: Int, holder: VH) {
        templateCallback.template(v, position)
        val select = holder.getView<ImageView>(R.id.item_color_selected)
        if (mPosition != position) {
            select?.visibility = View.VISIBLE
            notifyItemChanged(mPosition, 0)
            mPosition = position
        }
    }
}