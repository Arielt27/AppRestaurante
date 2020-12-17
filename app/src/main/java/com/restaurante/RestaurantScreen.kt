package com.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.restaurant_screen.*
import kotlinx.android.synthetic.main.user_screen.*

class RestaurantScreen : AppCompatActivity()
{

    val restaurantList = MainActivity.SingletonRests

    val user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_screen)

        for (i in 0..restaurantList.size()-1)
        {
           if (restaurantList.getName(i).equals(restaurantList.restauranteActual))
           {
               var actual:Restaurant = restaurantList.get(i)
               Picasso.get().load(actual.imagenURL)
                   .into(RestPicImg)
               RestauranteTxt.text = actual.nombre
               location.text = actual.ubicacion
               phone.text = actual.telefono
           }
        }


    }

}