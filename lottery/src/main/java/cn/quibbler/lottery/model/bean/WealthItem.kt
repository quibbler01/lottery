package cn.quibbler.lottery.model.bean

data class WealthItem(val wealthVal: Int, val label: String) {

    companion object {
        const val defaultWealthNum = -1
    }

}