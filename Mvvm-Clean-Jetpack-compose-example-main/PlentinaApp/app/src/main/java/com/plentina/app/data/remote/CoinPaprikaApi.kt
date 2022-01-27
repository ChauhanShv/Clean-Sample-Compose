package com.plentina.app.data.remote

import com.plentina.app.common.Constants
import com.plentina.app.common.Endpoints
import com.plentina.app.data.remote.dto.CoinDetailDto
import com.plentina.app.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET(Endpoints.COINS_LIST)
    suspend fun getCoins(): List<CoinDto>

    @GET(Endpoints.COIN_DETAILS)
    suspend fun getCoinById(@Path(Constants.PARAM_COIN_ID) coinId: String): CoinDetailDto
}