package com.getwatermark.photomaker.adapter

import android.view.View
import android.widget.TextView
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.callback.TemplateCallback
import com.getwatermark.photomaker.data.ShopBean


class ShoppingAdapter constructor(private val templateCallback: TemplateCallback,
                                  dataList: List<ShopBean>) :
        BaseAdapter<ShopBean>(dataList),
        ListenerWithPosition.OnClickWithPositionListener<BaseAdapter.VH> {

    override fun convert(holder: VH, t: ShopBean, position: Int, payloads: MutableList<Any>) {
        val coins = holder.getView<TextView>(R.id.shop_coin_num)
        val gold = holder.getView<TextView>(R.id.shop_gold_num)
        coins?.text = "x ${t.coins}"
        gold?.text = t.gold
        holder.setOnClickListener(this, R.id.shop_item)
    }

    override fun getLayout(viewType: Int): Int {
        return R.layout.item_shop
    }

    override fun onClick(v: View?, position: Int, holder: VH) {
        templateCallback.template(v, position)
    }

}