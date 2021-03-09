package com.enigma.gold_pocket

interface TransactionHandler {
    fun handleBuy(stock: Int)
    fun handleSell(stock: Int)
}