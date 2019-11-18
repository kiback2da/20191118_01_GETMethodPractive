package com.tjoeun.a20191118_01_getmethodpractive

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191118_01_getmethodpractive.util.ContextUtil
import com.tjoeun.a20191118_01_getmethodpractive.util.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        loginChkBoxRememberID.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                ContextUtil.setRememberId(mContext,true)
            }else{
                ContextUtil.setRememberId(mContext,false)
            }

            Log.d("로그 : loginChkBox","${ContextUtil.getRememberId(mContext)}")
        }

        loginChkBoxAutoLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                ContextUtil.setAutoLogin(mContext,true)
            }else{
                ContextUtil.setAutoLogin(mContext,false)
            }
        }

        loginBtnLogin.setOnClickListener {

            ServerUtil.postRequestLogin(mContext,loginEdtID.text.toString(),loginEdtPassword.text.toString(),object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    Log.d("로그 : json","${json.toString()}")
                    var code = json.getInt("code")
                    if(code == 200){
                        val data = json.getJSONObject("data")
                        var token = data.getString("token")
                        ContextUtil.setToken(mContext,token)

                        var intent = Intent(mContext,MainActivity::class.java)



                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(mContext,"로그인 실패",Toast.LENGTH_SHORT).show()
                    }
                }

            })

            if(loginChkBoxRememberID.isChecked){
                ContextUtil.setUserId(mContext,loginEdtID.text.toString())
                Toast.makeText(mContext,"아이디를 저장했습니다..",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(mContext,"아이디를 저장하지 않습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun setValues() {
        var remeberId = ContextUtil.getRememberId(mContext)

        if(remeberId){
            loginChkBoxRememberID.isChecked = true
            loginEdtID.setText(ContextUtil.getUserId(mContext))
        }else{
            loginChkBoxRememberID.isChecked = false
        }

    }
}
