package com.getwatermark.photomaker.data

import com.getwatermark.photomaker.R


object Data {
    val waterMarkB = arrayListOf(
            R.drawable.watermark_1,
            R.drawable.watermark_2,
            R.drawable.watermark_3,
            R.drawable.watermark_4,
            R.drawable.watermark_5,
            R.drawable.watermark_6,
            R.drawable.watermark_7,
            R.drawable.watermark_8,
            R.drawable.watermark_9,
            R.drawable.watermark_10,
            R.drawable.watermark_11
    )
    private val waterMarkS = arrayListOf(
            R.drawable.single1,
            R.drawable.single2,
            R.drawable.single3,
            R.drawable.single4,
            R.drawable.single5,
            R.drawable.single6,
            R.drawable.single7,
            R.drawable.single8,
            R.drawable.single9,
            R.drawable.single10,
            R.drawable.single11
    )
    private val colors = arrayListOf(
            R.color.white,
            R.color.red,
            R.color.orange,
            R.color.yellow,
            R.color.brown,
            R.color.green,
            R.color.purple,
            R.color.pink,
            R.color.black,
            R.color.papayawhip,
            R.color.blanchedalmond,
            R.color.mistyrose,
            R.color.bisque,
            R.color.moccasin,
            R.color.navajowhite,
            R.color.peachpuff,
            R.color.gold,
            R.color.lightpink,
            R.color.lightsalmon,
            R.color.darkorange,
            R.color.coral,
            R.color.hotpink,
            R.color.tomato,
            R.color.orangered,
            R.color.deeppink,
            R.color.fuchsia,
            R.color.magenta,
            R.color.oldlace,
            R.color.lightgoldenrodyellow,
            R.color.linen,
            R.color.antiquewhite,
            R.color.salmon,
            R.color.ghostwhite,
            R.color.mintcream,
            R.color.whitesmoke,
            R.color.beige,
            R.color.wheat,
            R.color.sandybrown,
            R.color.azure,
            R.color.honeydew,
            R.color.aliceblue,
            R.color.khaki,
            R.color.lightcoral,
            R.color.palegoldenrod,
            R.color.violet,
            R.color.darksalmon,
            R.color.lavender,
            R.color.lightcyan,
            R.color.burlywood,
            R.color.plum,
            R.color.gainsboro,
            R.color.crimson,
            R.color.palevioletred,
            R.color.goldenrod,
            R.color.orchid,
            R.color.thistle,
            R.color.lightgray,
            R.color.tan,
            R.color.chocolate,
            R.color.peru
    )

    fun getBigWaterMark(): List<WaterMarkBean> {
        val array = ArrayList<WaterMarkBean>()
        waterMarkB.forEachIndexed { index, i ->
            val waterMarkBean = WaterMarkBean()
            if (index == 0) {
                waterMarkBean.isSelect = true
                waterMarkBean.isChange = true
            }
            waterMarkBean.res = i
            array.add(waterMarkBean)
        }
        return array
    }

    fun getSmallWaterMark(): List<WaterMarkBean> {
        val array = ArrayList<WaterMarkBean>()
        waterMarkS.forEachIndexed { index, i ->
            val waterMarkBean = WaterMarkBean()
            if (index == 0) {
                waterMarkBean.isSelect = true
                waterMarkBean.isChange = false
            }
            waterMarkBean.res = i
            array.add(waterMarkBean)
        }
        return array
    }

    fun getColors(): List<ColorBean> {
        val array = ArrayList<ColorBean>()
        colors.forEachIndexed { index, i ->
            val colorBean = ColorBean()
            if (index == 0) {
                colorBean.isSelect = true
            }
            colorBean.res = i
            array.add(colorBean)
        }
        return array
    }
}