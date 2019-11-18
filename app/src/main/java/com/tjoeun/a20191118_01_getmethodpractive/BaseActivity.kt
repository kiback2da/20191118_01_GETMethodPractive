package com.tjoeun.a20191118_01_getmethodpractive

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    var mContext = this

    abstract fun setupEvents()
    abstract fun setValues()

}