package com.example.truecallerappokeh.data.repository

import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.domain.repository.MainRepositoryInterface

class FakeMainRepository : MainRepositoryInterface {

    var firstresult = "be"
    var secResult = arrayListOf("be", "over")
    var thirdResult = mapOf(Pair("an", 2), Pair("<p>", 1), Pair("Have", 1))

    private val fakeResponse = Resource.Success(DisplayData(firstresult, secResult, thirdResult))
    override suspend fun getDocFromWeb(): Resource<DisplayData> {
        return fakeResponse
    }
}