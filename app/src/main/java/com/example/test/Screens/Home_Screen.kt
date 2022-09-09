package com.example.test.Screens

import android.widget.Toast
//import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test.Classes.Screen
//import com.example.test.DataStore.StoreUserName
//import com.example.test.DataStore.StoreUserName
//import kotlinx.coroutines.launch

@Composable
fun Screen_A_with_WithTopBar(
   navController: NavController
) {
   Scaffold(
      topBar = {
         TopAppBar(
            title = {
               Text(text = "Top App Bar")
            },
            navigationIcon = {
               IconButton(onClick = {
                  //navController.navigate(Screen.Home.route)
               }) {
                  Icon(Icons.Filled.Menu, "backIcon")
               }
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White,
            elevation = 10.dp
         )
      }, content = {
         Screen_A(
            navController,
            //usernameViewModel,
            //passwordViewModel
         )
      }
   )
}



@Composable
fun Screen_A(
   navController: NavController
) {
   val context = LocalContext.current
   //val shared = passwordViewModel.person

   //val scope = rememberCoroutineScope()
   // we instantiate the saveEmail class
   //val person = StoreUserName(context)

   //val Result_SessionID     = person.getSessionID.collectAsState(initial = "")
   //val Result_Username      = person.getUsername.collectAsState(initial = "")
   //val Result_Password      = person.getPassword.collectAsState(initial = "")
   //val Result_AccountStatus = person.getAccountStatus.collectAsState(initial = "")

   //val Result_UserDetailsID = person.getUserDetailsID.collectAsState(initial = "")
   //val Result_AccountType = person.getAccountType.collectAsState(initial = "")
   //val Result_Branch = person.getBranch.collectAsState(initial = "")
   //val Result_CompanyID = person.getCompanyID.collectAsState(initial = "")
   //val Result_LoginID = person.getLoginID.collectAsState(initial = "")

   //val us = passwordViewModel.person

   Column(
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
         .fillMaxSize()
         //.background(Color.Cyan)
         .padding(20.dp)
   ) {

      Column(
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier
            .fillMaxWidth()
            //.background(colorResource(id = R.color.QuruxColor))
            .padding(top = 70.dp, bottom = 70.dp)
      ) {
         Text(text = "khalid", fontSize = 33.sp, color = Color.White)
      }

      Spacer(modifier = Modifier.height(30.dp))

      //////////////////////////////////////////////////////////////////
      //////////////////////////////////////////////////////////////////
      Row(
         verticalAlignment = Alignment.Top,
         horizontalArrangement = Arrangement.SpaceBetween,
         modifier = Modifier
            .fillMaxWidth()
         //.background(Color.Cyan)

      ) {
         Card(
            modifier = Modifier
               .width(170.dp)
               .height(80.dp)
               .clickable {
                  navController.navigate(Screen.Vouchers_Menu.route)
               },
            RoundedCornerShape(7.dp),
            elevation = 5.dp
         ) {
            Text(
               text = "Vouchers",
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center
            )
         }

         Card(
            modifier = Modifier
               .width(170.dp)
               .height(80.dp)
               .clickable {
                  Toast
                     .makeText(context, "Signout", Toast.LENGTH_SHORT)
                     .show()
                  //scope.launch {
                     //person.saveUsername("")
                     //person.savePassword("")
                     //person.saveAccountStatus("")
                  //}
                  //navController.navigate(Screen.DropDownMenu.route)
                  //Alert()
               },
            RoundedCornerShape(7.dp),
            elevation = 5.dp
            //.padding(40.dp)
         ) {
            Text(
               text = "Sign OUT",
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center
            )
         }


      } // END Column

      Spacer(modifier = Modifier.height(30.dp))









   }
}
