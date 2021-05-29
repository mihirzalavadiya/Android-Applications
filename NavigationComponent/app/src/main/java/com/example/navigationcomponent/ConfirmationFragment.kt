package com.example.navigationcomponent

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

class ConfirmationFragment : Fragment() {

    lateinit var recipient: String
    lateinit var money: Money

//    @SuppressLint("UseRequireInsteadOfGet")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        recipient = arguments!!.getString("recipient").toString()
//        money = arguments!!.getParcelable("amount")!!
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val amount = money.amount
//        val confirmationMessage = "You have sent $amount to $recipient"
//        view.findViewById<TextView>(R.id.confirmation_message).text = confirmationMessage
//    }
}