package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferencias= getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        editor.putString("Eusuario", "admin");
        editor.putString("Epassword", "admin");
        editor.commit();
    }

    public void iniciarSesion(View view){

        SharedPreferences preferencias= getPreferences(MODE_PRIVATE);


        EditText Eusuario = (EditText)findViewById(R.id.regisUsuario);
        EditText Epassword = (EditText)findViewById(R.id.regisPass);

        String usuario = preferencias.getString("Eusuario","");
        String password = preferencias.getString("Epassword","");
    }
}
