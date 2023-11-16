package com.zw.composetemplate.presentation.ui.exchange.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zw.composetemplate.databinding.CryptoCurrenciesItemBinding
import com.zw.zwbase.domain.LatestListingResponse

class CryptoCurrenciesAdapter(private val cryptoCurrenciesList: List<LatestListingResponse.DataItem>) :
    RecyclerView.Adapter<CryptoCurrenciesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CryptoCurrenciesItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = cryptoCurrenciesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cryptoCurrenciesList[position])
    }

    inner class ViewHolder(itemView: CryptoCurrenciesItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        fun bind(data: LatestListingResponse.DataItem) {
            itemView
        }
    }
}