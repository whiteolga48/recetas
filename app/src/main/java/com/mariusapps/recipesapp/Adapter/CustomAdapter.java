package com.mariusapps.recipesapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariusapps.recipesapp.R;
import com.mariusapps.recipesapp.model.Receta;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> implements Filterable {



    private List<Receta> datalist;
    private List<Receta> recetaListFull;
    private Context context;

    public CustomAdapter(Context context, List<Receta> datalist ) {
        this.datalist = datalist;
        this.context = context;
        recetaListFull = new ArrayList<>(datalist);

    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_item,parent,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.txt_Tittle.setText(datalist.get(position).getNombre());

        String URLFoto = "https://olgarecetas.herokuapp.com/recetas/image/" + datalist.get(position).getId();

        Log.d("*****", URLFoto);

        Picasso.get()
                .load(URLFoto)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageRecipe);
   }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    @Override
    public Filter getFilter() {
        return recetasFiltro;
    }

    private Filter recetasFiltro = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<Receta> listaFiltrada = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {

                listaFiltrada.addAll(recetaListFull);

            } else {

                String filteredPattern = constraint.toString().toLowerCase().trim();
                for (Receta receta : recetaListFull) {
                    if (receta.getNombre().toLowerCase().contains(filteredPattern)) {
                        listaFiltrada.add(receta);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = listaFiltrada;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {


            datalist.clear();
            datalist.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };



    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private TextView txt_Tittle;
        private ImageView imageRecipe;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
            txt_Tittle = mView.findViewById(R.id.tv_titulo_receta);
            imageRecipe = mView.findViewById(R.id.iv_imagen_receta);

        }
    }
}
