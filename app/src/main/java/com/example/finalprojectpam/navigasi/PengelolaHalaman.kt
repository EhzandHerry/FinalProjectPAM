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
import com.example.finalprojectpam.ui.halamanpelanggan.add.AddPelangganScreen
import com.example.finalprojectpam.ui.halamanpelanggan.add.DestinasiAddPelanggan
import com.example.finalprojectpam.ui.halamanpelanggan.detail.DestinasiDetailPelanggan
import com.example.finalprojectpam.ui.halamanpelanggan.detail.DetailScreenPelanggan
import com.example.finalprojectpam.ui.halamanpelanggan.edit.EditDestinationPelanggan
import com.example.finalprojectpam.ui.halamanpelanggan.edit.EditScreenPelanggan
import com.example.finalprojectpam.ui.halamanpelanggan.home.DestinasiHomePelanggan
import com.example.finalprojectpam.ui.halamanpelanggan.home.HomeScreenPelanggan
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
                },
                onPelangganClicked = {
                    navController.navigate((DestinasiHomePelanggan.route))
                }
            )
        }

        composable(DestinasiHomeAlatMusik.route
     ){
            HomeScreenAlatMusik(
                navigateToItemEntryAlatMusik = {
                    navController.navigate(DestinasiAddAlatMusik.route)
                },
                onDetailClickAlatMusik = {itemIdAlatMusik ->
                    navController.navigate("${DestinasiDetailAlatMusik.route}/$itemIdAlatMusik")
                    println("itemIdAlatMusik: $itemIdAlatMusik")
                },
                navigateBack = {navController.popBackStack()}
            )
        }

        composable(DestinasiHomePelanggan.route
        ){
            HomeScreenPelanggan(
                navigateToItemEntryPelanggan = {
                    navController.navigate(DestinasiAddPelanggan.route)
                },
                onDetailClickPelanggan = {itemIdPelanggan ->
                    navController.navigate("${DestinasiDetailPelanggan.route}/$itemIdPelanggan")
                    println("itemIdPelanggan: $itemIdPelanggan")
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

        composable(DestinasiAddPelanggan.route){
            AddPelangganScreen(navigateBack ={
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
            route = DestinasiDetailPelanggan.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailPelanggan.pelangganId){
                type =NavType.StringType
            })
        ){ backStackEntry ->
            val pelangganId =backStackEntry.arguments?.getString(DestinasiDetailPelanggan.pelangganId)
            pelangganId?.let {
                DetailScreenPelanggan(
                    navigateBack ={navController.popBackStack()},
                    navigateToEditItem = {
                        navController.navigate("${EditDestinationPelanggan.route}/$pelangganId")
                        println("PelangganId: $pelangganId")
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
        composable(
            route = EditDestinationPelanggan.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationPelanggan.pelangganId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val pelangganId = backStackEntry.arguments?.getString(EditDestinationPelanggan.pelangganId)
            pelangganId?.let {
                EditScreenPelanggan(
                    navigateBack = { navController.popBackStack() },
                    onNavigateUp = { navController.navigateUp() })
            }
        }
    }
}