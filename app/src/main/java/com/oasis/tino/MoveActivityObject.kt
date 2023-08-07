package com.oasis.tino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build

import android.widget.TextView

class MoveActivityObject : AppCompatActivity() {
    companion object{
        const val EXTRA_PERSON  =   "extraPerson"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        val receiver: TextView    =   findViewById(R.id.dataObjectReceived)
        val person  =    if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        }else{
            @Suppress("Deprecation")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if(person != null){
            val text        =   "Name : ${person.name}, email : ${person.email}, age : ${person.age} year(s) old, location : ${person.city}"
            receiver.text   =   text
        }
    }
}