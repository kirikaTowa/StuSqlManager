package com.ywjh.stusqlmanager.widget


import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.ywjh.stusqlmanager.R
import com.ywjh.stusqlmanager.model.StudentBean
import kotlinx.android.synthetic.main.item_home.view.*


class HomeItemView : RelativeLayout{
//适配adapter

    //复写三个次级构造方法
    //代码new相关
    constructor(context: Context?) : super(context)
    //清单文件相关
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    //主题相关
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)
/*初始化方法 调用主，次构造方法都会执行
下面阶段的inflate方法传入一个xml文件进行调用
* */

    init {
    //this 当前的xml文件解析为view传过去 填null则应写addview
        View.inflate(context,R.layout.item_home,this)
    }
    /*刷新条目view数据*/
    fun setDate(data: StudentBean) {
        sid.setText(data.get_id().toString())
        name.setText(data.getname())
        sno.setText(data.getsno())
        stclass.setText(data.getstclass())
        grade.setText(data.getgrade().toString())
    }



}