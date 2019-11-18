package com.tjoeun.a20191118_01_getmethodpractive

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        loginBtnLogin.setOnClickListener {
            if(loginChkBoxRememberID.isChecked){
                Toast.makeText(mContext,"아이디를 저장해야 합니다.",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(mContext,"아이디를 저장하지 않습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setValues() {

    }
}
