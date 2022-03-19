package cn.quibbler.lottery.model

import cn.quibbler.lottery.repository.network.retrofit.NewsService
import cn.quibbler.lottery.repository.network.retrofit.RetrofitHelper

object NewsRepository {

    val service: NewsService = RetrofitHelper.retrofit.create(NewsService::class.java)

}