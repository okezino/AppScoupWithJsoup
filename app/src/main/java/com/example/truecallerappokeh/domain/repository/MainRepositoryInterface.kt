package com.example.truecallerappokeh.domain.repository

import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource

interface MainRepositoryInterface {
    suspend fun getDocFromWeb(): Resource<DisplayData>
}