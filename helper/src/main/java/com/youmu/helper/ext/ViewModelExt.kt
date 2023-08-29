package com.youmu.helper.ext

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.youmu.helper.base.BaseViewModel
import com.youmu.helper.base.IUiEffect
import com.youmu.helper.base.IUiState

/**
 *@Author weixuan
 *@Date 2023/6/10
 *@Description
 **/

@Composable
fun <S : IUiState, F : IUiEffect> BaseViewModel<S, F>.CollectSideEffect(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    sideEffect: (suspend (sideEffect: F) -> Unit),
) {
    val sideEffectFlow = this.uiEffect
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(sideEffectFlow, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(lifecycleState) {
            sideEffectFlow.collect { sideEffect(it) }
        }
    }
}

