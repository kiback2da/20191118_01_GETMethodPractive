package com.tjoeun.a20191118_01_getmethodpractive.util

import android.content.Context

class ContextUtil {

    companion object{
        //메모장의 파일 이름에 대응되는 개념
        val prefName = "ContextPreference"

        //사용자의 id를 저장하는 항목 이름
        val USER_ID = "USER_ID"
        val REMEMBER_ID = "REMEMBER_ID"
        val AUTO_LOGIN = "AUTO_LOGIN"
        val TOKEN = "TOKEN"

        //사용자 ID를 저장해주는 fun => setter
        fun setUserId(context: Context, userid:String){
            //메모장(파일이름 : ContextPreference)을 실제로 여는 동작
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            //메모장에 내용을 작성하고 저장하는 부분
            pref.edit().putString(USER_ID,userid).apply()
        }

        fun setRememberId(context: Context, rememberId:Boolean){
            //메모장(파일이름 : ContextPreference)을 실제로 여는 동작
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            //메모장에 내용을 작성하고 저장하는 부분
            pref.edit().putBoolean(REMEMBER_ID,rememberId).apply()
        }

        fun setAutoLogin(context: Context, autoLogin:Boolean){
            //메모장(파일이름 : ContextPreference)을 실제로 여는 동작
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            //메모장에 내용을 작성하고 저장하는 부분
            pref.edit().putBoolean(AUTO_LOGIN,autoLogin).apply()
        }

        fun setToken(context: Context, token:String){
            //메모장(파일이름 : ContextPreference)을 실제로 여는 동작
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            //메모장에 내용을 작성하고 저장하는 부분
            pref.edit().putString(TOKEN,token).apply()
        }

        fun getUserId(context: Context) : String{
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return pref.getString(USER_ID,"")!!
        }

        fun getRememberId(context: Context) : Boolean{
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return pref.getBoolean(REMEMBER_ID,false)
        }

        fun getAutoLoigin(context: Context) : Boolean{
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return pref.getBoolean(AUTO_LOGIN,false)
        }

        fun getToken(context: Context) : String{
            var pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

            return pref.getString(TOKEN,"")!!
        }
    }

}