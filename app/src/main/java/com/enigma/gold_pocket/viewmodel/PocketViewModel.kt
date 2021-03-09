package com.enigma.gold_pocket.viewmodel

import androidx.lifecycle.ViewModel

class PocketViewModel: ViewModel() {
    var balance = 0

    fun handleIncrement(increment : Int){
        balance += increment
    }

    fun handleDecrement(decrement : Int){
        balance -= decrement
    }

}