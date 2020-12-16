package com.example.datosusuariosupe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

import adaptadores.ListaUsersAdapter;
import entidades.Usuario;
import entidades.conexionSqlHelper;
import utils.utils;

public class ListarRecycle extends AppCompatActivity {
    ArrayList<Usuario> listUsuario;
    RecyclerView recyclerViewUsuarios;
    conexionSqlHelper cnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_recycle);

        cnn=new conexionSqlHelper(getApplicationContext(),"bd_usuarios",null,1);
        listUsuario=new ArrayList<>();

        recyclerViewUsuarios=findViewById(R.id.recyclerUsuarios);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        consultarListaUsuarios();
        // generando la referencia a la lista de usuarios adapter
        ListaUsersAdapter adapter=new ListaUsersAdapter(listUsuario);
        recyclerViewUsuarios.setAdapter(adapter);
    }
    private void consultarListaUsuarios(){
        //igual que un listview
        SQLiteDatabase db=cnn.getReadableDatabase();
        Usuario usuario=null; // para llenar la inf
        Cursor cursor=db.rawQuery("Select * from "+ utils.TABLA_USUARIO,null);
        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));
            listUsuario.add(usuario);

        }
    }
}