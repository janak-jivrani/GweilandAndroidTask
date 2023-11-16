package com.zw.zwbase.usecase

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.data.remote.languagetool.LanguageToolDataSource
import com.zw.zwbase.domain.LanguageToolMainResponse
import javax.inject.Inject

class ValidateTextTask @Inject constructor(private val languageToolDataSource: LanguageToolDataSource) {
    suspend fun invoke(text:String): ApiResponse<LanguageToolMainResponse> = languageToolDataSource.validateText(text)
}
