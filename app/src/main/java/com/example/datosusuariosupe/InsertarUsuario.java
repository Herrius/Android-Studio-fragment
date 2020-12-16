package com.example.datosusuariosupe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import entidades.conexionSqlHelper;
import utils.utils;

public class InsertarUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText edtId,edtNom,edtTel;
    Button btnInsertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_usuario);
        edtId=findViewById(R.id.edtIUid);
        edtNom=findViewById(R.id.edtIUnom);
        edtTel=findViewById(R.id.edtIUtele);
        btnInsertar=findViewById(R.id.btnIUSregusuario);
        btnInsertar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        registrarUsuarios();
    }

    private void registrarUsuarios() {

        conexionSqlHelper conn=new conexionSqlHelper(this,"bd_usuarios", null,1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(utils.CAMPO_ID,edtId.getText().toString());
        values.put(utils.CAMPO_NOMBRE,edtNom.getText().toString());
        values.put(utils.CAMPO_TELEFONO,edtTel.getText().toString());
        Long resultado=db.insert(utils.TABLA_USUARIO,utils.CAMPO_ID,values);
        Toast.makeText(this,"Id de registro"+ resultado,Toast.LENGTH_SHORT).show();
        db.close();
    }
}