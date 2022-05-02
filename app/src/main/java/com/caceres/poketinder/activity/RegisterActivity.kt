package com.caceres.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.caceres.poketinder.data.User
import com.caceres.poketinder.databinding.ActivityRegisterBinding
import com.caceres.poketinder.util.SharedPreferenceUtil

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }

    fun validateInput(){
        if(binding.edtUserName.text.isEmpty() && binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            binding.tvNameUser.visibility = View.VISIBLE
            binding.tvEmailUser.visibility = View.VISIBLE
            binding.tvPasswordUser.visibility = View.VISIBLE
            Toast.makeText(this,"Todo los campos estan vacios", Toast.LENGTH_SHORT).show()
        }

        else if(binding.edtUserName.text.isEmpty()){
            binding.tvNameUser.visibility = View.GONE
            Toast.makeText(this,"Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
        }

        else if(binding.edtEmail.text.isEmpty()){
            binding.tvEmailUser.visibility = View.VISIBLE
            Toast.makeText(this,"Por favor ingrese su email", Toast.LENGTH_SHORT).show()
        }

        else if(binding.edtPassword.text.isEmpty()){
            binding.tvPasswordUser.visibility = View.VISIBLE
            Toast.makeText(this,"Por favor ingrese su contraseña", Toast.LENGTH_SHORT).show()
        }

        else if((binding.edtPassword2.text.toString()) != (binding.edtPassword.text.toString())){
            Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }

        else{
            binding.tvNameUser.visibility = View.GONE
            binding.tvEmailUser.visibility = View.GONE
            binding.tvPasswordUser.visibility = View.GONE

            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    fun registerUser(view: View){


        val user = User(
            id = "1",
            name = binding.edtUserName.text.toString(),
            email = binding.edtEmail.text.toString(),
            password = binding.edtPassword.text.toString())

        sharedPreferenceUtil.saveFacebookUser(user)
            validateInput()

    }
}