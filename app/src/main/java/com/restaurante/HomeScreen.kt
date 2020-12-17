package com.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class HomeScreen : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase

    val TAG = "FBDemo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        auth= FirebaseAuth.getInstance()
        /*btnCerrarSesion.setOnClickListener {
            auth.signOut()
            finish()
        }*/
        db = FirebaseDatabase.getInstance()
    }

    fun homeScreen(view: View)
    {
        val intent = Intent(this, HomeScreen::class.java)

        startActivity(intent)
    }

    fun searchScreen(view: View)
    {
        val intent = Intent(this, SearchScreen::class.java)

        startActivity(intent)
    }


    fun userScreen(view: View)
    {
        val intent = Intent(this,UserScreen::class.java)

        startActivity(intent)
    }




}