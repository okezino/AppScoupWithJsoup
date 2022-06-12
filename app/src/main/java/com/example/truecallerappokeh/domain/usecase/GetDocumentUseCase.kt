package com.example.truecallerappokeh.domain.usecase

import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.domain.base.UseCase
import com.example.truecallerappokeh.domain.repository.MainRepositoryInterface
import javax.inject.Inject

class GetDocumentUseCase @Inject constructor(private val mainRepositoryInterface: MainRepositoryInterface) :
    UseCase<Unit, GetDocumentUseCase.Response>() {
    data class Response(
        val doc: Resource<DisplayData>
    )

    override suspend fun execute(params: Unit): Response {
        return Response(mainRepositoryInterface.getDocFromWeb())
    }
}