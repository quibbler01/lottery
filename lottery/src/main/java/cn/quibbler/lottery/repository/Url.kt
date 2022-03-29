package cn.quibbler.lottery.repository

object Url {
    private const val key = "e83aaa65276e492c9ffdf1efcb5b21c3"

    const val baseUrl = "https://way.jd.com/jisuapi/"

    const val NewsChannelPath = "channel?appkey=${key}"

    const val NewsListsPath = "get?appkey=${key}"
    const val newsNum = "num"
    const val defaultNewsNum = 10

    const val startPosition = "start"
    const val defaultStartPosition = 0

    const val newsChannel = "channel"
    const val defaultNewsChannel = "头条"


}