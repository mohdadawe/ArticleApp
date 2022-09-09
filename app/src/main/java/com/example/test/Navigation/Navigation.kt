package com.example.test.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.Classes.Screen
import com.example.test.Screens.Screen_A_with_WithTopBar
import com.example.test.Screens.Vouchers_Section.All_Vouchers_By_Month_Screen_WithTopBar
import com.example.test.Screens.Vouchers_Section.Vouchers_Menu_with_WithTopBar


@Composable
fun Nav() {
   //val context = LocalContext.current
   val navController = rememberNavController()

   //val userNameViewModel: UsernameViewModel = viewModel()
   //val passwordViewModel: PasswordViewModel = viewModel()

   //val scope = rememberCoroutineScope()

   // we instantiate the saveEmail class
   //val person = StoreUserName(context)
   //val Result_Username = person.getUsername.collectAsState(initial = "")
   //val Result_Password = person.getPassword.collectAsState(initial = "")

   //Toast.makeText(context, Result_Username.value, Toast.LENGTH_LONG).show()

   NavHost(
      navController = navController,
      startDestination = Screen.Home.route
      /*
      if(Result_Password.value == "true")
         Screen.Home.route
      else
         Screen.LoginScreen.route
      */
   ) {

      composable(route = Screen.Home.route) {
         Screen_A_with_WithTopBar(
            navController,
            /*userNameViewModel,
            passwordViewModel*/
         )
      }

      composable(route = Screen.Vouchers_Menu.route) {
         Vouchers_Menu_with_WithTopBar(navController)
      }

      composable(route = Screen.AllVouchersByMonth.route) {
         All_Vouchers_By_Month_Screen_WithTopBar(navController)
      }
   }
}
