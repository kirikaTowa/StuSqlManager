package com.ywjh.stusqlmanager.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.ywjh.stusqlmanager.model.Constants


class AdminBaseHelpter(context: Context)
    : SQLiteOpenHelper(context, Constants.DATABASE_ADNAME,null, Constants.VERSIONCODE)  {
    override fun onCreate(dba: SQLiteDatabase?) {
        dba?.execSQL("create table Adinfo(_id integer,name varchar,pwd varchar)")

        var ftsql:String="insert into Adinfo(_id,name,pwd) values(?,?,?)"
        dba?.execSQL(ftsql, arrayOf(1, "Kirika", "1234567"))
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}