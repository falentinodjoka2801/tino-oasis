package com.oasis.tino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

class MoveActivityData : AppCompatActivity() {
    companion object{
        const val EXTRA_AGE     =   "extraAge"
        const val EXTRA_NAME    =   "extraName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_data)

        val dataReceived: TextView  =   findViewById(R.id.dataReceived)

        val name    =   intent.getStringExtra(EXTRA_NAME)
        val age     =   intent.getIntExtra(EXTRA_AGE, 0)

        val text            =   "Name : $name, and your age is $age year(s) old"
        dataReceived.text   =   text
    }
}