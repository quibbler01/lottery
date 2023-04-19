package cn.quibbler.lottery.model.bean

data class BeanStoreItem(val cost: Int, val productName: String, val drawableResId: Int, val remainCount: Int = 0)
