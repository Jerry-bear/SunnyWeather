package com.jerry.sunnyweather.logic

import androidx.lifecycle.liveData
import com.jerry.sunnyweather.logic.model.Place
import com.jerry.sunnyweather.logic.network.SunneyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Query
import java.lang.RuntimeException

//仓库层
object Repository {
    fun searchPlace(query: String)= liveData(Dispatchers.IO){
        val result=try {
            val placeResponse=SunneyWeatherNetwork.searchPlaces(query)
            if(placeResponse.status=="ok"){
                val places=placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is" +
                        "${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}