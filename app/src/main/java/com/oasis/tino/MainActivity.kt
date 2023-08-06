package com.oasis.tino

import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var panjang: EditText
    private lateinit var lebar: EditText
    private lateinit var tinggi: EditText
    private lateinit var buttonHitung: Button
    private lateinit var hasil: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panjang =   findViewById(R.id.panjang)
        lebar   =   findViewById(R.id.lebar)
        tinggi  =   findViewById(R.id.tinggi)
        buttonHitung    =   findViewById(R.id.hitung)
        hasil   =   findViewById(R.id.hasil)

        buttonHitung.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.hitung){
            val panjangValue    =   panjang.text.toString().trim()
            val lebarValue      =   lebar.text.toString().trim()
            val tinggiValue     =   tinggi.text.toString().trim()

            var fieldEmpty  =   false
            if(panjangValue.isEmpty()){
                fieldEmpty      =   true
                panjang.error   =   "Panjang tidak boleh kosong!"
            }
            if(lebarValue.isEmpty()){
                fieldEmpty  =   true
                lebar.error =   "Lebar tidak boleh kosong"
            }
            if(tinggiValue.isEmpty()){
                fieldEmpty      =   true
                tinggi.error    =   "Tinggi tidak boleh kosong"
            }

            if(!fieldEmpty) {
                val volume =
                    panjangValue.toDouble() * lebarValue.toDouble() * tinggiValue.toDouble()
                hasil.text = volume.toString()
            }
        }
    }
}