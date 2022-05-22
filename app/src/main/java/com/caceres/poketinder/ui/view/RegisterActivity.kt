package com.caceres.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.caceres.poketinder.databinding.ActivityRegisterBinding
import com.caceres.poketinder.ui.viewmodel.RegisterViewModel

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerViewModel = RegisterViewModel(this)
        registerViewModel.onCreate()
        registerViewModel.emptyFieldsError.observe(this){
            Toast.makeText(this,"Todos los campos estan vacios", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.fieldNameError.observe(this){
            binding.tvNameUser.visibility = View.GONE
            Toast.makeText(this,"Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.fieldEmailError.observe(this){
            binding.tvEmailUser.visibility = View.VISIBLE
            Toast.makeText(this,"Por favor ingrese su email", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.fieldPasswordError.observe(this){
            binding.tvPasswordUser.visibility = View.VISIBLE
            Toast.makeText(this,"Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.fieldsPassword2Error.observe(this){
            Toast.makeText(this,"Por favor ingrese su contraseña de confirmación", Toast.LENGTH_SHORT).show()
        }
        registerViewModel.fieldPasswordAuthenticateError.observe(this){
            Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.goSucessActivity.observe(this){
            binding.tvNameUser.visibility = View.GONE
            binding.tvEmailUser.visibility = View.GONE
            binding.tvPasswordUser.visibility = View.GONE

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    fun registerUser(view: View){
        registerViewModel.validateInput(binding.edtUserName.text.toString(),binding.edtEmail.text.toString(),binding.edtPassword.text.toString(),binding.edtPassword2.text.toString())

    }
    fun loginUser(view: View){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }
}