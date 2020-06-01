package com.ywjh.stusqlmanager.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ywjh.stusqlmanager.model.StudentBean
import com.ywjh.stusqlmanager.utils.StudentbaseHelpter
import com.ywjh.stusqlmanager.widget.HomeItemView


//创建Adapter进行处理   传入<homeholder>泛型
class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeHolder>(){

    //add 1.更新数据的操作   刷新操作建立List集合 接收数据
    private var list=ArrayList<StudentBean>()//用里面的list匿名内部类
  //在集合中先清空  再添加
    fun updateList(list: List<StudentBean>){//传入一个对应集合 到时候侧试一下传原lei还是内部类
        this.list.clear()
        this.list.addAll(list)//牛逼
        notifyDataSetChanged()//刷新一下
    }


//调用HomeItemView进行home页面的填充 创建了条目view
//1.需要一个HomeHolder
//   通过Holder将view保存下来
    class HomeHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
//2.复写三个次级构造方法
    //2.1 条目初始化进行数据绑定
    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
    //能显示几条后再进行数据绑定
        //如果是最后一条就不刷新view
        if(position==list.size)
            return
        //1.拿到条目数据
        val data=list.get(position)
        //2.拿到条目View
        val itemView=holder.itemView as HomeItemView
        //3.条目刷新
        itemView.setDate(data)
}


    //2.2返回条目数量-指的是产生fragment条目
    override fun getItemCount(): Int {
        /*在抓取类中限定size 最后的+1的空间放一个进度条，实现上拉加载更多的条目
        * 进度条可以提取一个单独的view显示*/
        return list.size  //用1.add建立的列表就可以调用list了
        //最后一条显示进度条
    }
    //2.3 拿到homeView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {

            return HomeHolder(HomeItemView(parent?.context))


    }
    //2.4根据位置返回type值 绝对界面或刷新框
    override fun getItemViewType(position: Int): Int {
        if(position==list.size)
            return 1
        else
            return 0
    }

}