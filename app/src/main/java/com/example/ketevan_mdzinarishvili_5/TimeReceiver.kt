package com.example.ketevan_mdzinarishvili_5

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import java.util.Calendar

class TimeReceiver (val dateTextView: TextView?, val timeTextView: TextView?) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action!!.compareTo(Intent.ACTION_TIME_TICK) == 0) {
            val currCal = Calendar.getInstance();
            dateTextView?.text =
                "${padStr(currCal[Calendar.DAY_OF_MONTH])}/${padStr(currCal[Calendar.MONTH])}/${currCal[Calendar.YEAR]}"
            timeTextView?.text =
                "${padStr(currCal[Calendar.HOUR_OF_DAY])}:${padStr(currCal[Calendar.MINUTE])}"
        }
    }

    companion object {
        fun padStr(number: Number): String {
            return number.toString().padStart(2, '0');
        }
    }
}