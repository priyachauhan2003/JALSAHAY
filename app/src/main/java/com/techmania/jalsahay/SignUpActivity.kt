package com.techmania.jalsahay

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import com.techmania.jalsahay.databinding.ActivityMainBinding
import com.techmania.jalsahay.databinding.ActivitySignUpBinding
import com.techmania.jalsahay.models.User
import com.techmania.jalsahay.utils.USER_NODE

class SignUpActivity : AppCompatActivity() {

    val binding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        user = User()
        window.statusBarColor = Color.TRANSPARENT
        binding.login.text = Html.fromHtml(
            "<font color=${Color.BLACK}>Already have an account? </font>" +
                    "<font color=#1E88E5> Login</font>"
        )
        binding.login.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity:: class.java))
            finish()
        }
        binding.signUpBtn.setOnClickListener{
            if (binding.name.editText?.text.toString().equals("") or
                binding.email.editText?.text.toString().equals("") or
                binding.password.editText?.text.toString().equals("")
            ) {
                Toast.makeText(this@SignUpActivity, "Please fill required info", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email.editText?.text.toString(),
                    binding.password.editText?.text.toString()
                ).addOnCompleteListener { result ->

                    if (result.isSuccessful) {
                        Toast.makeText(this@SignUpActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                        user.name = binding.name.editText?.text.toString()
                        user.email = binding.email.editText?.text.toString()
                        user.password = binding.password.editText?.text.toString()
                    Firebase.firestore.collection(USER_NODE).document(Firebase.auth.currentUser!!.uid).set(user)
                        .addOnSuccessListener {
                            startActivity(Intent(this@SignUpActivity, HomeActivity::class.java))
                            finish()
                        }
                    } else {
                        Toast.makeText(
                            this@SignUpActivity,
                            result.exception?.localizedMessage ?: null, Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}