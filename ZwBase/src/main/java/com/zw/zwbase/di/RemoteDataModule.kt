package com.zw.zwbase.di

import com.zw.zwbase.data.OTPDataSource
import com.zw.zwbase.data.remote.coinmarket.CoinMarketApiInterface
import com.zw.zwbase.data.remote.OTPApiInterface
import com.zw.zwbase.data.remote.coinmarket.CoinMarketDataSource
import com.zw.zwbase.data.remote.languagetool.LanguageToolApiInterface
import com.zw.zwbase.data.remote.languagetool.LanguageToolDataSource
import com.zw.zwbase.data.repositories.CoinMarketRepository
import com.zw.zwbase.data.repositories.LanguageToolRepository
import com.zw.zwbase.data.repositories.OTPDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideOTPDataSource(otpApiInterface: OTPApiInterface) : OTPDataSource {
        return OTPDataSourceImpl(otpApiInterface)
    }

    @Provides
    fun provideLanguageToolDataSource(languageToolApiInterface: LanguageToolApiInterface) : LanguageToolDataSource {
        return LanguageToolRepository(languageToolApiInterface)
    }

}