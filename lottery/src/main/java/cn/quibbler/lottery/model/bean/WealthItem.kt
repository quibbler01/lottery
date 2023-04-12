package cn.quibbler.lottery.model.bean

data class WealthItem(val wealthVal: Int, val label: String, val routePath: String = "", val pageTitle: String = "") {

    companion object {
        const val defaultWealthNum = -1
    }

}