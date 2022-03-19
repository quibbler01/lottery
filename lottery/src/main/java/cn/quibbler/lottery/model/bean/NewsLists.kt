package cn.quibbler.lottery.model.bean

data class NewsLists(
        val charge: Boolean,
        val code: String,
        val msg: String,
        val requestId: String,
        val result: Result?
) {

    data class Result(
            val msg: String,
            val result: ResultX?,
            val status: Int
    )

    data class ResultX(
            val channel: String?,
            val list: List<Item>?,
            val num: Int
    )

    data class Item(
            val category: String,
            val content: String,
            val pic: String,
            val src: String,
            val time: String,
            val title: String,
            val url: String,
            val weburl: String
    )

}



