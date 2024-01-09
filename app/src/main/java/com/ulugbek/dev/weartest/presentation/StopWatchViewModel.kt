package com.ulugbek.dev.weartest.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow

class StopWatchViewModel:ViewModel() {
    private val _offTime=MutableStateFlow(0L)
    private val _timerState= MutableStateFlow(TimerState.RESET)
    val timerState=_timerState.asStateFlow()


    private fun  getTimerFlow(isRunning:Boolean):Flow<Long>{


        return flow {
            var startMills=System.currentTimeMillis()
            while (isRunning){
                val currentMillis = System.currentTimeMillis()
                val timeDiff= if (currentMillis>startMills){
                    currentMillis-startMills
                }else 0L

                emit(timeDiff)
            }
        }
    }
}