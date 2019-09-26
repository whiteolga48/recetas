package com.mariusapps.recipesapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mariusapps.recipesapp.R;
import com.mariusapps.recipesapp.model.Receta;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {


    private List<Receta> datalist;
    private Context context;

    public CustomAdapter(Context context, List<Receta> datalist ) {
        this.datalist = datalist;
        this.context = context;
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

        String URLFoto = "http://10.0.2.2:8081/recetas/image/" + datalist.get(position).getId();

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
