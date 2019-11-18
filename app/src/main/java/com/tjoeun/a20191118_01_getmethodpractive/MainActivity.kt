package com.tjoeun.a20191118_01_getmethodpractive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191118_01_getmethodpractive.data.User
import com.tjoeun.a20191118_01_getmethodpractive.util.ServerUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
        ServerUtil.getRequestMyInfo(mContext,object : ServerUtil.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("로그 : MyInfo",json.toString())
                
                val data = json.getJSONObject("data")
                val user = json.getJSONObject("user")

                var me = User.getUserFromJson(user)

                runOnUiThread {
                    mainTxtId.text = me.login_id
                    mainTxtName.text = me.name
                    mainTxtPhone.text = me.phone

                    mainTxtCategory.text = me.catetory.title
                }
            }

        })
    }
}
