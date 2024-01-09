package com.example.finalprojectpam.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.finalprojectpam.ui.halamanalatmusik.add.DestinasiAddAlatMusik
import com.example.finalprojectpam.ui.halamanalatmusik.home.DestinasiHomeAlatMusik
//import com.example.finalprojectpam.ui.halamanalatmusik.home.HomeScreenAlatMusik
import com.example.finalprojectpam.ui.halamanutama.CoverScreen
import com.example.finalprojectpam.ui.halamanutama.DestinasiHome
import com.example.finalprojectpam.ui.halamanutama.DestinasiMenu
import com.example.finalprojectpam.ui.halamanutama.HalamanUtama

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(DestinasiHome.route
        ) {
            CoverScreen(
                onNextButtonClicked = {
                    navController.navigate(DestinasiMenu.route)
                }
            )
        }

        composable(DestinasiMenu.route
        ) {
            HalamanUtama(
                onAlatMusikClick = {
                    navController.navigate(DestinasiHomeAlatMusik.route)
                }
            )

        }

       // composable(DestinasiHomeAlatMusik.route
    // ){
         //   HomeScreenAlatMusik(
           //     navigateToItemEntryAlatMusik = {navController.navigate(DestinasiAddAlatMusik.route)},
             //   onDetailClickAlatMusik = {}
            //)
        //}
    }
}