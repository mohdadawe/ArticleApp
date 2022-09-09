package com.example.test.Screens.Vouchers_Section

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.test.Classes.Article.Article
import com.example.test.Classes.Article.ArticleItem
import com.example.test.Classes.Screen
import com.example.test.ui.theme.Items
import com.google.gson.GsonBuilder

@Composable
fun All_Vouchers_By_Month_Screen_WithTopBar(
   navController: NavController
) {
   Scaffold(
      topBar = {
         TopAppBar(
            title = {
               Text(text = "Vouchers By Month")
            },
            navigationIcon = {
               IconButton(onClick = {
                  navController.navigate(Screen.Vouchers_Menu.route){
                     popUpTo(Screen.Vouchers_Menu.route) {
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

         All_Vouchers_By_Month_Screen()

      }
   )
}


@Composable
fun All_Vouchers_By_Month_Screen(
   /*navController: NavController*/
) {
   Column(
      modifier = Modifier
         .fillMaxSize(),
         //.background(MainScreenColor),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
   ) {

      val context = LocalContext.current
      //Toast.makeText(context, "welcome", Toast.LENGTH_SHORT).show()


      //////////////////////////////////////////////////
      //////////////////////////////////////////////////
      //////////////////////////////////////////////////


      //val baseUrl = "https://adeega.xisaabso.online/Api/android_last_vouchers.php"
      val baseUrl = "https://adeega.xisaabso.online/Api/Article.php"

      val articles = Article()

      val data = remember {
         mutableStateOf(Article())
      }

      val stringRequest = StringRequest(baseUrl, { it ->
         val gsonBuilder = GsonBuilder()
         val gson = gsonBuilder.create()
         gson.fromJson(it, Array<ArticleItem>::class.java)?.forEach {
            articles.add(it)
         }
         data.value = articles

      }, {
         Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
      }).apply {

         LazyColumn(
            contentPadding = PaddingValues(
               horizontal = 12.dp,
               vertical = 0.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp)
         ) {
            items(data.value) { item ->
               Cards_Last_Vouchers(data = item)
            }
         } // END LazyColumn

      }// StringRequest

      val volleyRequest = Volley.newRequestQueue(context)
      volleyRequest.add(stringRequest)


   } // END Column

}


@Composable
fun Cards_Last_Vouchers(data : ArticleItem){
   //val context = LocalContext.current
   //val REQUEST_PHONE_CALL = 1

   Row(
      modifier = Modifier
         .fillMaxSize()
         .background(Items),
      //RoundedCornerShape(0.dp),
      //elevation = 0.dp
   ) {

      Column(
         modifier = Modifier
            //.background(Color.Green)
            .fillMaxSize()
            .padding(20.dp)
      ) {
         Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
               .fillMaxWidth()
            //.background(Color.LightGray)
         ) {

            Text(
               text = "#" + data.ID,
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold
            )

            Text(
               text = data.Created,
               fontSize = 16.sp,
               fontWeight = FontWeight.Bold
            )

         }

         Spacer(modifier = Modifier.height(5.dp))

         Text(
            text = data.Title,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
         )

         Spacer(modifier = Modifier.height(10.dp))

         Text(
            text = data.Description,
            fontSize = 22.sp,
            /*fontWeight = FontWeight.Bold*/
         )

         ///////////////////////////////////////////////////
         ///////////////////////////////////////////////////
         ///////////////////////////////////////////////////
         /*
         Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
               //.background(color = Color.Yellow)
               .fillMaxSize()
               .padding(
                  start = 30.dp,
                  end = 30.dp,
                  top = 0.dp,
                  bottom = 0.dp
               )
         ) {

            // DOLLAR
            Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
               //.background(Color.LightGray)
            ) {
               Text(
                  text = "USD",
                  fontSize = 20.sp,
                  fontWeight = FontWeight.Bold
               )
               Text(
                  text = "$" + data.AmountUSDPaid,
                  fontSize = 21.sp,
                  fontWeight = FontWeight.Bold
               )

            }

            // SHILIN
            Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
               //.background(Color.LightGray)
            ) {
               Text(text = "SLSH",
                  fontSize = 20.sp,
                  fontWeight = FontWeight.Bold
               )

               Text(
                  text = data.AmountLocalCurrPaid.toString(),
                  fontSize = 21.sp,
                  fontWeight = FontWeight.Bold
               )

            }

            // TOTAL
            Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier
               //.background(Color.LightGray)
            ) {
               Text(
                  text = "Total",
                  fontSize = 20.sp,
                  fontWeight = FontWeight.Bold
               )
               Text(
                  text = "$" + data.TotalTwoCurrAmountUSD,
                  fontSize = 21.sp,
                  fontWeight = FontWeight.Bold
               )

            }


         }

         Spacer(modifier = Modifier.height(16.dp))

         Row(
            horizontalArrangement =  Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
               .fillMaxWidth()
            //.background(Color.Green)
         ) {

            Text(
               text = data.zs_payment_type_name,
               fontSize = 16.sp,
               fontWeight = FontWeight.Bold
            )

            Text(
               text = data.PaymentDate,
               fontSize = 16.sp,
               fontWeight = FontWeight.Bold
            )
         }
         */
         ///////////////////////////////////////////////////
         ///////////////////////////////////////////////////
         ///////////////////////////////////////////////////




      }

      //} //END Row

   } //END Card

}

