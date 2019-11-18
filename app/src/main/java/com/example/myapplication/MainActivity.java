package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        if(usuario.length() == 0){
            Toast.makeText(this,"No has escrito nada",Toast.LENGTH_LONG).show();
        }
        else{
            if(Eusuario.equals(usuario) && Epassword.equals(password)){
                Toast.makeText(this,"Usuario correcto",Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this, tareas_main.class);
                startActivity(i);
                finish();
            }
            else{
                Toast.makeText(this,"Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
        }
    }
}
