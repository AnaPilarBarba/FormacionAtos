package com.example.loginwithtoken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginwithtoken.apis.ApiClient
import com.example.loginwithtoken.apis.ApiService
import com.example.loginwithtoken.model.ProductResponse
import com.example.loginwithtoken.security.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var apiClient: ApiClient

    private lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun fetchPosts() {
        apiClient.getApiService(this).fetchPosts()
            .enqueue(object : Callback<ProductResponse> {
                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    // Error fetching posts
                }

                override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                    // Handle function to display posts
                }
            })
    }
}