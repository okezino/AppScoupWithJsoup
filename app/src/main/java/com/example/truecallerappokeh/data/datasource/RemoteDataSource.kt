package com.example.truecallerappokeh.data.datasource


import com.example.truecallerappokeh.common.AppDispatcher
import com.example.truecallerappokeh.common.BASE_URL
import com.example.truecallerappokeh.data.model.WebData
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val appDispatcher: AppDispatcher) :
    RemoteService {
    override suspend fun getWebData(): WebData {
        return withContext(appDispatcher.io) {
            val url = BASE_URL
            val doc = Jsoup.connect(url).get()
            val response = WebData(doc, "Message is Successful")
            response
        }
    }
}