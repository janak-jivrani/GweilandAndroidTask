package com.zw.zwbase.data.remote.languagetool

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.domain.LanguageToolMainResponse
import com.zw.zwbase.domain.OTPResponse

interface LanguageToolDataSource {
    suspend fun validateText(textToValidate:String): ApiResponse<LanguageToolMainResponse>
}