package com.zw.zwbase.usecase

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.data.remote.coinmarket.CoinMarketDataSource
import com.zw.zwbase.domain.LatestListingResponse
import javax.inject.Inject

class GetLatestListingUseCase @Inject constructor(private val coinMarketDataSource: CoinMarketDataSource) {
    suspend fun invoke(start: Int, limit: Int, convert:String, sort: String): ApiResponse<LatestListingResponse> = coinMarketDataSource.getLatestListing(start, limit, convert, sort)
}
