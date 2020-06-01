package com.ywjh.stusqlmanager.utils

import android.os.Handler
import android.os.Looper

//定义静态类 让其运行在主线程中 (os包)handler
object ThreadUtil {
    val handler= Handler(Looper.getMainLooper())
    /*使其
    * 运行在主线中*/
    fun runOnMainThread(runnable: Runnable){
        handler.post(runnable)
    }
}