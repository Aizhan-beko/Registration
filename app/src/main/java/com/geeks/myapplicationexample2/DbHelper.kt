package com.geeks.myapplicationexample2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, "app", factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "Create table users(int PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF  EXISTS users")
        onCreate(db)
    }
    fun addUser(user:User){
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.password)

        val db = writableDatabase
        db.insert("users", null, values)

        db.close()

    }

}