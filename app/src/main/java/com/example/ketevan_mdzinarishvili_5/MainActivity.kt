package com.example.ketevan_mdzinarishvili_5

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ketevan_mdzinarishvili_5.TimeReceiver.Companion.padStr
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private var dateTextView: TextView? = null
    private var timeTextView: TextView? = null
    private var tickReceiver: BroadcastReceiver? = null
    private var firstNameEditText: EditText? = null
    private var lastNameEditText: EditText? = null
    private var nextBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateTextView = findViewById(R.id.dateTextView)
        timeTextView = findViewById(R.id.timeTextView)

        val currCal =  Calendar.getInstance();
        dateTextView?.text = "${padStr(currCal[Calendar.DAY_OF_MONTH])}/${padStr(currCal[Calendar.MONTH])}/${currCal[Calendar.YEAR]}"
        timeTextView?.text = "${padStr(currCal[Calendar.HOUR_OF_DAY])}:${padStr(currCal[Calendar.MINUTE])}"

        tickReceiver = TimeReceiver(dateTextView, timeTextView);
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))

        firstNameEditText = findViewById(R.id.firstNameEditText)
        lastNameEditText = findViewById(R.id.lastNameEditText)

        nextBtn = findViewById(R.id.nextBtn);
        nextBtn?.setOnClickListener{
            val name = "${firstNameEditText?.text} ${lastNameEditText?.text}"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent);
        }
    }

    public override fun onStop() {
        super.onStop()
        if (tickReceiver != null) unregisterReceiver(tickReceiver)
    }
}

