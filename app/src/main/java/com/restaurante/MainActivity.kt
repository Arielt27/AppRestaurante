package com.restaurante

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity()
{
    private var mAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance();
    }

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.currentUser
        Log.d("RateRestaurant",currentUser.toString())
    }
}