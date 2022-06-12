package com.example.truecallerappokeh.domain.usecase

import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.data.repository.FakeMainRepository
import com.example.truecallerappokeh.data.repository.MainRepository
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetDocumentUseCaseTest {

    private lateinit var getDocumentUseCase: GetDocumentUseCase
    private lateinit var fakeMainRepository: FakeMainRepository
    private lateinit var getDocumentUseCaseForMockedRep: GetDocumentUseCase
    private lateinit var mockMainRepository: FakeMainRepository
    private var firstData = "be"
    var secData = arrayListOf("be", "over")
    private var thirdData = mapOf(Pair("an", 2), Pair("<p>", 1), Pair("Have", 1))


    @Before
    fun setUp() {
        mockMainRepository = mock()
        fakeMainRepository = FakeMainRepository()
        getDocumentUseCase = GetDocumentUseCase(fakeMainRepository)
        getDocumentUseCaseForMockedRep = GetDocumentUseCase(mockMainRepository)

    }

    /**
     * This is a test of the use case using Fake Repository, this is done when you don't want to mock object
     */
    @Test
    fun `Get display data from fake repository`() = runBlocking {
      val result = Resource.Success(DisplayData(firstData, secData, thirdData))

        assertEquals(getDocumentUseCase.execute(Unit).doc, result)
    }

    /**
     * This is a test of the use case using Mock Repository, This is a cleaner and less file creation way of testing
     */

    @Test
    fun `Get display data from mock repository`() = runBlocking {
        val mockDisplayData: DisplayData = mock()
        whenever(mockMainRepository.getDocFromWeb()).thenReturn(
            Resource.Success(mockDisplayData)
        )
        val response = getDocumentUseCaseForMockedRep.execute(Unit)

        assertEquals(response.doc, Resource.Success(mockDisplayData))

    }
}