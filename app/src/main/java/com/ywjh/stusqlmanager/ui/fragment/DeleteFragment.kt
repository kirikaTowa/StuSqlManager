package com.ywjh.stusqlmanager.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.ywjh.studentmessagemanager.ViewModel.StudentDao
import com.ywjh.stusqlmanager.R
import com.ywjh.stusqlmanager.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_delete.*
import kotlinx.android.synthetic.main.fragment_insert.*

class DeleteFragment: BaseFragment() {
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_delete, null)
    }

    override fun initListener() {
        delete.setOnClickListener{
            loadDatas()
        }

    }
    private fun loadDatas() {
        val id: Int? =editdelete.text.toString().toInt()
        val sdao = context?.let { StudentDao(it) }//获取context
        id?.let {
            sdao?.deletebyid(id)
        }

        myToast("数据删除成功")


    }
}