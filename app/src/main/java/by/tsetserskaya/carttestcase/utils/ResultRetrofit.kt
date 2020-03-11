package by.tsetserskaya.carttestcase.utils

sealed class ResultRetrofit<T> {
    data class Success<T>(val response: T) : ResultRetrofit<T>()
    data class Failure<T>(val code: Int, val error: String) : ResultRetrofit<T>()
}