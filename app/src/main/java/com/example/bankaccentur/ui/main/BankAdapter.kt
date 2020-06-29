package com.example.bankaccentur.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankaccentur.R
import com.example.bankaccentur.data.model.StatementResponse
import kotlinx.android.synthetic.main.activity_payment.view.*

class BankAdapter(private val lista: List<StatementResponse>): RecyclerView.Adapter<BankAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_payment, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(lista[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.textViewTitle
        private val desc = itemView.textViewDesc
        private val date = itemView.textViewDate
        private val value = itemView.textViewValue

        fun bindView(pagamento: StatementResponse) {
            title.text = pagamento.title
            desc.text = pagamento.desc
            date.text = pagamento.date
            value.text = pagamento.value.toString()
        }
    }
}
