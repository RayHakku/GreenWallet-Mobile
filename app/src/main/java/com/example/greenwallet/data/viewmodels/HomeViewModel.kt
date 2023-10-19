package com.example.greenwallet.data.viewmodels

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.greenwallet.data.classes.SharedPreferencesProvider
import com.example.greenwallet.data.classes.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class HomeViewModel(
    private val navController: NavController,
    private val sharedPreferencesProvider: SharedPreferencesProvider?,
): ViewModel() {


    val db = Firebase.database
    val auth = FirebaseAuth.getInstance()
    val usersRef = db.getReference("users")

    /*var cUid = auth.currentUser?.uid*/
    var cUser = User()

    fun logout(){
        auth.signOut()
        sharedPreferencesProvider?.saveBoolean("rememberMe", false)
        navController.popBackStack()
        navController.navigate("login_screen")
    }
    suspend fun getCurrentUserData(cUid:String): User {
        return try {
            val dataSnapshot = usersRef.child(cUid).get().await()
            cUser = dataSnapshot.getValue(User::class.java) ?: User() // Provide a default value if data is not found
            cUser
        } catch (e: Exception) {
            // Handle any exceptions, e.g., database errors
            throw e
        }
    }


}