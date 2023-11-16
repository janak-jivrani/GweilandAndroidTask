package com.zw.zwbase.data.remote.coinmarket

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.domain.CoinInfoResponse
import com.zw.zwbase.domain.LatestListingResponse
import com.zw.zwbase.domain.OTPRequest
import com.zw.zwbase.domain.OTPResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CoinMarketApiInterface {

    @POST("complaint_otp")
    suspend fun validateOTPPost(@Body body: OTPRequest): ApiResponse<OTPResponse>

    @GET("listings/latest")
    suspend fun getLatestListing(@Query("start") start: Int,@Query("limit") limit: Int,@Query("convert") convert:String, @Query("sort") sort: String): ApiResponse<LatestListingResponse>

    @GET("info")
    suspend fun getCoinInfo(@Query("id") id: String): ApiResponse<CoinInfoResponse>

}//listings/latest