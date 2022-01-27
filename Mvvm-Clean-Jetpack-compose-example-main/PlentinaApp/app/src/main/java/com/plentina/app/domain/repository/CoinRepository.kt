package com.plentina.app.domain.repository

import com.plentina.app.data.remote.dto.CoinDetailDto
import com.plentina.app.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}