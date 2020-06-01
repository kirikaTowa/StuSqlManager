package com.ywjh.stusqlmanager.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.ywjh.stusqlmanager.model.Constants


class StudentbaseHelpter(context: Context?) :
    SQLiteOpenHelper(context, Constants.DATABASE_NAME,null, Constants.VERSIONCODE) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table studentinfo(_id integer,name varchar,sno varchar,class varchar,grade int)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}