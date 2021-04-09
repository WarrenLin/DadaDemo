package com.cmoney.activitydemo

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun start(context: Context, text: String) {
            val starter = Intent(context, SecondActivity::class.java)
                .putExtra("extra_name", text)
            context.startActivity(starter)
        }

        @JvmStatic
        fun startResult(activity: Activity, text: String) {
            val starter = Intent(activity, SecondActivity::class.java)
                .putExtra("extra_name", text)
            activity.startActivityForResult(starter, 99)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val text = intent.extras?.getString("extra_name", "default")
        val textView: TextView = findViewById(R.id.text)
        textView.text = text
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("extra_name", "CMoney")
        setResult(RESULT_OK, intent)
        super.onBackPressed()
    }
}