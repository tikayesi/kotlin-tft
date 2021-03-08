package com.enigma.gold_pocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var counter = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        incrementButton.setOnClickListener(this)
        decrementButton.setOnClickListener(this)
        resetButton.setOnClickListener(this)
        //jika melakukan set view, dll sebelum melakukan set content view maka akan error
        //karena kita harus melakukan set layout sebelum  isi didalam layout
//        nameTextView.text = "Tika Yesi Kristiani"
    }

    override fun onClick(v: View?) {
        when(v){
            incrementButton -> {
                counter++
            }
            decrementButton -> {
                counter--
            }
            resetButton ->{
                counter=0
            }
        }
        resultText.text = counter.toString()
    }


}