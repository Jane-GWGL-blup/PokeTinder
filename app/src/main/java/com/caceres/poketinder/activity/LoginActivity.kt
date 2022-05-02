package com.caceres.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.caceres.poketinder.data.User
import com.caceres.poketinder.databinding.ActivityLoginBinding
import com.caceres.poketinder.util.SharedPreferenceUtil

class LoginActivity: BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate) {
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
    }

    fun validateInput(){
        if(binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            Toast.makeText(this,"Email y contraseña vacíos", Toast.LENGTH_SHORT).show()

        }
    }

    fun startLogin(view: View){

        val user: User? = sharedPreferenceUtil.getUser()
         if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
             val intent = Intent(this, MainActivity::class.java)
             intent.putExtra("user",user)
             startActivity(intent)
         } else {
             Toast.makeText(this,"No existe el usuario", Toast.LENGTH_SHORT).show()
             validateInput()
         }
    }

    fun startSignUp(view: View){
        val intent = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(intent)
    }
}