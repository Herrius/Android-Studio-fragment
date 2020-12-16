package adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.datosusuariosupe.R;

import java.util.ArrayList;

import entidades.Usuario;

public class ListaUsersAdapter extends RecyclerView.Adapter<ListaUsersAdapter.UserViewHolder> {
    ArrayList<Usuario> listaUsuario;
    public ListaUsersAdapter(ArrayList<Usuario> listaUsuario){
        this.listaUsuario=listaUsuario;
    }
    @Override
    public ListaUsersAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_usuario2,null,false);
        return new UserViewHolder(vista);
    }
    @NonNull


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //asignar datos
        holder.documento.setText(listaUsuario.get(position).getId().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre().toString());
        holder.telefono.setText(listaUsuario.get(position).getTelefono().toString());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView documento,nombre,telefono;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            documento= itemView.findViewById(R.id.twRDocumento);
            nombre= itemView.findViewById(R.id.twRNombre);
            telefono= itemView.findViewById(R.id.twTelefono);

        }
    }
}
