package edu.temple.baseassignment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf("Red", "White", "Blue", "Gray", "Purple", "Green", "Yellow", "Magenta", "Silver", "Cyan", "Navy")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val canvas = findViewById<View>(R.id.colorDisplay)

        spinner.adapter = ColorAdapter(this , colors)

    }
}

class ColorAdapter(_context: Context, _colors: Array<String>) : BaseAdapter(){

    private val context = _context
    private val colors = _colors

    override fun getCount(): Int {
        return colors.size
    }

    override fun getItem(p0: Int): Any {
        return colors[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val textView = TextView(context)
        textView.text = colors[p0]
        textView.textSize = 22f
        textView.setPadding(5, 10, 0, 10)
        return textView
    }

}