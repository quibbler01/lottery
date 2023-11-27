package cn.quibbler.lottery.model.repository.network.retrofit

import cn.quibbler.lottery.model.repository.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Url.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}