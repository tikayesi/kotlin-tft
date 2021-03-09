package com.enigma.gold_pocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.enigma.gold_pocket.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.fragment_transaction.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TransactionFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //memanggil view model dengan fragment
    //cara lama menggunakan ViewModelProviders
    //val pocketViewModel: PocketViewModel = ViewModelProviders.of(requireActivity()).get(PocketViewModel::class.java)
    lateinit var pocketViewModel: PocketViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sellButton.setOnClickListener(this)
        buyButton.setOnClickListener(this)
        pocketViewModel = ViewModelProviders.of(requireActivity()).get(PocketViewModel::class.java)
    }

    override fun onClick(v: View?) {
        when(v){
            sellButton ->{
                pocketViewModel.handleDecrement(stockInputText.text.toString().toInt())
               // transactionHandler?.handleSell(stockInputText.text.toString().toInt())
            }
            buyButton ->{
                pocketViewModel.handleIncrement(stockInputText.text.toString().toInt())
               // transactionHandler?.handleBuy(stockInputText.text.toString().toInt())
            }
        }
    }

}