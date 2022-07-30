package com.eugene_dolgushev.dates

sealed class Result {

    object Success : Result()
    data class Error(val error: String) : Result()
}