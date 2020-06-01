package com.ywjh.stusqlmanager.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.ywjh.studentmessagemanager.ViewModel.StudentDao
import com.ywjh.stusqlmanager.base.BaseFragment
import com.ywjh.stusqlmanager.R
import com.ywjh.stusqlmanager.adapter.HomeAdapter
import com.ywjh.stusqlmanager.model.StudentBean
import com.ywjh.stusqlmanager.utils.ThreadUtil
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast
import java.io.IOException

class HomeFragment: BaseFragment() {
    val adapter by lazy { HomeAdapter() }
    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        //2.1初始化layout的 recycler_view1
        recycler_view1.layoutManager = LinearLayoutManager(context)
        //适配 调用HomeAdapter

        recycler_view1.adapter = adapter
//        谷歌自带的刷新效果默认有点丑 初始化刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        //2.2设置刷新监听
//        可选1.内部只有一个方法 直接打开 2.和之前一样传一个匿名内部类

    }

    override fun initData() {
        var mDatas: MutableList<StudentBean>
        loadDatas()
    }

    private fun loadDatas() {

        val sdao = context?.let { StudentDao(it) }//获取context
        val flaglist = sdao?.query()
     /*不用toast每次都toast多麻烦
       flaglist.let {
            myToast("数据加载失败")
        }
        myToast("数据加载成功")*/



        ThreadUtil.runOnMainThread(object :Runnable{
            override fun run() {
                refreshLayout.isRefreshing=false
                if (flaglist != null) {
                    adapter.updateList(flaglist)
                }
            }
        })
    }
}