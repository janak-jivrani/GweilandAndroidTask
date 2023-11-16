package com.zw.zwbase.data.repositories

import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.data.remote.languagetool.LanguageToolApiInterface
import com.zw.zwbase.data.remote.languagetool.LanguageToolDataSource
import com.zw.zwbase.domain.LanguageToolMainResponse
import com.zw.zwbase.domain.OTPResponse
import okhttp3.MediaType
import okhttp3.RequestBody
import javax.inject.Inject

class LanguageToolRepository @Inject constructor(val otpApiInterface: LanguageToolApiInterface) :
    LanguageToolDataSource {

    override suspend fun validateText(textToValiodate: String): ApiResponse<LanguageToolMainResponse> {
        //@Query("complaint_id") complaint_id : String,@Query("otp") otp: String
        val hashMap = HashMap<String,Any>()
        hashMap["text"] = textToValiodate
        hashMap["language"] = "en-US"
        hashMap["enabledOnly"] = false
        return otpApiInterface.validateText(hashMap)
    }

}