package com.zw.zwbase.data.repositories

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.data.remote.coinmarket.CoinMarketApiInterface
import com.zw.zwbase.data.remote.coinmarket.CoinMarketDataSource
import com.zw.zwbase.domain.CoinInfoResponse
import com.zw.zwbase.domain.LatestListingResponse
import javax.inject.Inject

class CoinMarketRepository @Inject constructor(val coinMarketApiInterface: CoinMarketApiInterface) : CoinMarketDataSource {

    override suspend fun getLatestListing(start: Int, limit: Int, convert:String, sort: String): ApiResponse<LatestListingResponse> {
        return coinMarketApiInterface.getLatestListing(start, limit, convert, sort)
    }

    override suspend fun getCoinInfo(id: String): ApiResponse<CoinInfoResponse> {
        return coinMarketApiInterface.getCoinInfo(id)
    }

}