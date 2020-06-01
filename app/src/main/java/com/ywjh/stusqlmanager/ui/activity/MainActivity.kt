package com.ywjh.stusqlmanager.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.ywjh.stusqlmanager.base.BaseActivity
import com.ywjh.stusqlmanager.R
import com.ywjh.stusqlmanager.utils.FragmentUtil
import com.ywjh.stusqlmanager.utils.ToolBarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(),ToolBarManager {
    override fun getLayoutid(): Int {
        return R.layout.activity_main
    }
    override val toolbar by lazy{find<Toolbar>(R.id.tb_toolbar)}

    override fun initDate() {
        initMainToolBar()
    }

    override fun initListener() {
        bottomBar.setOnTabSelectListener{
            // it代表参数id
            val transaction = supportFragmentManager.beginTransaction()
            //将当前container替换为第二个参数由FragmentUtil获取
            transaction.replace(R.id.container, FragmentUtil.fragmentUtil.getFragment(it),it.toString())//it后需要一个tag
            transaction.commit()
        }

    }
}
