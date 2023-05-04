package com.example.helploginwithtoken

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity(context: Context) : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)

        usernameEditText = findViewById(R.id.editTextTextPersonName)
        passwordEditText = findViewById(R.id.id_password)
        loginButton = findViewById(R.id.btn_login)

        loginButton.setOnClickListener{
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            apiClient.getApiService(this).login(LoginRequest(email = email, password = password))
                .enqueue(object : Callback<LoginResponse>{

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, "No funciona crack", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val loginResponse = response.body()

                        if (loginResponse?.statusCode == 200 && loginResponse.user != null){

                            sessionManager.saveAuthToken(loginResponse.authToken)
                            val  intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                            Toast.makeText(applicationContext, "Funciona crack", Toast.LENGTH_SHORT).show()
                        }else{

                        }
                    }

                } )
        }

    }
}