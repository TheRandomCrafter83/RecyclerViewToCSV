package com.coderz.f1.recyclerviewtocsv.models

data class Person(
    val key:String,
    val firstName:String,
    val lastName:String
){
    fun toCSVString():String{
        return "$firstName,$lastName"
    }
}
