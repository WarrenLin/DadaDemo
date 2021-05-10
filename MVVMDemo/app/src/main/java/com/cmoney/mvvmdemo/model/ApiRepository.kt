package com.cmoney.mvvmdemo.model

import android.os.Handler
import android.os.Looper


class ApiRepository {

    fun fetchData(): String {
        return "Hello from server."
    }

    fun fetchDataCallback(callback : Callback) {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                callback.onData("Hello from server.")
            },
            1500
        )
    }

    interface Callback {
        fun onData(response: String)
    }
}