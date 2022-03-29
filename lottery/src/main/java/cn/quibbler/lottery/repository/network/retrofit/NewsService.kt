package cn.quibbler.lottery.repository.network.retrofit

import cn.quibbler.lottery.model.bean.NewsChannels
import cn.quibbler.lottery.model.bean.NewsLists
import cn.quibbler.lottery.repository.Url
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET(Url.NewsChannelPath)
    public fun getNewsChannels(): Call<NewsChannels>

    @GET(Url.NewsListsPath)
    public fun getNewsLists(
            @Query(Url.newsChannel) channel: String = Url.defaultNewsChannel,
            @Query(Url.startPosition) start: Int = Url.defaultStartPosition,
            @Query(Url.newsNum) num: Int = Url.defaultNewsNum): Call<NewsLists>

}