package com.example.emailverification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)


        var auth = FirebaseAuth.getInstance()
        var userId = auth.currentUser?.uid
        var user : FirebaseUser? = Firebase.auth.currentUser


        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
        if (user != null) {
            if (user.isEmailVerified) {

                var intent = Intent(this, home::class.java)
                startActivity(intent)
                Toast.makeText(this, "Verification Link Sent to email ", Toast.LENGTH_SHORT).show()
                finish()

                Toast.makeText(this, "Email is Verified", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email not verified", Toast.LENGTH_SHORT).show()
            }
        }

    }}}
