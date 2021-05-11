package com.cmoney.fragmentdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Test", "onCreateView")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Test", "onViewCreated")

        view.findViewById<Button>(R.id.button).apply {
            setOnClickListener {
                val fragmentTransaction = requireFragmentManager().beginTransaction()
//                fragmentTransaction.replace(R.id.frameLayout, SecondFragment())
//                fragmentTransaction.add(R.id.frameLayout, SecondFragment()).hide(this@FirstFragment)
                fragmentTransaction.add(R.id.frameLayout, SecondFragment.newInstance("test1", "test2")).hide(this@FirstFragment)


                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
    }
}