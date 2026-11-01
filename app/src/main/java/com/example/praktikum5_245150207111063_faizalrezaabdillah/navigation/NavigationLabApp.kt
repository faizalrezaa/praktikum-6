
package com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.praktikum5_245150207111063_faizalrezaabdillah.navigation.Routes


import com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.screen.AboutScreen
import com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.screen.DetailScreen
import com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.screen.HomeScreen
import com.example.praktikum5_245150207111063_faizalrezaabdillah.ui.screen.ProfileScreen
import com.example.praktikum6_245150207111063_faizalrezaabdillah.data.repository.DefaultStudentRepository
import com.example.praktikum6_245150207111063_faizalrezaabdillah.data.source.StudentLocalDataSource
import com.example.praktikum6_245150207111063_faizalrezaabdillah.ui.detail.DetailViewModel

@Composable
fun NavigationLabApp() {

    // Dependency manual
    val dataSource = remember { StudentLocalDataSource() }
    val repository = remember { DefaultStudentRepository(dataSource) }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDetail = { id ->
                    navController.navigate(Routes.detail(id))
                },
                onOpenProfile = {
                    navController.navigate(Routes.PROFILE)
                },
                onOpenAbout = {
                    navController.navigate(Routes.ABOUT)
                }
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val studentId =
                backStackEntry.arguments?.getInt("studentId") ?: -1

            val detailViewModel: DetailViewModel = viewModel(
                factory = DetailViewModel.factory(repository)
            )

            LaunchedEffect(studentId) {
                detailViewModel.loadStudent(studentId)
            }

            DetailScreen(
                uiState = detailViewModel.uiState,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        composable(Routes.ABOUT) {
            AboutScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}
