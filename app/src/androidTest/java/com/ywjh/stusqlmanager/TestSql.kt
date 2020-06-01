package com.ywjh.stusqlmanager

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.ywjh.studentmessagemanager.ViewModel.StudentDao
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestSql {
    val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun testInsert() {
        // Context of the app under test.
        val sdao: StudentDao = StudentDao(appContext)

        sdao.insert(6,"周志昂","201701014145","171",95)
    }

    @Test
    fun testDelete() {
        // Context of the app under test.
        val sdao:StudentDao=StudentDao(appContext)

        sdao.deletebyid(1)
    }
    @Test
    fun testQuery() {
        //测试查找数据
        val sdao = StudentDao(appContext)
        sdao.query()
    }
    @Test
    fun testUpdate() {
        // Context of the app under test.
        val sdao: StudentDao = StudentDao(appContext)

        sdao.update(4,"Jack","201901014104","171",99)
    }



}