package com.enigma.gold_pocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var buyFragment: BuyFragment
    lateinit var sellFragment: SellFragment
    lateinit var historyFragment: HistoryFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buyProduct.setOnClickListener(this)
        sellProduct.setOnClickListener(this)
        historyProduct.setOnClickListener(this)
        buyFragment = BuyFragment()
        sellFragment = SellFragment()
        historyFragment = HistoryFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, buyFragment).commit()
        //jika melakukan set view, dll sebelum melakukan set content view maka akan error
        //karena kita harus melakukan set layout sebelum  isi didalam layout
//        nameTextView.text = "Tika Yesi Kristiani"
    }

    override fun onClick(v: View?) {
    when(v){
        buyProduct -> {
            switchFragment(buyFragment)
        }
        sellProduct -> {
            switchFragment(sellFragment)
        }
        historyProduct -> {
            switchFragment(historyFragment)
        }
    }
    }

    fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }


}