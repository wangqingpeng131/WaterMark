package com.getwatermark.photomaker.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.getwatermark.photomaker.BuildConfig
import com.getwatermark.photomaker.R
import com.getwatermark.photomaker.adapter.ShoppingAdapter
import com.getwatermark.photomaker.callback.TemplateCallback
import com.getwatermark.photomaker.data.ShopBean
import com.getwatermark.photomaker.util.*

import kotlinx.android.synthetic.main.activity_shop.*
import kotlinx.android.synthetic.main.tool_bar.*


class Shpa : BaseActivity(), TemplateCallback, GooglePay.Callback {
    private lateinit var shopRv: RecyclerView
    private var golds = ArrayList<ShopBean>()
    lateinit var googlePay: GooglePay
    private lateinit var myCommodity: MyCommodity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        initData()
        shopRv = shop_rv
        val shopAdapter = ShoppingAdapter(this, golds)
        shopRv.adapter = shopAdapter
        ic_back.setOnClickListener {
            onBackPressed()
        }
        ic_next.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
//        coin_num.text = Util.getCoins()
    }

    override fun onDestroy() {
        super.onDestroy()
        googlePay.destroyService(this)
    }

    private fun initData() {
        googlePay = GooglePay.getGooglePay(this)
        googlePay.initGooglePay(this)
        INAPP_SKUS.forEachIndexed { index, sku ->
            golds.add(ShopBean(COIN_NUMS[index], PRICE_LIST[index], sku))
        }
    }


    override fun template(v: View?, position: Int) {
        if (position < golds.size)
            myCommodity = MyCommodity(golds[position].sku, IAP, packageName)
        if (BuildConfig.Test || BuildConfig.DEBUG)
            Toast.makeText(this, golds[position].sku, Toast.LENGTH_LONG).show()
        this.googlePay.startPay(myCommodity, this)
    }

    override fun callBack(id: String) {
        golds.forEachIndexed { index, shopBean ->
            if (shopBean.sku == id) {
//                coin_num.text = convert(Util.buyCoins(COIN_NUMS[index]).toInt())
            }
        }
    }

}
