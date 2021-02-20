package com.jerry.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.jerry.sunnyweather.logic.Repository
import com.jerry.sunnyweather.logic.model.Place
import retrofit2.http.Query

class PlaceViewModel :ViewModel() {
    private val searchLiveData= MutableLiveData<String>()

    val placeList=ArrayList<Place>()

    val placeLiveData=Transformations.switchMap(searchLiveData){
        query->Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String){
        searchLiveData.value=query
    }
}