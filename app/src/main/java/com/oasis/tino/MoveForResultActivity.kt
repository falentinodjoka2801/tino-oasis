package com.oasis.tino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.RadioGroup
import android.widget.Button

import android.view.View

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_SELECTED_VALUE  =   "extraSelectedValue"
        const val RESULT_CODE   =   100
    }

    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonChoose: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        radioGroup      =   findViewById(R.id.radioGroupNumber)
        buttonChoose    =   findViewById(R.id.buttonChoose)

        buttonChoose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.buttonChoose){
            var value   =   0
            when(radioGroup.checkedRadioButtonId){
                R.id.rb50   ->  value   =   50
                R.id.rb100  ->  value   =   100
                R.id.rb150  ->  value   =   150
                R.id.rb200  ->  value   =   200
            }

            val resultIntent    =   Intent()
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }
}