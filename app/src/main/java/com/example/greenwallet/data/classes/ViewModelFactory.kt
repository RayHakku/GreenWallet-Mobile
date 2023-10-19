package com.example.greenwallet.data.classes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.greenwallet.data.viewmodels.HomeViewModel
import com.example.greenwallet.data.viewmodels.LoginViewModel
import com.example.greenwallet.data.viewmodels.RegisterViewModel

class ViewModelFactory(
    private val navController: NavController,
    private val sharedPreferencesProvider: SharedPreferencesProvider?

) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(navController) as T
        } else if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(navController,sharedPreferencesProvider) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(navController,sharedPreferencesProvider) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
