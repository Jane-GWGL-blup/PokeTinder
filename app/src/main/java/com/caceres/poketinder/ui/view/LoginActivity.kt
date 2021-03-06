package com.caceres.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.caceres.poketinder.databinding.ActivityLoginBinding
import com.caceres.poketinder.ui.viewmodel.LoginViewModel

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginViewModel = LoginViewModel(this)
        loginViewModel.onCreate()
        loginViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this,"Ingrese los datos de Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.fieldsAuthenticateError.observe(this){
            Toast.makeText(this,"Error de Usuario", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.goSucessActivity.observe(this){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun startLogin(view: View){
        loginViewModel.validateInput(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())
    }

    fun startSignUp(view: View){
        val intent = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(intent)
    }
}