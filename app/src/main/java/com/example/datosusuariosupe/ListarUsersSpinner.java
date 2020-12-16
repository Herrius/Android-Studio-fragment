package com.example.datosusuariosupe;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import entidades.Usuario;
import entidades.conexionSqlHelper;
import utils.utils;

public class ListarUsersSpinner extends AppCompatActivity {
    Spinner spPersonas;
    TextView txtId, txtNom, txtTel;
    ArrayList<String> listaUsuarios;
    ArrayList<Usuario> UsuarioList;
    conexionSqlHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_users_spinner);
        spPersonas = findViewById(R.id.cmbUsuarios);
        txtId = findViewById(R.id.txtDocumento);
        txtNom = findViewById(R.id.txtNombre);
        txtTel = findViewById(R.id.txtTelefono);
        conn = new conexionSqlHelper(this, "bd_usuarios", null, 1);
        consultarUsuarios();
        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                listaUsuarios);
        spPersonas.setAdapter(adaptador);
        spPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position != 0) {
                    txtId.setText(UsuarioList.get(position - 1).getId().toString());
                    txtNom.setText(UsuarioList.get(position - 1).getNombre().toString());
                    txtTel.setText(UsuarioList.get(position - 1).getTelefono().toString());
                } else {
                    txtId.setText("");
                    txtNom.setText("");
                    txtTel.setText("");

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void consultarUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Usuario usuario = null;
        UsuarioList = new ArrayList<Usuario>();
        Cursor c = db.rawQuery("SELECT * FROM " + utils.TABLA_USUARIO, null);
        while (c.moveToNext()) {
            usuario = new Usuario();
            usuario.setId(c.getInt(0));
            usuario.setNombre(c.getString(1));
            usuario.setTelefono(c.getString(2));
            UsuarioList.add(usuario);
        }
        obtenerListaUsuarios();
    }

    private void obtenerListaUsuarios() {
        listaUsuarios = new ArrayList<String>();
        listaUsuarios.add("Seleccione");
        for (int i = 0; i < UsuarioList.size(); i++) {
            listaUsuarios.add(UsuarioList.get(i).getId() + " - " + UsuarioList.get(i).getNombre() + " - " +
                    UsuarioList.get(i).getTelefono());

        }
    }
}