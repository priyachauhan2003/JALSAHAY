package com.techmania.jalsahay

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.techmania.jalsahay.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signin.text = Html.fromHtml(
                    "<font color=#1E88E5> Create a new account</font>"
        )
    }
}