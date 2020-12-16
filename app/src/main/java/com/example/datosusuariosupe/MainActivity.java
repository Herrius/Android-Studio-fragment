package com.example.datosusuariosupe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnInsUsuario, btnConsultUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsUsuario=findViewById(R.id.btnMAInsUsuario);
    }
    public void llamarInsUsuario(View v){
        Intent i=new Intent(this,InsertarUsuario.class);
        startActivity(i);
    }
    public void llamarConsultarUsuario(View v){
        Intent i=new Intent(this,ConsultarUsuario.class);
        startActivity(i);
    }
    public void llamarListarUserSpinner(View v){
        Intent i=new Intent(this,ListarUsersSpinner.class);
        startActivity(i);
    }
    public void llamarList_item_usuario(View v){
        Intent i=new Intent(this,ListarRecycle.class);
        startActivity(i);
    }
}