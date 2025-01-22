package com.vlamik.spacex.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vlamik.spacex.features.details.RocketDetailScreen
import com.vlamik.spacex.features.list.RocketsListScreen

@Composable
fun SpaceXNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = NavRoutes.RocketsList.path) {
        composable(NavRoutes.RocketsList.path) {
            RocketsListScreen(
                hiltViewModel(),
                openDetailsClicked = { articleId ->
                    navController.navigate(NavRoutes.RocketDetails.build(articleId))
                })

        }
        composable(NavRoutes.RocketDetails.path) { backStackEntry ->
            backStackEntry.arguments?.getString(NavRoutes.DETAILS_ID_KEY)?.let {
                RocketDetailScreen(rocketDetailViewModel(rocketId = it), {
                    navController.popBackStack()
                }) {}
            }
        }
    }
}
