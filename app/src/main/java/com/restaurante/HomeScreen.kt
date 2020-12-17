package com.restaurante

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.home_screen.*
import kotlinx.android.synthetic.main.layout_view_holder.*


class HomeScreen : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    lateinit var rcvRestaurant: RecyclerView
    var singleton = MainActivity.SingletonRests

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        val restaurantListAdapter = RestaurantListRecycleViewAdapter()

        auth= FirebaseAuth.getInstance()
        /*btnCerrarSesion.setOnClickListener {
            auth.signOut()
            finish()
        }*/
        db = FirebaseDatabase.getInstance()

        rcvRestaurant = RecyvlerVw
        rcvRestaurant.layoutManager = LinearLayoutManager(this)
        rcvRestaurant.adapter = restaurantListAdapter

    }

    fun restaurantScreen(view: View)
    {
        singleton.restauranteActual = nombreRestauranteTxT.text.toString()
        val intent = Intent(this, RestaurantScreen::class.java)

        startActivity(intent)
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
        val intent = Intent(this, UserScreen::class.java)

        startActivity(intent)
    }


}