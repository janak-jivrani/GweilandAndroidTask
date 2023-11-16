package com.zw.composetemplate.presentation.ui.exchange.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zw.composetemplate.R
import com.zw.composetemplate.databinding.CryptoCurrenciesItemBinding
import com.zw.zwbase.domain.LatestListingResponse

class CryptoCurrenciesAdapter(private val cryptoCurrenciesList: List<LatestListingResponse.DataItem>) :
    RecyclerView.Adapter<CryptoCurrenciesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(R.layout.crypto_currencies_item,parent,false))!!)
    }

    override fun getItemCount(): Int = cryptoCurrenciesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cryptoCurrenciesList[position])
    }

    inner class ViewHolder(val cryptoCurrenciesItemBinding: CryptoCurrenciesItemBinding) :
        RecyclerView.ViewHolder(cryptoCurrenciesItemBinding.root) {
        fun bind(data: LatestListingResponse.DataItem) {
            cryptoCurrenciesItemBinding.dataItem = data
            cryptoCurrenciesItemBinding.executePendingBindings()
            cryptoCurrenciesItemBinding.shapeableImageView.load(data.coinInfoData?.logo){
                placeholder(R.drawable.currency_icon)
            }
        }
    }
}