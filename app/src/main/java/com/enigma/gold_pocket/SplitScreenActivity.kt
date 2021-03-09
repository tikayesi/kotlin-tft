package com.enigma.gold_pocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_split_screen.*

class SplitScreenActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_split_screen)
//        (fragment2 as TransactionFragment).transactionHandler = this
    }

//    override fun handleBuy(stock: Int) {
//        this.balance = balance + stock
//        (fragment as BalanceFragment).updateBalance(this.balance)
//    }
//
//    override fun handleSell(stock: Int) {
//        this.balance = balance - stock
//        (fragment as BalanceFragment).updateBalance(this.balance)
//    }
}