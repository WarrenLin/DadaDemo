package com.cmoney.mvvmdemo.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.cmoney.mvvmdemo.R
import com.cmoney.mvvmdemo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel = MainViewModel()
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            viewModel.onButtonClick()
        }

        initObserver()
    }

    private fun initObserver() {
        viewModel.serverResponse.observe(this, Observer { serverResponse ->
            textView.text = serverResponse
        })
    }
}
