package com.cb.android.asynctasks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*;

class MainActivity : AppCompatActivity() {

//    internal var tvresult: TextView? = null
//    internal var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (findViewById(R.id.button) as Button).setOnClickListener {
            val task = NSecWaitTask(tvResult)
            task.execute(Integer.valueOf(etWaitTime.text.toString()))
        }
        (findViewById(R.id.button2) as Button).setOnClickListener {
            tvResult.text = "Other Stuff"
            var myStr: String = tvResult.text as String;

        }

    }

    companion object {

        val TAG = "Async"
    }

}
