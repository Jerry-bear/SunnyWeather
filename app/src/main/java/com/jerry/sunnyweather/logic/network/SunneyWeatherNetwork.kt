package com.jerry.sunnyweather.logic.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.math.log


//定义一个统一的网络数据源访问入口，对所有网络请求的API进行封装
object SunneyWeatherNetwork {
    private val placeService=ServiceCreator.create<PlaceService>()
//此处serchPlace
    suspend fun searchPlaces(query:String)= placeService.searchPlace(query).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {continuation ->
            enqueue(object:Callback<T>{
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body=response.body()
                    Log.d("返回数据","${body.toString()}")
                    if (body!=null)continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null"))
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}