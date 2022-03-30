package cn.quibbler.lottery.model

import cn.quibbler.lottery.model.bean.LotteryItem
import cn.quibbler.lottery.model.bean.OpenLotteryItem
import org.joda.time.DateTime
import java.util.*
import kotlin.collections.ArrayList

object Repository {
    const val page_size = 12

    private val RANDOM = Random()

    private val RED_NUM_LIST = ArrayList<String>()
    private val BLUE_NUM_LIST = ArrayList<String>()

    private const val MAX = 360

    private val TODAY = DateTime()
    private const val curNumOfLottery = 22025

    private val list = ArrayList<OpenLotteryItem>()

    init {
        for (i in 1..35) {
            RED_NUM_LIST.add(if (i < 10) {
                "0${i}"
            } else {
                "${i}"
            })
        }
        for (i in 1..12) {
            BLUE_NUM_LIST.add(if (i < 10) {
                "0${i}"
            } else {
                "${i}"
            })
        }

        for (i in 0 until MAX) {
            list.add(OpenLotteryItem(getLotteryItem(), curNumOfLottery - i, TODAY.minusDays(i)))
        }
    }

    public fun getLotteries(): ArrayList<LotteryItem> {
        val re = ArrayList<LotteryItem>()
        for (i in 0 until 20) {
            val item = getLotteryItem()
            re.add(item)
        }
        return re
    }

    public fun getLotteryItem(): LotteryItem {
        val redList = ArrayList(RED_NUM_LIST)
        val blueList = ArrayList(BLUE_NUM_LIST)
        val list = ArrayList<String>()
        for (i in 1..5) {
            val index = RANDOM.nextInt(redList.size)
            list.add(redList[index])
            redList.removeAt(index)
        }
        for (i in 1..2) {
            val index = RANDOM.nextInt(blueList.size)
            list.add(blueList[index])
            blueList.removeAt(index)
        }
        return LotteryItem(list[0], list[1], list[2], list[3], list[4], list[5], list[6])
    }

    public fun getHistoryOpenLottery(): ArrayList<OpenLotteryItem> = list

    public fun getCost(range: Int) = RANDOM.nextInt(range)

    public fun requestData(start: Int = 0, itemCount: Int = page_size): List<OpenLotteryItem> {
        return if (start + itemCount > list.size) {
            ArrayList<OpenLotteryItem>()
        } else {
            list.subList(start, start + itemCount)
        }
    }

}