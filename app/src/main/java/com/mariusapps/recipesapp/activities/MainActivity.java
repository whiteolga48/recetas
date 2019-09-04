package com.mariusapps.recipesapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mariusapps.recipesapp.JsonPlaceHolderApi;
import com.mariusapps.recipesapp.R;
import com.mariusapps.recipesapp.model.Ingrediente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8081/")

        //.baseUrl("http://localhost:8081/")
//                .baseUrl("https://pedi-gest.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolderApi =retrofit.create(JsonPlaceHolderApi.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIngredientes();
            }
        });



    }

        public void getIngredientes(){

        Call <List<Ingrediente>> call = jsonPlaceHolderApi.getIngredientes();
        call.enqueue(new Callback<List<Ingrediente>>() {
            @Override
            public void onResponse(Call<List<Ingrediente>> call, Response<List<Ingrediente>> response) {

                if (!response.isSuccessful()){


                    Log.d("**", "onResponse: "+ response.code());
                    return;
                }

                List<Ingrediente> ingredientes = response.body();

                for (Ingrediente ingrediente: ingredientes){

                    Log.d("**", "onResponse: "+response.body());

//                    String content = "";
//                    content += "Nombre: " + ingrediente.getNombre()+"\n";
//                    content += "Id : " + ingrediente.getId() + "\n";
//
//                    Log.d("***",content);


//


                }
            }

            @Override
            public void onFailure(Call<List<Ingrediente>> call, Throwable t) {

                    Log.d("***",t.getMessage());

            }
        });



        }


}





