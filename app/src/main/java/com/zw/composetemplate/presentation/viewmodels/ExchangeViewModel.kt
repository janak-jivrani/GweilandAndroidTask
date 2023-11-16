package com.zw.composetemplate.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.zw.zwbase.domain.CoinInfoResponse
import com.zw.zwbase.domain.LatestListingResponse
import com.zw.zwbase.usecase.GetCoinInfoTask
import com.zw.zwbase.usecase.GetLatestListingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
   private val coinInfoTask: GetCoinInfoTask,private val latestListingUseCase: GetLatestListingUseCase
) : ViewModel() {

    private val _coinTaskInfo = MutableLiveData<List<LatestListingResponse.DataItem>>()
    val coinTaskInfo: LiveData<List<LatestListingResponse.DataItem>> = _coinTaskInfo


    fun getLatestListingUseCase(start: Int, limit: Int, convert: String, sort: String) =
        viewModelScope.launch(Dispatchers.IO) {
            val result = latestListingUseCase.invoke(start, limit, convert, sort)

            result.onSuccess {
                val idList = data?.data?.map { it.id }
                idList?.let {
                    data?.data?.let { it1 -> getCoinTaskInfo(idList, it1) }
                }

            }.onError {

            }.onFailure {

            }.onException {

            }
        }

    private fun getCoinTaskInfo(ids: List<Int?>, dataItem: List<LatestListingResponse.DataItem>) =
        viewModelScope.launch(Dispatchers.IO) {

            val result = coinInfoTask.invoke(ids.joinToString(","))

            result.onSuccess {
                val moshi: Moshi = Moshi.Builder().build()
                val jsonAdapter: JsonAdapter<CoinInfoResponse.Data> =
                    moshi.adapter(CoinInfoResponse.Data::class.java)
                ids.forEachIndexed { index, id ->
                    val json = data?.data?.get("$id")?.asJsonObject
                    val blackjackHand = jsonAdapter.fromJson(json.toString())
                    dataItem.get(index).coinInfoData = blackjackHand
                }

                _coinTaskInfo.value = dataItem

            }.onError {

            }.onFailure {

            }.onException {

            }
        }

}