package com.ywjh.studentmessagemanager.ViewModel

import android.content.ContentValues
import android.content.Context
import android.support.v4.app.INotificationSideChannel
import android.util.Log
import com.ywjh.stusqlmanager.model.Constants
import com.ywjh.stusqlmanager.model.StudentBean
import com.ywjh.stusqlmanager.utils.StudentbaseHelpter
import kotlinx.android.synthetic.main.fragment_home.*


class StudentDao(val appContext: Context) {
    private var mhelper: StudentbaseHelpter?=null
    internal lateinit var mDatas: MutableList<StudentBean>
    fun insert(sid :Int,sname:String?,sno:String?,sclass:String?,sgrade:Int?) {
        mhelper = StudentbaseHelpter(appContext)
        //写入
        val db = mhelper?.getWritableDatabase()//获取到数据库后对表进行查找

       /* val sql =
            "insert into studentinfo(_id,name,sno,class,grade) values(?,?,?,?,?)"
            db?.execSQL(sql, arrayOf(1, "Kirika", "18", "1",80))*/
        val values = ContentValues()//接着添加数据
        values.put("_id", sid)
        values.put("name",sname)
        values.put("sno", sno)
        values.put("class", sclass)
        values.put("grade", sgrade)
        db?.insert(Constants.TABLE_SNAME, null, values)//二参数是可否为空字段  三参数是填充内容 hashMap结构
        db?.close()//关闭相关引用
    }

    fun deletebyid(sid: Int) {
        mhelper = StudentbaseHelpter(appContext)
        val db = mhelper?.getWritableDatabase()//获取到数据库后对表进行查找
        /*var sql:String="delete from "+Constants.TABLE_SNAME+ " where _id="+sid
        db?.execSQL(sql);*/
        db?.delete(Constants.TABLE_SNAME, "_id=?", arrayOf(sid.toString()));

        db?.close()//关闭相关引用
    }


    fun update(sid :Int,sname:String?,sno:String?,sclass:String?,sgrade:Int?) {
        mhelper = StudentbaseHelpter(appContext)
        val db = mhelper?.getWritableDatabase()//获取到数据库后对表进行查找
      /*  val sql="update "+Constants.TABLE_SNAME+ " set salary=2 where id=2"
        db?.execSQL(sql);*/

        val values = ContentValues()//接着添加数据
            values.put("name", sname)
            values.put("sno", sno)
            values.put("class", sclass)
            values.put("grade", sgrade)

        db?.update(Constants.TABLE_SNAME, values, "_id=?",arrayOf(sid.toString()))//null为所有记录
        db?.close()//关闭相关引用
    }

    fun query(): MutableList<StudentBean> {
        mDatas = ArrayList<StudentBean>()
        mhelper = StudentbaseHelpter(appContext)
        val db = mhelper?.getWritableDatabase()//获取到数据库后对表进行查找
        /*   String sql="select * from "+Constants.TABLE_NAME;
        //db.execSQL(sql); 这个方法无返回值的
        Cursor cursor= db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int index=cursor.getColumnIndex("name");
            String name=cursor.getString(index);
            Log.d(TAG,name);
            //cursor.getString(1);//获取第一列，从0开始且不含首为计数列
        }
        cursor.close();//资源型关闭*/

        var bean:StudentBean?=null
        val cursor = db?.query(Constants.TABLE_SNAME, null, null, null, null, null, null)
        while (cursor?.moveToNext()!!) {
            val id = cursor?.getInt(0)
            val name = cursor?.getString(1)
            val sno=cursor?.getString(2)
            val stclass =cursor?.getString(3)
            val grade=cursor?.getInt(4)

            //println("11111+$id 22222+$name 33333+$sno 44444+$stclass 5555+$grade")
            bean=StudentBean(id,name,sno,stclass,grade)
            mDatas.add(bean)
        }
        cursor?.close()
        db?.close()//关闭相关引用


        return mDatas
    }

}