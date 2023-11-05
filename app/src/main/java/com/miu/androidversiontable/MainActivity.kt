package com.miu.androidversiontable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.TableRow
import android.widget.TextView
import com.miu.androidversiontable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //static
        addRow("Android 9.0", "Pie")
        addRow("Android 8.0", "Oreo")

        //new
        binding.addBtn.setOnClickListener {
            addRow(binding.androidVer.text.toString(), binding.codeName.text.toString())
        }

    }

    private fun addRow(version:String, code:String){
        if(version.isNotEmpty() && code.isNotEmpty()){
            val row = TableRow(this)
            row.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT)

            val firstTextView = TextView(this)
            firstTextView.text=version.toString()
            firstTextView.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1f)

            val secondTextView = TextView(this)
            secondTextView.text=code.toString()
            secondTextView.layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1f)


            row.addView(firstTextView)
            row.addView(secondTextView)
            binding.tableLayout.addView(row)

        }
    }


}