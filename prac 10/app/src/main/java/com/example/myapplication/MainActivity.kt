package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var  btn: Button
    private lateinit var  textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextTextPersonName)
        btn = findViewById(R.id.button)
        textView = findViewById(R.id.textView2)
        val preferences = getSharedPreferences("str", MODE_PRIVATE)
        val edit = preferences.edit()
        textView.text = preferences.getString("str", "why?").toString()
        if (preferences.contains("str") ){
            btn.isClickable = false
            editText.isFocusable = false
        }
        else{
            btn.setOnClickListener{
                edit.putString("str", editText.text.toString())
                edit.apply()
                textView.text = preferences.getString("str", "why?").toString()
            }

        }


    }




}