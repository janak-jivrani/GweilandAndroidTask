package com.zw.zwbase.usecase

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.data.remote.coinmarket.CoinMarketDataSource
import com.zw.zwbase.domain.CoinInfoResponse
import com.zw.zwbase.domain.LatestListingResponse
import javax.inject.Inject

class GetCoinInfoTask @Inject constructor(private val coinMarketDataSource: CoinMarketDataSource) {
    suspend fun invoke(id: String): ApiResponse<CoinInfoResponse> = coinMarketDataSource.getCoinInfo(id)
}
