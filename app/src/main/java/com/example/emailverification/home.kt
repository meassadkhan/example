package com.example.emailverification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var auth = FirebaseAuth.getInstance()
        var fstore = FirebaseFirestore.getInstance()
        var verify = findViewById<Button>(R.id.verifyCode)
        var message = findViewById<TextView>(R.id.verifymessage)

        var userId = auth.currentUser?.uid
        var user : FirebaseUser? = auth.currentUser

        if (user != null) {
            if(user.isEmailVerified){
                Toast.makeText(this, "Email is Verified", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Email not verified", Toast.LENGTH_SHORT).show()
             }
        }
    }
}