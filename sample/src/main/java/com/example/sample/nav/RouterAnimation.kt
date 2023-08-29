package com.example.sample.nav

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import com.example.sample.ui.main.MainScreen
import com.youmu.helper.components.nav.NavigationAnimatedEffect

/**
 *@Author weixuan
 *@Date 2023/8/17
 *@Description
 **/

@Composable
fun RouterAnimation(){
    NavigationAnimatedEffect(
        startDestination = MainScreenDes.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(350)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(350)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(350)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Companion.Right,
                animationSpec = tween(350)
            )
        },
    ){
        composable(MainScreenDes.route) {
            MainScreen()
        }

    }
}