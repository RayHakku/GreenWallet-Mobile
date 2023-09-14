package com.example.greenwallet

import android.app.Application
import com.google.firebase.FirebaseApp

class GreenWalletApp : Application() {

        override fun onCreate() {
            super.onCreate()

            // Initialize Firebase
            FirebaseApp.initializeApp(this)

        }
}