package com.zw.zwbase.data.remote.coinmarket

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.domain.CoinInfoResponse
import com.zw.zwbase.domain.LanguageToolMainResponse
import com.zw.zwbase.domain.LatestListingResponse
import com.zw.zwbase.domain.OTPResponse

interface CoinMarketDataSource {
    suspend fun getLatestListing(start: Int, limit: Int, convert:String, sort: String): ApiResponse<LatestListingResponse>

    suspend fun getCoinInfo(id: Int) : ApiResponse<CoinInfoResponse>
}