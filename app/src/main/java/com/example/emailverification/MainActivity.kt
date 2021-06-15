package com.example.emailverification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

var email = "meassadkhan@gmail.com"
var pass = "asad255244"
        var name = "Assad Khan"
        auth  = Firebase.auth

        var button = findViewById<Button>(R.id.button)



button.setOnClickListener {
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful) {
                var user = auth.currentUser
                //Email Verification Send below

                if (user != null) {
                    user.sendEmailVerification().addOnSuccessListener {
                        //Intent to SignIn activity after verification
                        var intent = Intent(this,Signin::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Verification Link Sent to email ", Toast.LENGTH_SHORT).show()
                                       finish()}
                        .addOnFailureListener { Toast.makeText(this, "Verification link sending fail", Toast.LENGTH_SHORT).show() }
                } else { Toast.makeText(this, "User is null", Toast.LENGTH_SHORT).show() } } }.addOnFailureListener {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        }

    }}
}