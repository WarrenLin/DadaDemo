package com.cmoney.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = FirstFragment()
        fragmentTransaction.replace(R.id.frameLayout, fragment, FirstFragment::class.java.simpleName)
        fragmentTransaction.commit()
    }
}