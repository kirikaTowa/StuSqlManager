package com.ywjh.stusqlmanager.utils
import android.widget.Toast
import com.ywjh.stusqlmanager.base.BaseFragment
import com.ywjh.stusqlmanager.ui.fragment.DeleteFragment
import com.ywjh.stusqlmanager.ui.fragment.HomeFragment
import com.ywjh.stusqlmanager.ui.fragment.InsertFragment
import com.ywjh.stusqlmanager.ui.fragment.UpdateFragment
import com.ywjh.stusqlmanager.R
import org.jetbrains.anko.support.v4.toast

//管理Fragment的Util类
//单例
class FragmentUtil private constructor(){//私有化构造方法
    val homeFragment by lazy { HomeFragment()  }
    val insertFragment by lazy { InsertFragment()  }
    val deleteFragment by lazy {DeleteFragment()  }
    val updateFragment by lazy { UpdateFragment()  }

    companion object{//伴生对象
        val fragmentUtil by lazy { FragmentUtil() }
    }
//通过封装类选择进入那个 Fragment
    fun getFragment(tabId:Int): BaseFragment {//Base返回值默认不支持为空

        when(tabId){
            R.id.tab_home -> return  homeFragment
            R.id.tab_insert -> return  insertFragment
            R.id.tab_delete-> return  deleteFragment
            R.id.tab_update -> return  updateFragment
        }

        //都没有就加null 非空判断 BaseFragment不支持空 所以加个？ 或者默认给homeFragment
        return  homeFragment
    }
}