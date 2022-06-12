package com.example.truecallerappokeh.di


import com.example.truecallerappokeh.common.AppDispatcher
import com.example.truecallerappokeh.common.AppDispatcherHandler
import com.example.truecallerappokeh.data.datasource.RemoteDataSource
import com.example.truecallerappokeh.data.datasource.RemoteService
import com.example.truecallerappokeh.data.repository.MainRepository
import com.example.truecallerappokeh.domain.repository.MainRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(appDispatcher: AppDispatcher): RemoteService {
        return RemoteDataSource(appDispatcher)
    }

    @Provides
    @Singleton
    fun provideMainRepository(dataSource: RemoteService): MainRepositoryInterface {
        return MainRepository(dataSource)
    }

    @Provides
    fun provideAppDispatcher(): AppDispatcher {
        return AppDispatcherHandler()
    }
}