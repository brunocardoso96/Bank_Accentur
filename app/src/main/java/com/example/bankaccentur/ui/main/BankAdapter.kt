package com.example.bankaccentur.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bankaccentur.R
import com.example.bankaccentur.data.model.StatementResponse
import com.example.bankaccentur.databinding.ActivityPaymentBinding
import kotlinx.android.synthetic.main.activity_payment.view.*

class BankAdapter(private val lista: List<StatementResponse>): RecyclerView.Adapter<BankAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.activity_payment,
                parent, false
            )
        )



    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val statement = lista[position]
        holder.binding.date = statement
    }

    inner class MyViewHolder constructor(val binding: ActivityPaymentBinding) : RecyclerView.ViewHolder(binding.root)
}
