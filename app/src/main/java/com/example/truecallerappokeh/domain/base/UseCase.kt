package com.example.truecallerappokeh.domain.base

abstract class UseCase<in Params, out Response> {
    abstract suspend fun execute(params: Params): Response
}