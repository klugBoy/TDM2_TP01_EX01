package com.example.corona.exo_01

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val extras = intent.extras
        val color_index = extras!!.getInt("background")
        val arary_colors = resources.getStringArray(R.array.values)
        if (color_index!=-1) activity_layout.setBackgroundColor(Color.parseColor(arary_colors[color_index]))


        go_back.setOnClickListener {
            val intent_back = Intent(this, SettingsActivity::class.java)
            startActivity(intent_back)
            finish()
        }

        }
    }

