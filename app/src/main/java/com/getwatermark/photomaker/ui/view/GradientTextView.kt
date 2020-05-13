package com.getwatermark.photomaker.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


class GradientTextView(context: Context?, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    private var mLinearGradient: LinearGradient? = null
    private lateinit var mPaint: Paint
    private var mViewWidth = 0
    private val mTextBound: Rect = Rect()
    override fun onDraw(canvas: Canvas) {
        mViewWidth = measuredWidth
        mPaint = paint
        val mTipText = text.toString()
        mPaint.getTextBounds(mTipText, 0, mTipText.length, mTextBound)
        mLinearGradient = LinearGradient(0.toFloat(), 0.toFloat(), mViewWidth.toFloat(), 0.toFloat(), intArrayOf(0xbd6cdf, 0x4b13af),
                null, Shader.TileMode.REPEAT)
        mPaint.setShader(mLinearGradient)
        canvas.drawText(mTipText, measuredWidth / 2.toFloat() - mTextBound.width() / 2, measuredHeight / 2.toFloat() + mTextBound.height() / 2, mPaint)
    }
}