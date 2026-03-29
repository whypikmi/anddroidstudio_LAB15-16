package com.telyatnikova.studentplanner.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.telyatnikova.studentplanner.ui_model.*

@Composable
fun StudentPlannerNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onSubjectClick = { subjectId ->
                    navController.navigate(Screen.Details.createRoute(subjectId))
                },
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                },
                onSettingsClick = {

                    navController.navigate(Screen.Settings.route)
                },
                onTimingClick = { navController.navigate(Screen.Timing.route) }
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("subjectId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: ""
            DetailsScreen(
                subjectId = subjectId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = {
                    navController.popBackStack()
                })
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.Timing.route) {
            TimingScreen(
                onNavigateBack = { navController.popBackStack() },
                onTimingItemClick = { timingId ->
                    navController.navigate(Screen.TimingDetails.createRoute(timingId))
                }
            )
        }
        composable(
            route = Screen.TimingDetails.route,
            arguments = listOf(
                navArgument("timingId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val timingId = backStackEntry.arguments?.getString("timingId") ?: ""
            TimingDetailScreen(
                timingId = timingId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}