package com.ywjh.stusqlmanager.ui.activity

import androidx.appcompat.app.AppCompatActivity
import com.ywjh.stusqlmanager.R
import com.ywjh.stusqlmanager.base.BaseActivity
import com.ywjh.stusqlmanager.utils.AdminBaseHelpter
import com.ywjh.stusqlmanager.utils.StudentbaseHelpter
import kotlinx.android.synthetic.main.acitvity_login.*

class LoginActivity : BaseActivity() {

    override fun getLayoutid(): Int {
        return R.layout.acitvity_login
    }

    var username:String="111"
    var pwd:String="111"


    override fun initDate() {
        //注册学生与管理员数据库
        val helpter = StudentbaseHelpter(this)
        helpter.writableDatabase
        val adhelpter = AdminBaseHelpter(this)
        adhelpter.writableDatabase
    }
    override fun initListener() {
        Login.setOnClickListener{
            username= usernamet.text.toString()
            pwd= pwdt.text.toString()
            startActivityAndFinish<MainActivity>()
        }
    }
}
