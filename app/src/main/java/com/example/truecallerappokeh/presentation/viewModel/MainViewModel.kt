package com.example.truecallerappokeh.presentation.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truecallerappokeh.data.model.DisplayData
import com.example.truecallerappokeh.data.model.Resource
import com.example.truecallerappokeh.domain.usecase.GetDocumentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDocumentUseCase: GetDocumentUseCase
) : ViewModel() {

    private var _viewListData = MutableLiveData<Resource<DisplayData>>()
    val viewListData: LiveData<Resource<DisplayData>> get() = _viewListData


    fun callTask() {
        _viewListData.value = Resource.Loading()
        viewModelScope.launch {
            when (val response = getDocumentUseCase.execute(Unit).doc) {

                is Resource.Success -> {
                    _viewListData.value = response
                }

                is Resource.Error -> {
                    _viewListData.value = response
                }

                else -> {
                    _viewListData.value = Resource.Loading()
                }
            }


        }

    }
}







