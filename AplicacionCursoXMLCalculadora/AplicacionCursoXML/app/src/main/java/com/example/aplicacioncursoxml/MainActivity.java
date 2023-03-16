package com.example.aplicacioncursoxml;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.txt_number_1);
        editText2 = (EditText) findViewById(R.id.txt_number_2);
        textView = (TextView) findViewById(R.id.resultado);
    }

    //Este método realiza la suma de los dos componente que el usuario va a pasar
    public void Sumar(View view){

        String value1 = editText.getText().toString();
        String value2 = editText2.getText().toString();

        int num1 = Integer.parseInt(value1); //hemos cambiado de un tipo String a un tipo entero, esto es a lo que se refiere a pasear
        int num2 = Integer.parseInt(value2);

        int suma = num1 + num2;

        //Como el resultado en el diseño es String, habrá que volver hacer un parseo para pasarlo a un entero
        //String result = suma + ""; Esto es parsear de String a un parseo pero es de una froma básica

        String result = String.valueOf(suma); //Hemos parseado de un String a un entero

        textView.setText(result);
    }
}