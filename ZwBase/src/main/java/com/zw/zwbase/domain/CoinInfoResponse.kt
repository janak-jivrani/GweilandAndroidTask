package com.zw.zwbase.domain

import com.google.gson.JsonObject
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class CoinInfoResponse(
    @Json(name = "status") var status: Status? = null,
    @Json(name = "data") var data: JsonObject?
) : Serializable {
    @JsonClass(generateAdapter = true)
    data class Status(
        @Json(name = "timestamp") var timestamp: String,
        @Json(name = "error_code") var error_code: Int? = 0,
        @Json(name = "error_message") var error_message: String? = null,
        @Json(name = "elapsed") var elapsed: Int? = 0,
        @Json(name = "credit_count") var credit_count: Int? = 0,
        @Json(name = "notice") var notice: String? = null,
    )

    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "id") var id: Int? = 0,
        @Json(name = "name") var name: String,
        @Json(name = "symbol") var symbol: String,
        @Json(name = "slug") var slug: String,
        @Json(name = "category") var category: String?,
        @Json(name = "date_added") var date_added: String,
        @Json(name = "tags") var tags: List<String> = ArrayList(),
        @Json(name = "tag-names") var tag_names: List<String> = ArrayList(),
        @Json(name = "tag-groups") var tag_groups: List<String> = ArrayList(),
        @Json(name = "description") var description: String?,
        @Json(name = "logo") var logo: String?,
        @Json(name = "subreddit") var subreddit: String?,
        @Json(name = "notice") var notice: String?,
        @Json(name = "urls") var urls: Urls?,
        @Json(name = "twitter_username") var twitter_username: String?,
        @Json(name = "is_hidden") var is_hidden: Int? = 0,
        @Json(name = "date_launched") var date_launched: String? = null,
        @Json(name = "platform") var platform: Platform? = null,
        @Json(name = "contract_address") var contract_address: List<ContactAddress> = ArrayList(),
        @Json(name = "self_reported_circulating_supply") var self_reported_circulating_supply: Any? = null,
        @Json(name = "self_reported_tags") var self_reported_tags: Any? = null,
        @Json(name = "self_reported_market_cap") var self_reported_market_cap: Any? = null,
        @Json(name = "infinite_supply") var infinite_supply: Boolean? = false

    ) {
        @JsonClass(generateAdapter = true)
        data class Urls(
            @Json(name = "website") var website: List<String> = ArrayList(),
            @Json(name = "twitter") var twitter: List<String> = ArrayList(),
            @Json(name = "message_board") var message_board: List<Any> = ArrayList(),
            @Json(name = "chat") var chat: List<String> = ArrayList(),
            @Json(name = "facebook") var facebook: List<Any> = ArrayList(),
            @Json(name = "explorer") var explorer: List<String> = ArrayList(),
            @Json(name = "reddit") var reddit: List<Any> = ArrayList(),
            @Json(name = "technical_doc") var technical_doc: List<String> = ArrayList(),
            @Json(name = "source_code") var source_code: List<Any> = ArrayList(),
            @Json(name = "announcement") var announcement: List<String> = ArrayList()
        )

        @JsonClass(generateAdapter = true)
        data class Platform(
            @Json(name = "id") var id: String?,
            @Json(name = "name") var name: String?,
            @Json(name = "slug") var slug: String?,
            @Json(name = "symbol") var symbol: String?,
            @Json(name = "token_address") var token_address: String?
        )

        @JsonClass(generateAdapter = true)
        data class ContactAddress(
            @Json(name = "contract_address") var contract_address: String?,
            @Json(name = "platform") var platform: AddressPlatform
        ) {
            @JsonClass(generateAdapter = true)
            data class AddressPlatform(
                @Json(name = "name") var name: String?,
                @Json(name = "coin") var coin: Coin?
            ) {
                @JsonClass(generateAdapter = true)
                data class Coin(
                    @Json(name = "id") var id: String?,
                    @Json(name = "name") var name: String?,
                    @Json(name = "symbol") var symbol: String?,
                    @Json(name = "slug") var slug: String?
                )

            }
        }
    }
}




