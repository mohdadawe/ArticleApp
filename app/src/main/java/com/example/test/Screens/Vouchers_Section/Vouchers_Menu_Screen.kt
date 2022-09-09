package com.example.test.Screens.Vouchers_Section

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.Classes.Screen

@Composable
fun Vouchers_Menu_with_WithTopBar(
   navController: NavController
) {
   Scaffold(
      topBar = {
         TopAppBar(
            title = {
               Text(text = "All Vouchers")
            },
            navigationIcon = {
               IconButton(onClick = {
                  navController.navigate(Screen.Home.route){
                     popUpTo(Screen.Home.route) {
                        inclusive = true
                     }
                  }
               }) {
                  Icon(Icons.Filled.ArrowBack, "backIcon")
               }
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White,
            elevation = 10.dp
         )
      }, content = {

         Vouchers_Menu(navController)

      }
   )
}




@Composable
fun Vouchers_Menu(navController: NavController) {
   val context = LocalContext.current
   var expended by remember { mutableStateOf(false) }

   Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
         .fillMaxSize()
      //.background(MainScreenColor)
      //.background(ScreenColor)
   ) {

      //Spacer(modifier = Modifier.height(33.dp))

      Text(
         text = "Vouchers Menu",
         fontSize = 42.sp
      )

      Spacer(modifier = Modifier.height(33.dp))

      Row(
         verticalAlignment = Alignment.Top,
         horizontalArrangement = Arrangement.SpaceAround,
         modifier = Modifier
            //.fillMaxHeight(5f)
            //.background(Color.Blue)
            .fillMaxWidth()
            .padding(12.dp),
         //.height(400.dp)

      ) {


         Card(
            modifier = Modifier
               .width(150.dp)
               .height(80.dp)
               .clickable {
                  navController.navigate(Screen.AllVouchersByMonth.route)
               },
            RoundedCornerShape(7.dp),
            elevation = 7.dp
            //.padding(40.dp)
         ) {
            Text(
               text = "All Vouchers",
               fontSize = 22.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center
            )
         }

      } // END Column


   }

}

