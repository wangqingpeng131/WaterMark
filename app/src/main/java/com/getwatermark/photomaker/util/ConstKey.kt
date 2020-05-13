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
const val MINI = "get.instagram.collage.instalike.getlikesforinstagram.followers.packofone"
const val LARGE = "get.instagram.collage.instalike.getlikesforinstagram.followers.packoftwo"
const val SUPER = "get.instagram.collage.instalike.getlikesforinstagram.followers.packofthree"
const val MINI1 = "get.instagram.collage.instalike.getlikesforinstagram.followers.packoffour"
const val LARGE2 = "get.instagram.collage.instalike.getlikesforinstagram.followers.packoffive"
const val SUPER3 = "get.instagram.collage.instalike.getlikesforinstagram.followers.packofsix"
const val SUPER4 = "get.instagram.collage.instalike.getlikesforinstagram.followers.packofseven"
const val SUPER5 = "get.instagram.collage.instalike.getlikesforinstagram.followers.packofeight"
const val IAP = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0CSR07C3vBH0vsYgVWAGhh0vIGvY67Uorx1m/cDpkYEDbOVBg7a19JHy9GTKVd1LaciG7JVyGje2SRzon/3/xYK6bPqkb1z0zmp9ivB0lBGx4kGlxYHdvZc3Xd3zDJm0l/WNQ3oBqzQvL7giDo34l228Bg3h5TDQesjne72fLwXdoF9OyLFE99dRxCaEHnSNMq2+p1FRp25vPCVg8PMK00sBGGXWzIZK2QjoxEFtgsVkhYAzU70jAFYepKuAFxCPOOXbnwAWbLm8qWeYYfvGENY3lc8rPdEp4Xwkv5L+JJqLx+xrRf3jjBBqyR8Z6hB9D2n5TRZ7Ed4aaIJo90usbQIDAQAB"
val INAPP_SKUS = listOf(MINI, LARGE, SUPER, MINI1, LARGE2, SUPER3, SUPER4, SUPER5)
const val NUM_ONE = 400
const val NUM_TWO = 1100
const val NUM_THREE = 2200
const val NUM_FOUR = 3300
const val NUM_FIVE = 4500
const val NUM_SIX = 6000
const val NUM_SEVEN = 7500
const val NUM_EIGHT = 9500
val COIN_NUMS = listOf(NUM_ONE, NUM_TWO, NUM_THREE, NUM_FOUR,
        NUM_FIVE, NUM_SIX, NUM_SEVEN, NUM_EIGHT)
val PRICE_LIST = listOf(
        "$ 1.99",
        "$ 4.99",
        "$ 9.99",
        "$ 14.99",
        "$ 20.99",
        "$ 27.99",
        "$ 35.99",
        "$ 44.99"
)
const val FILEPROVIDER = ".fileProvider"
const val IMAGEURI = "imageUri"
const val CHANGE = "change"
const val CAMERA_REQUEST = 52
const val PICK_REQUEST = 53
const val PERMISSIONS_REQUEST_CAMERA = 502
const val PERMISSIONS_REQUEST_ALBUM = 503
const val PERMISSIONS_REQUEST_READ_WRITE_EXTERNAL_STORAGE = 885

const val DAOLIANG = "df7cf09df94a4438922b1a91b3c0f20e"
const val TOKEN = "vxkpdx41fu9s"
const val PIAPP_LAUNCH ="opoikj"
const val FEEDBACK = "NedSilverberglike@gmail.com"
const val PRIVACY_LINK = "https://privacyshower.github.io/LovelyFrame/LovelyFrame-Privacy_Agreement.htm"
const val GOLD = "gold"
const val COIN = "coin"
