package com.zw.composetemplate.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skydoves.sandwich.ApiResponse
import com.zw.zwbase.domain.OTPResponse
import com.zw.zwbase.usecase.OtpTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val _initialSataLoad = MutableLiveData<Boolean>()
    val initialSataLoad : LiveData<Boolean> = _initialSataLoad

    fun setLoaded(isLoaded: Boolean) {
        _initialSataLoad.postValue(isLoaded)
    }

}