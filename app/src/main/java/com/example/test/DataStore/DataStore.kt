package com.example.test.DataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserName(private val context: Context) {
   // to make sure there's only one instance
   companion object {
      private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userEmail")
      val USERNAME_KEY       = stringPreferencesKey("username")
      val PASSWORD_KEY       = stringPreferencesKey("password")
      val SESSION_ID_KEY     = stringPreferencesKey("sessionID")
      val ACCOUNT_STATUS_KEY = stringPreferencesKey("accountStatus")
      val ACCOUNT_TYPE_KEY   = stringPreferencesKey("accountType")

      val USER_DETAILS_ID_KEY = stringPreferencesKey("userDetailsID")
      val BRANCH_KEY          = stringPreferencesKey("sessionID")
      val COMPANY_ID_KEY      = stringPreferencesKey("companyID")
      val LOGIN_ID_KEY        = stringPreferencesKey("loginID")

      val XISAAB_XIDHKA       = stringPreferencesKey("xisaab_xidhka")
      val EDIT_VOUCHER        = stringPreferencesKey("save_edit_voucher")
   }



   //get the saved username
   val getUsername: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[USERNAME_KEY] ?: ""
      }

   //get the saved username
   val getPassword: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[PASSWORD_KEY] ?: ""
      }


   //get the saved SessionID
   val getSessionID: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[SESSION_ID_KEY] ?: ""
      }

   //get the saved AccountStatus
   val getAccountStatus: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[ACCOUNT_STATUS_KEY] ?: ""
      }

   //get the saved AccountType
   val getAccountType: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[ACCOUNT_TYPE_KEY] ?: ""
      }

   //get the saved DetailsID
   val getUserDetailsID: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[USER_DETAILS_ID_KEY] ?: ""
      }

   //get the saved Branch
   val getBranch: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[BRANCH_KEY] ?: ""
      }

   //get the saved CompanyID
   val getCompanyID: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[COMPANY_ID_KEY] ?: ""
      }

   //get the saved LoginID
   val getLoginID: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[LOGIN_ID_KEY] ?: ""
      }


   //get the saved xisaabXidhka
   val getXisaabXidhka: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[XISAAB_XIDHKA] ?: ""
      }

   //get the saved Edit Voucher
   val getEditVoucher: Flow<String?> = context.dataStore.data
      .map { preferences ->
         preferences[EDIT_VOUCHER] ?: ""
      }
   ///////////////////////////////////////////////////////////
   ///////////////////////////////////////////////////////////
   ///////////////////////////////////////////////////////////

   //save username into datastore
   suspend fun saveUsername(username: String) {
      context.dataStore.edit { preferences ->
         preferences[USERNAME_KEY] = username
      }
   }

   //save password into datastore
   suspend fun savePassword(password: String) {
      context.dataStore.edit { preferences ->
         preferences[PASSWORD_KEY] = password
      }
   }

   //save SessionID into datastore
   suspend fun saveSessionID(sessionID: String) {
      context.dataStore.edit { preferences ->
         preferences[SESSION_ID_KEY] = sessionID
      }
   }

   //save AccountStatus into datastore
   suspend fun saveAccountStatus(accountStatus: String) {
      context.dataStore.edit { preferences ->
         preferences[ACCOUNT_STATUS_KEY] = accountStatus
      }
   }

   //save AccountType into datastore
   suspend fun saveAccountType(accountType: String) {
      context.dataStore.edit { preferences ->
         preferences[ACCOUNT_TYPE_KEY] = accountType
      }
   }

   //save UserDetailsID into datastore
   suspend fun saveUserDetailsID(userDetailsID: String) {
      context.dataStore.edit { preferences ->
         preferences[USER_DETAILS_ID_KEY] = userDetailsID
      }
   }

   //save Branch into datastore
   suspend fun saveBranch(branch: String) {
      context.dataStore.edit { preferences ->
         preferences[BRANCH_KEY] = branch
      }
   }

   //save CompanyID into datastore
   suspend fun saveCompanyID(companyID: String) {
      context.dataStore.edit { preferences ->
         preferences[COMPANY_ID_KEY] = companyID
      }
   }

   //save LoginID into datastore
   suspend fun saveLoginID(loginID: String) {
      context.dataStore.edit { preferences ->
         preferences[LOGIN_ID_KEY] = loginID
      }
   }

   //save XisaabXidhka into datastore
   suspend fun saveXisaabXidhka(XisaabXidhka: String) {
      context.dataStore.edit { preferences ->
         preferences[XISAAB_XIDHKA] = XisaabXidhka
      }
   }

   //save getEditVoucher into datastore
   suspend fun saveEditVoucher(EditVoucher: String) {
      context.dataStore.edit { preferences ->
         preferences[EDIT_VOUCHER] = EditVoucher
      }
   }




}

