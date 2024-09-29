package edu.temple.baseassignment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf(
            "Select a color",
            "Red",
            "White",
            "Blue",
            "Gray",
            "Purple",
            "Green",
            "Yellow",
            "Magenta",
            "Silver",
            "Cyan",
            "Navy"
        )
        val spinner = findViewById<Spinner>(R.id.spinner)
        val layout = findViewById<View>(R.id.main)

        spinner.adapter = ColorAdapter(this, colors)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedColor = colors[position]

                // Check if a valid color is selected (skip "Select a color")
                if (selectedColor != "Select a color") {
                    // Change the layout background to the selected color
                    layout.setBackgroundColor(Color.parseColor(selectedColor))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }
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
        textView.setBackgroundColor(Color.WHITE)

        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = TextView(context)
        textView.text = colors[position]
        textView.textSize = 22f
        textView.setPadding(5, 10, 0, 10)

        if (position == 0) {
            textView.setBackgroundColor(Color.WHITE)
            textView.setTextColor(Color.BLACK)
        } else {
            textView.setBackgroundColor(Color.parseColor(colors[position]))
            textView.setTextColor(Color.BLACK)
        }

        return textView
    }

}