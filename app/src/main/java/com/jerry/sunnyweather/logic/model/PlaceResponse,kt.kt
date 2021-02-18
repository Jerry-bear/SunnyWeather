package com.jerry.sunnyweather.logic.model

import android.telephony.cdma.CdmaCellLocation
import com.google.gson.annotations.SerializedName

//此文件用于定义各个类的属性
data class PlaceResponse(val status:String,val places :List<Place>)

//此处注解表示有些地方可能JSON中一些字段和kotlin的明明规范可能不一致，直线映射关系
data class Place(val name:String,val location: Location,@SerializedName("formatted_address") val address: String)

data class Location(val lng:String,val lat:String)