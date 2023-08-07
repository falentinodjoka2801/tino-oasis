package com.oasis.tino

import android.content.Intent
import android.os.Bundle

import android.view.View

import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonMoveActivity: Button
    private lateinit var buttonMoveActivityWithData: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMoveActivity          =   findViewById(R.id.buttonMoveActivity)
        buttonMoveActivityWithData  =   findViewById(R.id.buttonMoveActivityWithData)
        buttonMoveActivity.setOnClickListener(this)
        buttonMoveActivityWithData.setOnClickListener(this)
    }
    override fun onClick(view: View?){
        if(view?.id == R.id.buttonMoveActivity){
            val moveIntent  =   Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(moveIntent)
        }
        if(view?.id == R.id.buttonMoveActivityWithData){
            val name: EditText  =   findViewById(R.id.name)
            val age: EditText = findViewById(R.id.age)

            val nameValue: String   =   name.text.toString().trim()
            val ageValue: Int       =   age.text.toString().trim().toInt()

            val moveWithDataIntent  =   Intent(this@MainActivity, MoveActivityData::class.java)
            moveWithDataIntent.putExtra(MoveActivityData.EXTRA_NAME, nameValue)
            moveWithDataIntent.putExtra(MoveActivityData.EXTRA_AGE, ageValue)
            startActivity(moveWithDataIntent)
        }
    }
}