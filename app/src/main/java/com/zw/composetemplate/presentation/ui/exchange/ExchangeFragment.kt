package com.zw.composetemplate.presentation.ui.exchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zw.composetemplate.databinding.FragmentExchangeBinding
import com.zw.composetemplate.presentation.ui.exchange.adapters.CryptoCurrenciesAdapter
import com.zw.composetemplate.presentation.viewmodels.ExchangeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExchangeFragment : Fragment(), View.OnClickListener {
    private lateinit var mBinding: FragmentExchangeBinding
    private val exchangeViewModel: ExchangeViewModel by viewModels()

    private lateinit var currenciesAdapter: CryptoCurrenciesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentExchangeBinding.inflate(inflater, container, false)
        currenciesAdapter = CryptoCurrenciesAdapter(arrayListOf())
        mBinding.rvCurrencies.adapter = currenciesAdapter
        mBinding.btnFilter.setOnClickListener(this)

        exchangeViewModel.getLatestListingUseCase(1,20,"USD","market_cap")
        observeData()
        return mBinding.root
    }

    private fun observeData(){
        exchangeViewModel.coinTaskInfo.observe(viewLifecycleOwner){
            it?.let {
               if (it.isNotEmpty()) {

               }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            mBinding.btnFilter -> {
                val dialog = FilterBottomSheetFragment()
                dialog.show(parentFragmentManager,"FilterBottomSheet")
            }
        }
    }
}