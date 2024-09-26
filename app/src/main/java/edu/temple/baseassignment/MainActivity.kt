package edu.temple.baseassignment

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf("Red", "White", "Blue", "Gray", "Purple", "Green", "Yellow", "Magenta", "Silver", "Cyan", "Navy")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val canvas = findViewById<View>(R.id.colorDisplay)

    }
}