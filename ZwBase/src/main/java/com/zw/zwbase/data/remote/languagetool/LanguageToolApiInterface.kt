package com.zw.zwbase.data.remote.languagetool

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.domain.LanguageToolMainResponse
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LanguageToolApiInterface {

    @FormUrlEncoded
    @POST("check")
    suspend fun validateText(@FieldMap hashMap: HashMap<String,Any>): ApiResponse<LanguageToolMainResponse>
}