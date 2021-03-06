package com.example.corona.exo_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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
