package com.mariusapps.recipesapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariusapps.recipesapp.ApiInterface;
import com.mariusapps.recipesapp.R;
import com.mariusapps.recipesapp.model.Dificultad;
import com.mariusapps.recipesapp.model.Ingrediente;
import com.mariusapps.recipesapp.model.Receta;
import com.mariusapps.recipesapp.model.Temperatura;
import com.mariusapps.recipesapp.retrofit.RetrofitClientInstance;
import com.squareup.picasso.Picasso;

import java.net.URI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class detalle_receta extends AppCompatActivity {

    private TextView tituloDetalle;
    private ImageView imageView_Detalle;
    private Dificultad[] dificultades;
    private Temperatura[] temperaturas;
    private TextView dificultadDetalle;
    private TextView pasosDetalle;
    private TextView ingredientesDetalle;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);


        dificultades = Dificultad.values();
        temperaturas = Temperatura.values();
        Log.d("**", "dificultad: " + dificultades[0].toString());
        Log.d("**", "temperatura " + temperaturas[0].toString());
        Intent intent = getIntent();
       String name = intent.getStringExtra("titulo");

        long idReceta = Long.parseLong(intent.getStringExtra("id"));
        getReceta(idReceta);

        Log.d("***", "Id: " + idReceta);

        String urlfoto = intent.getStringExtra("urlfoto");
        String dificultad = intent.getStringExtra("dificultad");
        String pasos = intent.getStringExtra("pasos");

        Log.d("***", "urlfoto: " + urlfoto.toString());


        dificultadDetalle = findViewById(R.id.tv_dificultad_detalle);
        tituloDetalle = findViewById(R.id.tv_titulo_detalle);
        imageView_Detalle = findViewById(R.id.iv_detalle_imagen);
        pasosDetalle = findViewById(R.id.tv_pasos_detalle);


        String str2 = "https://olgarecetas.herokuapp.com/recetas/image/" + idReceta;

        Log.d("***", "urlid" + str2);

        Picasso.get()
                .load(str2)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView_Detalle);


       pasosDetalle.setMovementMethod(new ScrollingMovementMethod());
        pasosDetalle.setText(pasos);

//        ingredientesDetalle.setMovementMethod(new ScrollingMovementMethod());
//        ingredientesDetalle.setText(ingredientes);


        dificultadDetalle.setText(dificultad);
        tituloDetalle.setText(name);
        Log.d("****", "onCreate: " + tituloDetalle.toString());


    }

    private void getRecetaById(Long i) {


        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<Receta> call = apiInterface.getRecetaById(i);
        call.enqueue(new Callback<Receta>() {
            @Override
            public void onResponse(Call<Receta> call, Response<Receta> response) {
                if (!response.isSuccessful()) {
                    Log.d("**", "onResponse: " + response.code());
                    return;
                }

                Receta receta = response.body();
                Log.d("***","respose: " +receta.toString());
            }

            @Override
            public void onFailure(Call<Receta> call, Throwable t) {
                Log.d("****", t.getMessage());
            }
        });




    }

    private Receta getReceta ( long id){
        //TODO


        return null;
    }
}