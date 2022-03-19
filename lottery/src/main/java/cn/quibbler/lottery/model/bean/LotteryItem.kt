package cn.quibbler.lottery.model.bean

data class LotteryItem(val num1: String, val num2: String, val num3: String, val num4: String, val num5: String, val pre1: String, val pre2: String) {

    override fun equals(other: Any?): Boolean {
        return toString() == other.toString()
    }

    override fun toString(): String {
        return num1 + num2 + num3 + num4 + num5 + pre1 + pre2
    }

    override fun hashCode(): Int {
        var result = num1.hashCode()
        result = 31 * result + num2.hashCode()
        result = 31 * result + num3.hashCode()
        result = 31 * result + num4.hashCode()
        result = 31 * result + num5.hashCode()
        result = 31 * result + pre1.hashCode()
        result = 31 * result + pre2.hashCode()
        return result
    }

}
