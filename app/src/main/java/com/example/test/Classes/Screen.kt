package com.example.test.Classes

sealed class Screen(val route: String) {

   object DashBoard: Screen(route = "DashBoard")
   object Home: Screen(route = "Home")
   object vouchers_Menu: Screen(route = "vouchers_menu")
   object AllVouchersByMonth: Screen(route = "AllVouchersByMonth_Screen")

   //object C: Screen(route = "C")
   //object Search_Screen: Screen(route = "Search_Screen")

   //object Customers_Calling_Screen: Screen(route = "Customers_Calling_Screen")
   //object Sarif: Screen(route = "Sarif_Screen")

   //object Search_Screen_Details: Screen(route = "Search_Screen_Details")
   //object All_vouchers_by_customer: Screen(route = "All_vouchers_by_customer_screen")



   //object DropDownMenu: Screen(route = "DropDownMenu")

   //object LoginScreen: Screen(route = "LoginPage_route")
   //object PasswordScreen: Screen(route = "PasswordPage_route")
   //object AllVouchersToday: Screen(route = "All_Vouchers_Today_Screen")

}

