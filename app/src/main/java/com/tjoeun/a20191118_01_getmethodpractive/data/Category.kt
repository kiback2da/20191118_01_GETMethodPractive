package com.tjoeun.a20191118_01_getmethodpractive.data

import org.json.JSONObject

class Category {

    var title = ""
    var color = ""

    companion object{
        fun getCategory(json:JSONObject) : Category{
            var category = Category()
            category.title = json.getString("title")
            category.color = json.getString("color")

            return category
        }
    }
}