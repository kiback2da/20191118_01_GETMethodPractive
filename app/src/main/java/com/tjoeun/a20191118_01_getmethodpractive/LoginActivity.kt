package com.tjoeun.a20191118_01_getmethodpractive

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191118_01_getmethodpractive.util.ContextUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Log.d("로그 : ContextUtil","${}")

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        loginBtnLogin.setOnClickListener {
            if(loginChkBoxRememberID.isChecked){
                ContextUtil.setUserId(mContext,loginEdtID.text.toString())
                Toast.makeText(mContext,"아이디를 저장했습니다..",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(mContext,"아이디를 저장하지 않습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setValues() {

    }
}
