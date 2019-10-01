package com.mariusapps.recipesapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariusapps.recipesapp.R;
import com.squareup.picasso.Picasso;

import java.net.URI;

public class detalle_receta extends AppCompatActivity {

  private   TextView tituloDetalle ;
  private ImageView imageView_Detalle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_receta);


        Intent intent = getIntent();
        String name = intent.getStringExtra("titulo");
        String urlfoto = intent.getStringExtra("urlfoto");
        Log.d("***", "urlfoto: " + urlfoto.toString());


        tituloDetalle=findViewById(R.id.tv_titulo_detalle);
        imageView_Detalle = findViewById(R.id.iv_detalle_imagen);
      String  str2 = "https://olgarecetas.herokuapp.com/recetas/image/" + urlfoto;

        Picasso.get()
                .load(str2)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView_Detalle);


        tituloDetalle.setText(name);
        Log.d("****", "onCreate: "+tituloDetalle.toString());


    }
}
