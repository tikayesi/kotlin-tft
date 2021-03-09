package com.enigma.gold_pocket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.enigma.gold_pocket.viewmodel.PocketViewModel
import kotlinx.android.synthetic.main.fragment_balance.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BalanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BalanceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

//    val pocketViewModel: PocketViewModel = ViewModelProviders.of(requireActivity()).get(
//        PocketViewModel::class.java)
    lateinit var pocketViewModel: PocketViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        pocketViewModel = ViewModelProviders.of(requireActivity()).get(
        PocketViewModel::class.java)
        return inflater.inflate(R.layout.fragment_balance, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.i("Balance Fragment", activity.toString())
//        balanceTextView.text = pocketViewModel.balance.toString()
        val balanceObserver: Observer<Int> = Observer<Int>{
            it -> balanceTextView.text = it.toString()
        }

        pocketViewModel.balance.observe(viewLifecycleOwner, balanceObserver)
        //Jika menggunakan ini,
        //pocketViewModel.balance.observe(requireActivity(), balanceObserver)

    }

//    fun updateBalance(balance: Int){
//       this.pocketViewModel= balance
//        balanceTextView?.text = this.balance.toString()
//    }

}