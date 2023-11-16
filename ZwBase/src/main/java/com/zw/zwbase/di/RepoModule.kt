package com.zw.zwbase.di

import com.zw.zwbase.data.remote.coinmarket.CoinMarketDataSource
import com.zw.zwbase.data.repositories.CoinMarketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindCoinMarketDataSource(coinMarketRepository: CoinMarketRepository) : CoinMarketDataSource
}