package com.example.smail.projectmob

import java.io.Serializable

data class Restaurant (var nom:String, var type:Char, var image:Int, var telephone:String,
                      var adresse:String, var mail:String, var fb:String) : Serializable {

}