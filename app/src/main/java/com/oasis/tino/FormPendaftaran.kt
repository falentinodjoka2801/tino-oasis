package com.oasis.tino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View

import android.widget.EditText
import android.widget.Button
import android.widget.TextView

import androidx.activity.result.contract.ActivityResultContracts

class FormPendaftaran : AppCompatActivity(), View.OnClickListener {
    private lateinit var nama: EditText
    private lateinit var alamat: EditText
    private lateinit var asalSekolah: TextView
    private lateinit var buttonAsalSekolah: Button
    private lateinit var buttonSubmit: Button

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        resultLauncher -> if(resultLauncher.resultCode == AsalSekolah.EXTRA_RESULT_CODE){
            val namaAsalSekolah   =   resultLauncher.data?.getStringExtra(AsalSekolah.EXTRA_ASAL_SEKOLAH);
            asalSekolah.text    =   namaAsalSekolah
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pendaftaran)

        nama                =   findViewById(R.id.nama)
        alamat              =   findViewById(R.id.alamat)
        asalSekolah         =   findViewById(R.id.asalSekolah)
        buttonAsalSekolah   =   findViewById(R.id.buttonAsalSekolah)
        buttonSubmit        =   findViewById(R.id.buttonSubmit)

        buttonAsalSekolah.setOnClickListener(this)
        buttonSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.buttonAsalSekolah){
            val pilihAsalSekolahIntent  =   Intent(this@FormPendaftaran, AsalSekolah::class.java)
            resultLauncher.launch(pilihAsalSekolahIntent)
        }
    }
}