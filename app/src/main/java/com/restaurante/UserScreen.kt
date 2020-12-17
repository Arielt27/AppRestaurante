package com.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class UserScreen : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_screen)
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