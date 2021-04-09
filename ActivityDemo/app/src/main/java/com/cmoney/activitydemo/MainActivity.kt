package com.cmoney.activitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var button: Button
    private lateinit var changeColorButton: Button
    private lateinit var colorTextView: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            startSecondActivity()
        }
        colorTextView = findViewById(R.id.color_textView)
        changeColorButton = findViewById(R.id.change_color_button)
        imageView = findViewById(R.id.imageView)
        changeColorButton.setOnClickListener {
            colorTextView.apply {
                text = getString(R.string.text)
                setTextColor(ContextCompat.getColor(this@MainActivity, R.color.red))
            }

            imageView.apply {
                setImageDrawable(ContextCompat.getDrawable(this@MainActivity, R.drawable.logo))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 99) {
            if (resultCode == RESULT_OK) {
                val result = data?.getStringExtra("extra_name")
                Log.i(TAG, result.orEmpty())
            }
        }
    }

    private fun startSecondActivity() {
//        val intent = Intent(this, SecondActivity::class.java)
//        startActivity(intent)
//        SecondActivity.start(this, "Hello Second Activity!!")

        SecondActivity.startResult(this, "Hello Second Activity!!")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }
}