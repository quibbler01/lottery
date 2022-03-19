package cn.quibbler.lottery.model.bean

import org.joda.time.DateTime

data class OpenLotteryItem(val item: LotteryItem,val num:Int,val date:DateTime) {
}