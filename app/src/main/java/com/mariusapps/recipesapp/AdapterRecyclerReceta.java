package com.mariusapps.recipesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariusapps.recipesapp.model.Receta;

import java.util.List;

public class AdapterRecyclerReceta extends RecyclerView.Adapter<AdapterRecyclerReceta.MyviewHolder> {

    private Context context;
    private List<Receta>listaRecetas;

    public AdapterRecyclerReceta(Context context, List<Receta> listaRecetas) {
        this.context = context;
        this.listaRecetas = listaRecetas;
    }

    public void setTitleRecetas(List<Receta>listaRecetas){

        this.listaRecetas = listaRecetas;
        notifyDataSetChanged();


    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_item,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

     holder.tituloReceta.setText((CharSequence) listaRecetas.get(position).getNombre());


        }



    @Override
    public int getItemCount() {
        if (listaRecetas !=null){

            return listaRecetas.size();
        }
        return 0;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        public final View myView;

            ImageView image;
            TextView tituloReceta;




        public MyviewHolder(@NonNull View itemView) {
            super(itemView);

            myView=itemView;

            image= (ImageView)itemView.findViewById(R.id.iv_imagen_receta);
            tituloReceta = (TextView)itemView.findViewById(R.id.tv_titulo_receta);

        }
    }
}