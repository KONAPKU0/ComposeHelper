package com.youmu.helper.ext

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import kotlinx.coroutines.delay

/**
 *@Author weixuan
 *@Date 2023/8/14
 *@Description
 **/

/**
 * 防抖动点击
 *
 * @param onClick
 * @return
 */
fun Modifier.clickableSingle(enabled:Boolean = true, showRipple:Boolean = true, onClick: () -> Unit): Modifier = composed(
    inspectorInfo = {
        name = "clickableOnce"
        value = onClick
    }
) {
    var enableAgain by remember { mutableStateOf(true) }
    LaunchedEffect(enableAgain, block = {
        if (enableAgain) return@LaunchedEffect
        delay(timeMillis = 500L)
        enableAgain = true
    })
    Modifier.clickable(enabled = enabled,indication = if (showRipple) LocalIndication.current else null,interactionSource = remember { MutableInteractionSource() }) {
        if (enableAgain) {
            enableAgain = false
            onClick()
        }
    }
}

inline fun Modifier.clickableNoRipple(enabled:Boolean = true,
                                      crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(
        enabled = enabled,
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}