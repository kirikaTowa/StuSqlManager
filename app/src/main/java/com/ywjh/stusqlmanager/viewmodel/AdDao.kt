package com.ywjh.studentmessagemanager.ViewModel

import android.content.Context
import com.ywjh.stusqlmanager.model.Constants
import com.ywjh.stusqlmanager.utils.AdminBaseHelpter


class AdDao(val appContext: Context) {
    private var adhelper: AdminBaseHelpter?=null

    fun query() {
        adhelper = AdminBaseHelpter(appContext)
        val db = adhelper?.getWritableDatabase()//获取到数据库后对表进行查找
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


        val cursor = db?.query(Constants.TABLE_SNAME, null, null, null, null, null, null)
        while (cursor?.moveToNext()!!) {
            val id = cursor?.getInt(0)
            val name = cursor?.getString(1)

        }
        cursor?.close()
        db?.close()//关闭相关引用
    }
}