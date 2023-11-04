package com.example.ketevan_mdzinarishvili_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ThirdActivity : AppCompatActivity() {
    private var personalNumberEditText: EditText? = null
    private var nextBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        personalNumberEditText = findViewById(R.id.personalNumberEditText)
        nextBtn = findViewById(R.id.nextBtn);
        val bundle = intent.extras;
        val name = bundle?.getString("name");
        val age = bundle?.getString("age");
        Toast.makeText(this, age, Toast.LENGTH_LONG).show();
        nextBtn?.setOnClickListener{
            val personalNumber = personalNumberEditText?.text;
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("personalNumber", personalNumber.toString())
            startActivity(intent);
        }
    }
}