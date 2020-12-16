package com.example.datosusuariosupe;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import entidades.conexionSqlHelper;
import utils.utils;

public class ConsultarUsuario extends AppCompatActivity implements View.OnClickListener {
    EditText edtId, edtNom, edttel;
    Button btnbuscar;
    conexionSqlHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);
        edtId=findViewById(R.id.edtCUid);
        edtNom=findViewById(R.id.edtCUnombre);
        edttel=findViewById(R.id.edtCUTel);
        btnbuscar=findViewById(R.id.btnconsulUsuario);
        btnbuscar.setOnClickListener(this);
        conn=new conexionSqlHelper(this, "bd_usuarios",null,1);
    }

    @Override
    public void onClick(View view) {
        consultar();
    }
    private void consultar(){
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={edtId.getText().toString()};
        String[] campos={utils.CAMPO_NOMBRE,utils.CAMPO_TELEFONO};
        try {
            Cursor cursor=db.query(utils.TABLA_USUARIO,campos,utils.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            edtNom.setText(cursor.getString(0));
            edttel.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this,"El registro buscado no existe",Toast.LENGTH_SHORT).show();
        };
    }
}