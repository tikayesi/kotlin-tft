package com.enigma.gold_pocket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, TransactionHandler {


    lateinit var balanceFragment: BalanceFragment
    lateinit var transactionFragment: TransactionFragment
    lateinit var historyFragment: HistoryFragment
    var balance : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        balanceButton.setOnClickListener(this)
        transactionButton.setOnClickListener(this)
        historyButton.setOnClickListener(this)
        balanceFragment = BalanceFragment()
        transactionFragment = TransactionFragment(this)
        historyFragment = HistoryFragment()
        //supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, balanceFragment).commit()
        //jika melakukan set view, dll sebelum melakukan set content view maka akan error
        //karena kita harus melakukan set layout sebelum  isi didalam layout
//        nameTextView.text = "Tika Yesi Kristiani"
    }

    override
    fun handleBuy(stock: Int){
        balance = balance + stock
        balanceFragment.updateBalance(balance)
    }

    override
    fun handleSell(stock: Int){
        balance = balance - stock
        balanceFragment.updateBalance(balance)
    }

    override fun onClick(v: View?) {
    when(v){
        balanceButton -> {
            switchFragment(balanceFragment)
        }
        transactionButton -> {
            switchFragment(transactionFragment)
        }
        historyButton -> {
            startActivity(Intent(this, SplitScreenActivity::class.java))
        }
    }
    }

    fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }


}