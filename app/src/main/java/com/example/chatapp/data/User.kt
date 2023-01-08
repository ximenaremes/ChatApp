package com.example.chatapp.data

open class User{
    var name:String?= null
    var email:String?= null
    var password:String?=null
    var uid:String?=null

    constructor(){}

    constructor(name:String?, email:String?, uid:String?) : this() {
        this.name=name
        this.email = email
        this.uid = uid
    }

}