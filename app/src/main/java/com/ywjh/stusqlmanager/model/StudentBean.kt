package com.ywjh.stusqlmanager.model

import android.graphics.Bitmap
import android.net.Uri

class StudentBean {
    private var _id: Int? = null //歌曲id
    private var name: String? = null //歌曲名称
    private var sno: String? = null //歌手名称
    private var stclass: String? = null //专辑名称
    private var grade: Int? = null //歌曲时长

    constructor(_id: Int?, name: String?, sno: String?, stclass: String?, grade: Int?) {
        this._id = _id
        this.name = name
        this.sno = sno
        this.stclass = stclass
        this.grade = grade
    }

    fun get_id(): Int? {
        return _id
    }

    fun set_id(_id: Int) {
        this._id = _id
    }
    fun getname(): String? {
        return name
    }

    fun setname(name: String) {
        this.name = name
    }


    fun getsno(): String? {
        return sno
    }

    fun setsno(sno: String) {
        this.sno = sno
    }

    fun getstclass(): String? {
        return stclass
    }

    fun setstclass(stclass: String) {
        this.stclass = stclass
    }

    fun getgrade(): Int? {
        return grade
    }

    fun setgrade(grade: Int){
        this.grade = grade
    }

    override fun toString(): String {
        return "StudentBean(_id=$_id, name=$name, sno=$sno, stclass=$stclass, grade=$grade)"
    }

}