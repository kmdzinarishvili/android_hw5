package com.example.ketevan_mdzinarishvili_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private var ageEditText: EditText? = null
    private var nextBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ageEditText = findViewById(R.id.ageEditText)
        nextBtn = findViewById(R.id.nextBtn);
        val bundle = intent.extras;
        val name = bundle?.getString("name");
        nextBtn?.setOnClickListener{
            val age = ageEditText?.text;
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age.toString())
            startActivity(intent);
        }
    }
}

