package com.example.ketevan_mdzinarishvili_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FourthActivity : AppCompatActivity() {
    private var nameTextView: TextView? = null
    private var ageTextView: TextView? = null
    private var personalNumberTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)
        val bundle = intent.extras;
        val name = bundle?.getString("name");
        val age = bundle?.getString("age");
        val personalNumber = bundle?.getString("personalNumber");
        nameTextView = findViewById(R.id.nameTextView);
        ageTextView = findViewById(R.id.ageTextView);
        personalNumberTextView = findViewById(R.id.personalNumberTextView)

        nameTextView?.text = name;
        ageTextView?.text = age;
        personalNumberTextView?.text = personalNumber;

    }
}