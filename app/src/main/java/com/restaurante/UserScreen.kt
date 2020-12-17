package com.restaurante

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_screen.*


class UserScreen : AppCompatActivity()
{
    val user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_screen)

        if (user != null) {
            // Name, email address, and profile photo Url
            val name = user.displayName
            val email = user.email
            val photoUrl: Uri? = user.photoUrl
            // Check if user's email is verified
            val emailVerified = user.isEmailVerified

            Picasso.get().load(photoUrl.toString())
                .into(UserPPImg)

            UserNameTxt.text = name
        }


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