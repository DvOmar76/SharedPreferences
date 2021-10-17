package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    var text=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSaveToSHPFS.setOnClickListener {
            text="${ed1.text} | ${ed2.text}"
            saveData(text)
        }
        btnSharingThruIntent.setOnClickListener {
            text="${ed1.text} | ${ed2.text}"
            val intent=Intent(applicationContext,MainActivity2::class.java)
            intent.putExtra("text",text)
            startActivity(intent)
        }
    }

    fun saveData(text:String){

        val sharedPreferences = getSharedPreferences("preference_file_key", Context.MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.apply{
            putString("text",text)
        }.apply()
    }



}