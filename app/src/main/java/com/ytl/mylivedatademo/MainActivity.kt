package com.ytl.mylivedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myNum = findViewById<TextView>(R.id.tvNum)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.startTimer()

        viewModel.seconds().observe(this, Observer {
            myNum.text = it.toString()
        })

        viewModel.finished().observe(this, Observer {
            if(it){
                Toast.makeText(this, "count down completed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}