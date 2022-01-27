package com.plentina.app.domain.use_case.getcoin

import com.plentina.app.common.Constants
import com.plentina.app.common.NetworkResource
import com.plentina.app.data.remote.dto.toCoinDetail
import com.plentina.app.domain.model.CoinDetail
import com.plentina.app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<NetworkResource<CoinDetail>> = flow {
        try {
            emit(NetworkResource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(NetworkResource.Success<CoinDetail>(coin))
        } catch(e: HttpException) {
            emit(NetworkResource.Error<CoinDetail>(e.localizedMessage ?: Constants.ERROR))
        } catch(e: IOException) {
            emit(NetworkResource.Error<CoinDetail>(Constants.NETWORK_ERROR))
        }
    }
}