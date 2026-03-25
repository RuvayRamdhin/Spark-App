package com.example.sparkapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DialogTitle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.TextViewCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //Declarations of variables
    private lateinit var tvTitle: TextView
    private lateinit var tvResult: TextView
    private lateinit var edtSparkOption: EditText
    private lateinit var btnCheckSpark: Button
    private lateinit var btnReset: Button
    private lateinit var btnOptions: Button

    private lateinit var tvOption: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Initializing values (TypeCasting)
        tvTitle = findViewById(R.id.tvTitle)
        tvResult = findViewById(R.id.tvResult)
        edtSparkOption = findViewById(R.id.edtSparkOption)
        btnCheckSpark = findViewById(R.id.btnCheckSpark)
        btnReset = findViewById(R.id.btnReset)
        btnOptions = findViewById(R.id.btnOptions)
        tvOption = findViewById(R.id.tvOptions)

        //Predefining each spark that is going to used
        val morning = "Send a 'Good morning' text to a family member."
        val midmorning = "Reach out to a colleague with a quick 'Thank you'."
        val afternoon = "Share a funny meme or interesting link with a friend."
        val afternoonSnackTime = "Send a quick 'thinking of you' message."
        val dinner = "Call a friend or relative for a 5-minute catch-up."
        val night = "Leave a thoughtful comment on a friend's post."

        btnCheckSpark.setOnClickListener {
            //IF statements will go here.
            //if the user inputs anytime of the day it will show them the response
            if(edtSparkOption.text.toString().lowercase() == "morning"){
                tvResult.text = morning
            }
            else if(edtSparkOption.text.toString().lowercase() == "midmorning" ||
                edtSparkOption.text.toString().lowercase() == "mid-morning"){
                tvResult.text = midmorning
            }
            else if(edtSparkOption.text.toString().lowercase() == "afternoon"){
                tvResult.text = afternoon
            }
            else if(edtSparkOption.text.toString().lowercase() == "afternoon snack time"){
                tvResult.text = afternoonSnackTime
            }
            else if(edtSparkOption.text.toString().lowercase() == "dinner"){
                tvResult.text = dinner
            }
            else if(edtSparkOption.text.toString().lowercase() == "night" ||
                edtSparkOption.text.toString().lowercase() == "after dinner"){
                tvResult.text = night
            }
            //This is when the user does not enter the correct input
            //This is an Error check
            else{
                tvResult.text = "Invalid input"
            }

        }
        //This will clear the screen
        btnReset.setOnClickListener {
            tvResult.text = " "//By adding " " you are clearing the output from the screen

        }
        //This button is to show the user what inputs they can put in
        //It gives them less room for errors
        btnOptions.setOnClickListener {
            tvResult.text = "Options for time of day: morning, mid-morning, afternoon, afternoon snack time, dinner, night/after dinner"
        }


















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}