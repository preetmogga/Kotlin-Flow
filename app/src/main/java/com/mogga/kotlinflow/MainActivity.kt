package com.mogga.kotlinflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            getData().collect{ data ->
                Log.d("MainActivity",data.toString())
            }
        }

    }

    private fun getData():Flow<Int> = flow {
        for ( i in 0..5){
            kotlinx.coroutines.delay(1000)
            emit(i)
        }
    }.flowOn(Dispatchers.IO)
}