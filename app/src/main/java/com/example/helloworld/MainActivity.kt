package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // To get reference to button
        //val btnClickMe = findViewById(R.id.button) as Button
        //var myTextView = findViewById(R.id.textView) as TextView
        // Kotlin reduces the above lines to direct calling

        var timesClicked = 0

        // set on-click listener
        button.setOnClickListener {
            timesClicked += 1
            textView.text = timesClicked.toString()
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }
}
