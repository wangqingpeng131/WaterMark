package com.getwatermark.photomaker.adapter

import android.view.View

class Pos(private var position: Int, private var holder: BaseAdapter.VH) : View.OnClickListener {
    lateinit var mOnClickListener: OnClickWithPositionListener<BaseAdapter.VH>

    fun setOnClickListener(mOnClickListener: OnClickWithPositionListener<BaseAdapter.VH>) {
        this.mOnClickListener = mOnClickListener
    }

    interface OnClickWithPositionListener<VH> {
        fun onClick(v: View?, position: Int, holder: BaseAdapter.VH)
    }

    override fun onClick(v: View?) {
        mOnClickListener.onClick(v, position, holder)
    }
}