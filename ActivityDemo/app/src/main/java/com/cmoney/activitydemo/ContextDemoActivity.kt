package com.cmoney.activitydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class ContextDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_demo)

        val textView: TextView = findViewById(R.id.textView)
        textView.text = getString(R.string.text)
        textView.setTextColor(ContextCompat.getColor(this, R.color.red))

        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setImageResource(R.drawable.logo)
    }
}