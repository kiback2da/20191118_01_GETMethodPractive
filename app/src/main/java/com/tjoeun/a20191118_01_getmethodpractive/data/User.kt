package com.tjoeun.a20191118_01_getmethodpractive.data

import org.json.JSONObject

class User() {
    var login_id : String  = ""
    var name:String = ""
    var phone:String = ""

    var catetory = Category()

    companion object{
        fun getUserFromJson(json:JSONObject) : User{
            val user = User()
            user.login_id = json.getString("login_id")
            user.name = json.getString("name")
            user.phone = json.getString("phone")

            user.catetory = Category.getCategory(json.getJSONObject("category"))

            return  user
        }
    }
}