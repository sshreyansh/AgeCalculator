package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {view->
            printAge(view)
        }

    }

    private fun printAge(view: View) {
        var myCalender =  Calendar.getInstance()
        var year = myCalender.get(Calendar.YEAR)
        var month = myCalender.get(Calendar.MONTH)
        var day = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{
                view, year, month, day ->
        // upar waali year, month, day will give user selected date

            val selectedDate = "$day/${month + 1}/$year"
            var textView1 = findViewById<TextView>(R.id.textView1)
            textView1.text = selectedDate

            var dob = Calendar.getInstance()
            // user ne jo date di
            dob.set(year, month, day)
                        // curr date                          //date user gives

            var age = myCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
            if(myCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--;
                // if born on 24/3/2000 and today is 20/3/2021 then above logic se age = 21
                // but age is 20
            }

            var textView2 = findViewById<TextView>(R.id.textView2)
            textView2.text = "Your age is $age"
        }
        ,year
        ,month,
        day).show()

    }
}
