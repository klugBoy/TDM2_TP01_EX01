package com.example.corona.exo_01

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {

    lateinit var shareRef : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        shareRef = getSharedPreferences("ColorPref",0)


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.colors,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
            spinner.setSelection(shareRef.getInt("background",-1))
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    savePreferece(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }

            }}


        button1.setOnClickListener { onClicklistener("1") }
        button2.setOnClickListener { onClicklistener("2") }
        button3.setOnClickListener { onClicklistener("3") }
    }

    fun onClicklistener(btn:String){
        val activity_class = when(btn){
            "1"-> MainActivity::class.java
            "2" -> Main2Activity::class.java
            "3" -> Main3Activity::class.java
            else -> null
        }
        val intent = Intent(this, activity_class).apply {
            putExtra("background", shareRef.getInt("background",-1))
        }
        startActivity(intent)
    }

    fun savePreferece(color:Int){
        val editor = shareRef.edit()
        editor.putInt("background",color)
        editor.commit()
    }
}
