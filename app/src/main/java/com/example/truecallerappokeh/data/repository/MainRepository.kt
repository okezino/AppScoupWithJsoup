package com.example.truecallerappokeh.data.repository

import com.example.truecallerappokeh.common.ERROR_MESSAGE
import com.example.truecallerappokeh.data.mapper.toDisplayData
import com.example.truecallerappokeh.data.datasource.RemoteService
import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.domain.base.BaseRepositoryService
import com.example.truecallerappokeh.domain.repository.MainRepositoryInterface
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(private val remoteDataSource: RemoteService) :
    MainRepositoryInterface, BaseRepositoryService() {

    override suspend fun getDocFromWeb(): Resource<DisplayData> = executeRequest {
        try {
            val response = remoteDataSource.getWebData()
            Resource.Success(response.toDisplayData())
        } catch (e: Exception) {
            Resource.Error(Throwable((ERROR_MESSAGE)))
        }
    }
}