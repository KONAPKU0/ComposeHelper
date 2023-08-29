package com.youmu.helper.base

import androidx.annotation.Keep
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 *@Author weixuan
 *@Date 2023/8/14
 *@Description
 **/

@Keep
interface IUiState

@Keep
interface IUiEffect

abstract class BaseViewModel<S : IUiState,F : IUiEffect> : ViewModel() {

    private val initialState: S by lazy { initialState() }

    protected abstract fun initialState(): S

    private val _uiState: MutableStateFlow<S> by lazy { MutableStateFlow(initialState) }

    val uiState: StateFlow<S> by lazy { _uiState }
    val currentState: S get() = uiState.value

    private val _uiEffect: MutableSharedFlow<F> = MutableSharedFlow()

    val uiEffect: Flow<F> = _uiEffect


    protected fun setState(reduce: S.() -> S) {
        val newState = currentState.reduce()
        _uiState.value = newState
    }





    protected fun sendEffect(effect: F) {
        viewModelScope.launch { _uiEffect.emit(effect) }
    }


}
