package com.ywjh.stusqlmanager.ui.fragment

import android.graphics.Color
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.ywjh.studentmessagemanager.ViewModel.StudentDao
import com.ywjh.stusqlmanager.R
import com.ywjh.stusqlmanager.base.BaseFragment
import com.ywjh.stusqlmanager.utils.ThreadUtil
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_insert.*

class InsertFragment: BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_insert, null)
    }



    override fun initListener() {
        insert.setOnClickListener{
            loadDatas()
        }
    }

    private fun loadDatas() {
        val id: Int? =stid.text.toString().toInt()
        val name: String? =stname.text.toString()
        val sno: String? =stsno.text.toString()
        val stclass: String? =stclass.text.toString()
        val grade: Int? =stgrade.text.toString().toInt()


        val sdao = context?.let { StudentDao(it) }//获取context
        if (id != null) {
            sdao?.insert(id,name,sno,stclass,grade)
        }

           myToast("数据加载成功")


    }
}