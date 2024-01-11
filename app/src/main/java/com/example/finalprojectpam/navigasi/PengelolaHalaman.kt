package com.example.finalprojectpam.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalprojectpam.ui.halamanalatmusik.add.AddAlatMusikScreen
import com.example.finalprojectpam.ui.halamanalatmusik.add.DestinasiAddAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.detail.DestinasiDetailAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.detail.DetailScreenAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.edit.EditDestinationAlatmusik
import com.example.finalprojectpam.ui.halamanalatmusik.edit.EditScreenAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.home.DestinasiHomeAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.home.HomeScreenAlatMusik
import com.example.finalprojectpam.ui.halamanutama.CoverScreen
import com.example.finalprojectpam.ui.halamanutama.DestinasiHome
import com.example.finalprojectpam.ui.halamanutama.DestinasiMenu
import com.example.finalprojectpam.ui.halamanutama.HalamanUtamaScreen

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(DestinasiHome.route
        ) {
            CoverScreen(navController)
        }

        composable(DestinasiMenu.route
        ) {
            HalamanUtamaScreen(
                onAlatMusikClicked = {
                    navController.navigate(DestinasiHomeAlatMusik.route)
                }
            )
        }

        composable(DestinasiHomeAlatMusik.route
     ){
            HomeScreenAlatMusik(
                navigateToItemEntryAlatMusik = {
                    navController.navigate(DestinasiAddAlatMusik.route)
                },
                onDetailClickAlatMusik = {itemId ->
                    navController.navigate("${DestinasiDetailAlatMusik.route}/$itemId")
                    println("itemId: $itemId")
                },
                navigateBack = {navController.popBackStack()}
            )
        }
        composable(DestinasiAddAlatMusik.route){
            AddAlatMusikScreen(navigateBack ={
                navController.popBackStack()
            }
            )
        }

        composable(
            route = DestinasiDetailAlatMusik.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailAlatMusik.alatMusikId){
                type =NavType.StringType
            })
            ){ backStackEntry ->
            val alatMusikId =backStackEntry.arguments?.getString(DestinasiDetailAlatMusik.alatMusikId)
            alatMusikId?.let {
                DetailScreenAlatMusik(
                    navigateBack ={navController.popBackStack()},
                    navigateToEditItem = {
                        navController.navigate("${EditDestinationAlatmusik.route}/$alatMusikId")
                        println("alatMusikId: $alatMusikId")
                    }
                )
            }
        }
        composable(
            route = EditDestinationAlatmusik.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationAlatmusik.alatMusikId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val alatMusikId = backStackEntry.arguments?.getString(EditDestinationAlatmusik.alatMusikId)
            alatMusikId?.let {
                EditScreenAlatMusik(
                    navigateBack = { navController.popBackStack() },
                    onNavigateUp = { navController.navigateUp() })
            }
        }
    }
}