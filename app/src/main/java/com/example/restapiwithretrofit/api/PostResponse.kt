package com.example.restapiwithretrofit.api
import com.google.gson.annotations.SerializedName

data class SensorResponse(
    val id: String,
    val tanggal: String,
    val suhu: String,
    val amonia: String,
    val curah_hujan: String,
    val ph: String,
    @SerializedName("do")
    val dissolved_oxygen: String?,
    val relay: String,
    val waktu: String,
)

data class PostResponse(
    val id: Int,
    val title: String?,
    @SerializedName("body")
    val text: String?
)