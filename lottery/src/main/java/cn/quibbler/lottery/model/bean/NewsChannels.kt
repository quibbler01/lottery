package cn.quibbler.lottery.model.bean

import com.google.gson.annotations.SerializedName

data class NewsChannels(
        val charge: Boolean,
        val code: String,
        val msg: String,
        val requestId: String,
        val result: Result) {

    data class Result(
            val msg: String,
            @SerializedName("result")
            val channels: List<String>,
            val status: Int)

}

