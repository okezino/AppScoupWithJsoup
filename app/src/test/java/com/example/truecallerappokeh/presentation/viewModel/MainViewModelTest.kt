package com.example.truecallerappokeh.presentation.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.truecallerappokeh.common.ERROR_MESSAGE
import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.domain.usecase.GetDocumentUseCase
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.Executors


@Suppress("BlockingMethodInNonBlockingContext")
@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var getDocumentUseCase: GetDocumentUseCase
    private var firstData = "be"
    private var secData = arrayListOf("be", "over")
    private var thirdData = mapOf(Pair("an", 2), Pair("<p>", 1), Pair("Have", 1))
    private val result = Resource.Success(DisplayData(firstData, secData, thirdData))
    private val resultError =  Resource.Error<DisplayData>()

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    @Before
    fun setUp() {
       Dispatchers.setMain(mainThreadSurrogate)
        getDocumentUseCase = mock<GetDocumentUseCase>()
        mainViewModel = MainViewModel(getDocumentUseCase)
    }

    @Test
    fun `get data from the web when the repository returns Success`() = runBlockingTest {
        whenever(getDocumentUseCase.execute(Unit)).thenReturn(
            GetDocumentUseCase.Response(result)
        )

        mainViewModel.callTask()

        mainViewModel.viewListData.test().awaitValue()
            .assertValue { it is Resource.Loading }
            .awaitNextValue()
            .assertValue { it is Resource.Success<DisplayData> }

    }

    @Test
    fun `get data from the web when the repository returns Error`() = runBlockingTest {
        whenever(getDocumentUseCase.execute(Unit)).thenReturn(
            GetDocumentUseCase.Response(resultError)
        )

        mainViewModel.callTask()

        mainViewModel.viewListData.test().awaitValue()
            .assertValue { it is Resource.Loading }
            .awaitNextValue()
            .assertValue { it is Resource.Error<DisplayData> }

    }


}