package com.example.loginretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.loginretrofit.model.Login;
import com.example.loginretrofit.model.User;
import com.example.loginretrofit.services.UserClient;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    UserClient userClient = retrofit.create(UserClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_login).setOnClickListener(view -> {login();});
        findViewById(R.id.btn_secret).setOnClickListener(view -> {getSecret();});
    }

    private static String token;

    private void login(){
        Login login = new Login("future", "studio");
        Call<User> call= userClient.login(login);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                    token = response.body().getToken();
                }else{
                    Toast.makeText(MainActivity.this, "login not correct :(", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getSecret(){

      Call<ResponseBody> call = userClient.getSecret(token);

      call.enqueue(new Callback<ResponseBody>() {
          @Override
          public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
              if (response.isSuccessful()){
                  try {
                      Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_SHORT).show();
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }
              }else{
                  Toast.makeText(MainActivity.this, "token is not correct :(", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<ResponseBody> call, Throwable t) {
              Toast.makeText(MainActivity.this, "error :(", Toast.LENGTH_SHORT).show();
          }
      });
    }
}