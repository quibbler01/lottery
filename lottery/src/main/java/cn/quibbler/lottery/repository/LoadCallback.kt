package cn.quibbler.lottery.repository

interface LoadCallback {

    fun onSuccess() {}

    fun onFailed() {}

}