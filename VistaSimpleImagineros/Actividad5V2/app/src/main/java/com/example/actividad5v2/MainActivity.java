package com.example.actividad5v2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import com.example.actividad5v2.network.model.ImagineroResponse;
import com.example.actividad5v2.network.model.ImaginerosDeObras;
import com.example.actividad5v2.network.model.Obras;
import com.example.actividad5v2.network.model.ObrasResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private TextView obrasText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obrasText = findViewById(R.id.obrasText);
        getImagineroList();
    }

    private void getImagineroList(){

        Call<ImagineroResponse> call = new RetrofitClient(this).getObrasApi().getImagineroList();

        call.enqueue(new Callback<ImagineroResponse>() {
            @Override
            public void onResponse(Call<ImagineroResponse> call, Response<ImagineroResponse> response) {
                if (!response.isSuccessful()){
                    obrasText.setText("Codigo: " + response.code());
                    return;
                }
                List<ImaginerosDeObras> listObras = response.body().getContent();

                for(ImaginerosDeObras obrasResponse: listObras){
                    String content = "";
                    content += "name: " + obrasResponse.getName();

                    obrasText.append(content);
                }
            }

            @Override
            public void onFailure(Call<ImagineroResponse> call, Throwable t) {
                obrasText.setText(t.getMessage());
            }
        });

    }

    private void getObrasList(){


        Call<ObrasResponse> call = new RetrofitClient(this).getObrasApi().getObrasList();
        call.enqueue(new Callback<ObrasResponse>() {
            @Override
            public void onResponse(Call<ObrasResponse> call, Response<ObrasResponse> response) {
                if (!response.isSuccessful()){
                    obrasText.setText("Codigo: " + response.code());
                    return;
                }
                List<Obras> listObras = response.body().getContent();

                for(Obras obrasResponse: listObras){
                    String content = "";
                    content += "name: " + obrasResponse.getName() + "\n";
                    content += "img: " + obrasResponse.getImg();

                    obrasText.append(content);
                }
            }

            @Override
            public void onFailure(Call<ObrasResponse> call, Throwable t) {
                obrasText.setText(t.getMessage());
            }
        });
    }
}