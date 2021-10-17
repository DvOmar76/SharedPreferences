package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var text=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        text= intent.getStringExtra("text").toString()
        textView.text=text

        btnGet.setOnClickListener {
            loadData()
        }


    }
    fun loadData(){
        val sharedPreferences = getSharedPreferences("preference_file_key", Context.MODE_PRIVATE)
        text= sharedPreferences.getString("text","").toString()
        textView.setText("current balance: $text ")
        textView.text=text


    }
}