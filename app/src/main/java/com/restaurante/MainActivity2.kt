package com.restaurante

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private lateinit var autoresRef: DatabaseReference

    val TAG = "FBDemo"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth= FirebaseAuth.getInstance()
        /*btnCerrarSesion.setOnClickListener {
            auth.signOut()
            finish()
        }*/
        db = FirebaseDatabase.getInstance()
    }






}