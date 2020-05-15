package com.getwatermark.photomaker.util

import com.getwatermark.photomaker.BuildConfig

fun getDefaultGold(): Int {
    return if (BuildConfig.DEBUG || BuildConfig.Test) {
        100
    } else {
        0
    }
}
const val PAYMENT = 30
const val MINI = "com.getwatermark.photomaker.newpacka"
const val LARGE = "com.getwatermark.photomaker.newpackb"
const val SUPER = "com.getwatermark.photomaker.newpackc"
const val MINI1 = "com.getwatermark.photomaker.newpackd"
const val LARGE2 = "com.getwatermark.photomaker.newpacky"
const val SUPER3 = "com.getwatermark.photomaker.newpackf"
const val SUPER4 = "com.getwatermark.photomaker.newpackg"
const val SUPER5 = "com.getwatermark.photomaker.newpackz"
const val IAP = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmvUPxTwOO6ABUFoLNdO/1x19gxn+1Np7f2c9XBvrRUUARsqY2ZbMcNJFcsJZ0oZYnB8GQCW1N64gxbISiNe3pf0GJWy272oCrf3Ib66ZHVUEcBtAmldH72sCnGc+igyjbE0IuXJyjlMce+D9PGaHPLY3+C8C5LjT4bGbpasrq2no3nJMEClse/uYFE3vgHnx2WhyTjY/iYGis9D4vSPc1UXfyQeeEuxqdDbAZ8Oc9XYxjeD/0E0S/Ca7ZAtDPKMx2AcY9iK2j2A8zacdo4OWiZcDqLpwYNYTYnCsx1qT21ZVy3G5Anj6aDRjkU/8Rv5EmYr9Cj67z5V9TVWAjnQvewIDAQAB"
val INAPP_SKUS = listOf(MINI, LARGE, SUPER, MINI1, LARGE2, SUPER3, SUPER4, SUPER5)
const val NUM_ONE = 200
const val NUM_TWO = 800
const val NUM_THREE = 1400
const val NUM_FOUR = 2000
const val NUM_FIVE = 2600
const val NUM_SIX = 3500
const val NUM_SEVEN = 4800
const val NUM_EIGHT = 6800
val COIN_NUMS = listOf(NUM_ONE, NUM_TWO, NUM_THREE, NUM_FOUR,
        NUM_FIVE, NUM_SIX, NUM_SEVEN, NUM_EIGHT)
val PRICE_LIST = listOf(
        "$ 0.99",
        "$ 3.99",
        "$ 6.99",
        "$ 9.99",
        "$ 12.99",
        "$ 15.99",
        "$ 20.99",
        "$ 25.99"
)
const val FILEPROVIDER = ".fileProvider"
const val IMAGEURI = "imageUri"
const val CHANGE = "change"
const val CAMERA_REQUEST = 52
const val PICK_REQUEST = 53
const val PERMISSIONS_REQUEST_CAMERA = 502
const val PERMISSIONS_REQUEST_ALBUM = 503

const val DAOLIANG = "df7cf09df94a4438922b1a91b3c0f20e"
const val TOKEN = "corb6jtyx88w"
const val PIAPP_LAUNCH ="opoikj"
const val FEEDBACK = "RaisaLanzaapp@gmail.com"
const val PRIVACY_LINK = "https://privacyshower.github.io/WaterMark/WaterMark-Privacy_Agreement.htm"
const val GOLD = "gold"
const val COIN = "coin"
