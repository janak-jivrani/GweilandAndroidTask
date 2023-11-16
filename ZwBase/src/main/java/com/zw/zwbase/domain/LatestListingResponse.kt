package com.zw.zwbase.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class LatestListingResponse(
    @Json(name = "status") var status: Status? = null,
    @Json(name = "data") var data: List<DataItem> = ArrayList()
) :
    Serializable {
    @JsonClass(generateAdapter = true)
    data class Status(
        @Json(name = "timestamp") var timestamp: String,
        @Json(name = "error_code") var error_code: Int? = 0,
        @Json(name = "error_message") var error_message: String? = null,
        @Json(name = "elapsed") var elapsed: Int? = 0,
        @Json(name = "credit_count") var credit_count: Int? = 0,
        @Json(name = "notice") var notice: String? = null,
        @Json(name = "total_count") var total_count: Int? = 0
    )

    @JsonClass(generateAdapter = true)
    data class DataItem(
        @Json(name = "id") var id: Int? = 0,
        @Json(name = "name") var name: String,
        @Json(name = "symbol") var symbol: String,
        @Json(name = "slug") var slug: String,
        @Json(name = "num_market_pairs") var num_market_pairs: Int?,
        @Json(name = "date_added") var date_added: String,
        @Json(name = "tags") var tags: List<String> = ArrayList(),
        @Json(name = "max_supply") var max_supply: Long? = 0,
        @Json(name = "circulating_supply") var circulating_supply: Long? = 0,
        @Json(name = "total_supply") var total_supply: Long,
        @Json(name = "infinite_supply") var infinite_supply: Boolean? = false,
        @Json(name = "platform") var platform: Any? = null,
        @Json(name = "cmc_rank") var cmc_rank: Int? = 0,
        @Json(name = "self_reported_circulating_supply") var self_reported_circulating_supply: Any? = null,
        @Json(name = "self_reported_market_cap") var self_reported_market_cap: Any? = null,
        @Json(name = "tvl_ratio") var tvl_ratio: Any? = null,
        @Json(name = "last_updated") var last_updated: String?,
        @Json(name = "quote") var quote: Quote
    ) {

        var coinInfoData: CoinInfoResponse.Data?=null
        @JsonClass(generateAdapter = true)
        data class Quote(@Json(name = "USD") var usd: USD?) {
            @JsonClass(generateAdapter = true)
            data class USD(
                @Json(name = "price") var price: Double?,
                @Json(name = "volume_24h") var volume_24h: Double?,
                @Json(name = "volume_change_24h") var volume_change_24h: Double?,
                @Json(name = "percent_change_1h") var percent_change_1h: Double?,
                @Json(name = "percent_change_24h") var percent_change_24h: Double?,
                @Json(name = "percent_change_7d") var percent_change_7d: Double?,
                @Json(name = "percent_change_30d") var percent_change_30d: Double?,
                @Json(name = "percent_change_60d") var percent_change_60d: Double?,
                @Json(name = "percent_change_90d") var percent_change_90d: Double?,
                @Json(name = "market_cap") var market_cap: Double?,
                @Json(name = "market_cap_dominance") var market_cap_dominance: Double?,
                @Json(name = "fully_diluted_market_cap") var fully_diluted_market_cap: Double?,
                @Json(name = "tvl") var tvl: Any? = null,
                @Json(name = "last_updated") var last_updated: String?
            )
        }

    }
}




