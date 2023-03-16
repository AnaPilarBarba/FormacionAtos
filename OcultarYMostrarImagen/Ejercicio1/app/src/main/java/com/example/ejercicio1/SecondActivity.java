package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = findViewById(R.id.gatito_image);
        final boolean[] invisible = {true};

        Button button = findViewById(R.id.button_ghost);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                if (invisible[0]){

                    imageView.setVisibility(View.INVISIBLE);
                    invisible[0] = false;
                }else {
                    imageView.setVisibility(View.VISIBLE);
                    invisible[0] = true;

                }
            }
        });
    }
}