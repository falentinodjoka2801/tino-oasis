package com.oasis.tino

import android.content.Intent
import android.net.Uri
import android.os.Bundle

import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonMoveActivity: Button
    private lateinit var buttonMoveActivityWithData: Button
    private lateinit var buttonMoveActivityObject: Button
    private lateinit var buttonDialNumber: Button
    private lateinit var buttonMoveForResultActivity: Button
    private lateinit var hasilActivity: TextView

    private val resultLauncher  =   registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result -> if(result.resultCode == MoveForResultActivity.RESULT_CODE){
        val selectedValue   =    result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
        hasilActivity.text  =   "Hasil : $selectedValue"
    }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonMoveActivity          =   findViewById(R.id.buttonMoveActivity)
        buttonMoveActivityWithData  =   findViewById(R.id.buttonMoveActivityWithData)
        buttonMoveActivityObject    =   findViewById(R.id.buttonMoveActivityWithObject)
        buttonDialNumber            =   findViewById(R.id.buttonDialNumber)
        buttonMoveForResultActivity =   findViewById(R.id.buttonMoveForResult)
        hasilActivity               =   findViewById(R.id.hasilActivity)

        buttonMoveActivity.setOnClickListener(this)
        buttonMoveActivityWithData.setOnClickListener(this)
        buttonMoveActivityObject.setOnClickListener(this)
        buttonDialNumber.setOnClickListener(this)
        buttonMoveForResultActivity.setOnClickListener(this)
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
        if(view?.id == R.id.buttonMoveActivityWithObject){
            val person  =   Person("Tino Oasis", 23, "falentinodjoka2801@gmail.com", "Kota Medan")
            val moveIntentWithObject    =   Intent(this@MainActivity, MoveActivityObject::class.java)
            moveIntentWithObject.putExtra(MoveActivityObject.EXTRA_PERSON, person)
            startActivity(moveIntentWithObject)
        }
        if(view?.id == R.id.buttonDialNumber){
            val phoneNumber     =   "082362249483"
            val dialPhoneIntent     =   Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }
        if(view?.id == R.id.buttonMoveForResult){
            val moveForResultIntent     =   Intent(this@MainActivity, MoveForResultActivity::class.java)
            resultLauncher.launch(moveForResultIntent)
        }
    }
}