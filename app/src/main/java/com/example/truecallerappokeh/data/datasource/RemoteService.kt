package com.example.truecallerappokeh.data.datasource

import com.example.truecallerappokeh.data.model.WebData

interface RemoteService {
    suspend fun getWebData(): WebData
}