package com.jhon.data.source.remote.base


import android.util.Log
import com.jhon.data.utils.ConnectionUtils
import com.jhon.domain.utils.Either
import com.jhon.domain.utils.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

abstract class CallServiceBase() {

    abstract fun getNetworkUtils(): ConnectionUtils

    /**
     * Use this for unit(void) responses returns.
     */
    protected suspend inline fun <T> callServiceWithOutBase(crossinline retrofitCall: suspend () -> Response<T>): com.jhon.domain.utils.Either<com.jhon.domain.utils.Failure, T> {
        return when (getNetworkUtils().isNetworkAvailable()) {
            true -> {
                try {
                    withContext(Dispatchers.IO) {
                        val response = retrofitCall.invoke()
                        if (response.isSuccessful && response.body() != null) {
                            Log.d("ResponsBody.Data2", response.body()!!.toString())
                            return@withContext com.jhon.domain.utils.Either.Success(response.body()!!)
                        } else {

                            return@withContext com.jhon.domain.utils.Either.Error(
                                getErrorMessageFromServer(
                                    response.code(), null
                                )
                            )
                        }
                    }
                } catch (e: Exception) {

                    return com.jhon.domain.utils.Either.Error(parseException(e))
                }
            }
            false -> {
                com.jhon.domain.utils.Either.Error(com.jhon.domain.utils.Failure.NoNetworkDetected)
            }
        }
    }

    /**
     * Parse Server Error to [Failure.ServerBodyError] if [errorBody].
     * @return [Failure] object.
     */
    suspend fun getErrorMessageFromServer(errorCode: Int?, errorBody: String?): com.jhon.domain.utils.Failure {
        return if (!errorBody.isNullOrBlank()) {
            return withContext(Dispatchers.IO) {
                return@withContext when (errorCode) {
                    400 -> {
                        com.jhon.domain.utils.Failure.ErrorRequestClient(errorBody)
                    }
                    401 -> {
                        com.jhon.domain.utils.Failure.UnauthorizedOrForbidden(errorBody)
                    }
                    403 -> {
                        com.jhon.domain.utils.Failure.PermissionsDenied()
                    }
                    404 -> {
                        com.jhon.domain.utils.Failure.ResourcesNotFound()
                    }
                    423 -> {
                        com.jhon.domain.utils.Failure.AppNotAvailable(errorBody)
                    }
                    505 -> {
                        com.jhon.domain.utils.Failure.Error505()
                    }
                    999 -> {
                        com.jhon.domain.utils.Failure.ReplaceSessionFinal()
                    }
                    else -> {
                        com.jhon.domain.utils.Failure.ServerBodyError(errorCode ?: 500, errorBody)
                    }
                }
            }
        } else {
            //No error body was found.
            com.jhon.domain.utils.Failure.None
        }
    }

    fun parseException(throwable: Throwable): com.jhon.domain.utils.Failure {
        return when (throwable) {
            is SocketTimeoutException -> com.jhon.domain.utils.Failure.TimeOut
            is SSLException -> com.jhon.domain.utils.Failure.NetworkConnectionLostSuddenly
            is SSLHandshakeException -> com.jhon.domain.utils.Failure.SSLError
            else -> com.jhon.domain.utils.Failure.ServiceUncaughtFailure(
                throwable.message ?: "Service response doesn't match with response object."
            )
        }
    }

}