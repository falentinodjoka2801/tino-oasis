package com.oasis.tino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

import android.widget.Button
import android.widget.EditText

class AsalSekolah : AppCompatActivity(), View.OnClickListener {
    companion object{
        const val EXTRA_RESULT_CODE =   100
        const val EXTRA_ASAL_SEKOLAH  =   "extra_selected_value"
    }

    private lateinit var asalSekolah: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asal_sekolah)

        asalSekolah = findViewById(R.id.asalSekolah)
        buttonSubmit = findViewById(R.id.buttonOK)

        buttonSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.buttonOK){
            val namaSekolah: String = asalSekolah.text.toString().trim()
            val comeBackIntent  =   Intent()
            comeBackIntent.putExtra(EXTRA_ASAL_SEKOLAH, namaSekolah)
            setResult(EXTRA_RESULT_CODE, comeBackIntent)
            finish()
        }
    }
}