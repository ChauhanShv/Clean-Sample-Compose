package com.plentina.app.domain.use_case.getcoins

import com.plentina.app.common.Constants
import com.plentina.app.common.NetworkResource
import com.plentina.app.data.remote.dto.toCoin
import com.plentina.app.domain.model.Coin
import com.plentina.app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<NetworkResource<List<Coin>>> = flow {
        try {
            emit(NetworkResource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(NetworkResource.Success<List<Coin>>(coins))
        }  catch(e: HttpException) {
            emit(NetworkResource.Error<List<Coin>>(e.localizedMessage ?: Constants.ERROR))
        } catch(e: IOException) {
            emit(NetworkResource.Error<List<Coin>>(Constants.NETWORK_ERROR))
        }
    }
}