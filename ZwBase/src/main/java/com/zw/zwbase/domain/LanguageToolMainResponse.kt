package com.zw.zwbase.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class LanguageToolMainResponse(@Json(name="software") var software: Software? = null,
                                    @Json(name="warnings") var warnings: Warnings? = null,
                                    @Json(name="language") var language: Warnings? = null,
                                    @Json(name="matches") var matches: List<Match> = ArrayList(),
                                    @Json(name="sentenceRanges") var sentenceRanges: List<List<Int>> = ArrayList()) : Serializable {

    @JsonClass(generateAdapter = true)
    data class Software(@Json(name="name") var name: String? = null,
                        @Json(name="version") var version: String? = null,
                        @Json(name="buildDate") var buildDate: String? = null,
                        @Json(name="apiVersion") var apiVersion: Int? = 0,
                        @Json(name="premium") var isPremium: Boolean? = false,
                        @Json(name="premiumHint") var premiumHint: String? = null,
                        @Json(name="status") var status: String? = null): Serializable

    @JsonClass(generateAdapter = true)
    data class Warnings(@Json(name="incompleteResults") var incompleteResults: Boolean? = false) : Serializable
    @JsonClass(generateAdapter = true)
    data class Language(@Json(name="name") var name: String? = null,
                        @Json(name="code") var code: String? = null,
                        @Json(name="detectedLanguage") var detectedLanguage: DetectedLanguage? = null) : Serializable
    @JsonClass(generateAdapter = true)
    data class DetectedLanguage(@Json(name="name") var name: String? = null,
                                @Json(name="code") var code: String? = null,
                                @Json(name="confidence") var confidence:Double? = 0.0,
                                @Json(name="source") var source: String? = null) : Serializable
    @JsonClass(generateAdapter = true)
    data class Match(@Json(name="message") var message: String? = null,
                     @Json(name="shortMessage") var shortMessage: String? = null,
                     @Json(name="replacements") var replacements: List<Replacement> = ArrayList(),
                     @Json(name="offset") var offset : Int? = 0,
                     @Json(name="length") var length : Int? = 0,
                     @Json(name="context") var context: Context? = null,
                     @Json(name="sentence") var sentence: String? = null,
                     @Json(name="type") var type: Type? = null,
                     @Json(name="rule") var rule: Rule? = null,
                     @Json(name="ignoreForIncompleteSentence") var isIgnoreForIncompleteSentence : Boolean? = false,
                     @Json(name="ignoreForIncompleteSentence") var contextForSureMatch : Int? = 0) : Serializable
    @JsonClass(generateAdapter = true)
    data class Context(@Json(name="text") var text: String? = null,
                       @Json(name="offset") var offset: Int? = 0,
                       @Json(name="length") var length: Int? = 0) : Serializable

    @JsonClass(generateAdapter = true)
    data class Replacement(@Json(name="value") var value: String? = null) : Serializable

    @JsonClass(generateAdapter = true)
    data class Rule(@Json(name="id") var id: String? = null,
                     @Json(name="description") var description: String? = null,
                     @Json(name="issueType") var issueType: String?,
                     @Json(name="urls") var urls: List<Url> = ArrayList(),
                     @Json(name="category") var category: Category? = null,
                     @Json(name="isPremium") var isPremium: Boolean? = false) : Serializable

    @JsonClass(generateAdapter = true)
    data class Type(@Json(name="typeName") var typeName: String? = null) : Serializable
    @JsonClass(generateAdapter = true)
    data class Url(@Json(name="value") var value: String? = null) : Serializable
    @JsonClass(generateAdapter = true)
    data class Category(@Json(name="id") var id: String? = null,@Json(name="name") var name: String? = null) : Serializable
}