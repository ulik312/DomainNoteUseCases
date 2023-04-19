package com.sbor.domainnoteusecases.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sbor.domainnoteusecases.domain.utils.Resource
import com.sbor.domainnoteusecases.presentation.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> Flow<com.sbor.domainnoteusecases.domain.utils.Resource<T>>.collectData(_state: MutableStateFlow<UIState<T>>) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectData.collect { res ->
                when (res) {
                    is com.sbor.domainnoteusecases.domain.utils.Resource.Error -> {
                        if (res.message != null) {
                            _state.value = UIState.Error(res.message!!)
                        }
                    }
                    is com.sbor.domainnoteusecases.domain.utils.Resource.Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is com.sbor.domainnoteusecases.domain.utils.Resource.Success -> {
                        if (res.data != null) {
                            _state.value = UIState.Success(res.data!!)
                        }
                    }
                }
            }
        }
    }
}