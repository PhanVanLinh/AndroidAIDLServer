package com.example.androidaidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class RemoteService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private val binder = object : IRemoteService.Stub() {
        override fun getServerAppName(): String {
            return applicationContext.getString(R.string.app_name)
        }

        override fun doSomeThing(action: Int) {
            Log.i("TAG", "Server app receive $action")
            Thread.sleep(1000)
        }

        override fun onewayFunctionCall(value: Int) {
            Log.i("TAG", "onewayFunctionCall receive $value")
            Thread.sleep(1000)
            Log.i("TAG", "finish $value")
        }

        override fun noneOneWayFunctionCall(value: Int) {
            Log.i("TAG", "none-onewayFunctionCall receive $value")
            Thread.sleep(1000)
            Log.i("TAG", "finish $value")
        }
    }
}