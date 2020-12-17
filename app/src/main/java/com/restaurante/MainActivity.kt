package com.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.login_screen.*


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var signInOptions: GoogleSignInOptions
    private lateinit var signInClient: GoogleSignInClient
    val RC_SIGN_IN: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        auth = FirebaseAuth.getInstance()
        initializeUI()
        setupGoogleLogin()
    }

    override fun onStart() {
        super.onStart()
        //Validar que no exista otra instancia corriendo
        val usuario = FirebaseAuth.getInstance().currentUser
        if (usuario != null) {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
            //finish()
        }
    }

    private fun setupGoogleLogin() {
        signInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        signInClient = GoogleSignIn.getClient(this, signInOptions)
    }

    private fun initializeUI() {
        google_button.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val loginIntent: Intent = signInClient.signInIntent
        startActivityForResult(loginIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    googleFirebaseAuth(account)
                }
            } catch (e: ApiException) {
                println(e.message)
                Toast.makeText(this, "Fallo inicio de sesión", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun googleFirebaseAuth(acct: GoogleSignInAccount) {
        val credenciales = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credenciales).addOnCompleteListener {
            if (it.isSuccessful) {
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fallo inicio de sesión", Toast.LENGTH_LONG).show()
            }
        }
    }

    object SingletonRests {

        var restaurants = listOf<Restaurant>()
        var restauranteActual = "DEFECTO"

        fun setList(restaurantList: List<Restaurant>) {
            restaurants = restaurantList
        }

         fun getName(i: Int) : String{
            return restaurants[i].nombre
        }

        fun get(i:Int):Restaurant
        {
            return restaurants[i]
        }

        fun size() : Int{
            return restaurants.size
        }
    }
}