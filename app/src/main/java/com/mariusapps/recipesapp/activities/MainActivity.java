package com.mariusapps.recipesapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mariusapps.recipesapp.ApiInterface;
import com.mariusapps.recipesapp.R;
import com.mariusapps.recipesapp.model.Ingrediente;
import com.mariusapps.recipesapp.model.Receta;
import com.mariusapps.recipesapp.retrofit.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private static final String TAG = "***";
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getIngredientes();
               //getRecetas();
               //getIngredienteById((long) 10);
               getRecetaById(13L);
            }
        });
    }

    private void getRecetaById(Long i){

        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call <Receta> call = apiInterface.getRecetaById(i);
        call.enqueue(new Callback<Receta>() {
            @Override
            public void onResponse(Call<Receta> call, Response<Receta> response) {
                if (!response.isSuccessful()){
                    Log.d("**", "onResponse: "+ response.code());
                    return;
                }

                Receta receta = response.body();
                Log.d(TAG,receta.toString());
            }

            @Override
            public void onFailure(Call<Receta> call, Throwable t) {
                Log.d(TAG,t.getMessage());
            }
        });
    }
    private void getIngredienteById(Long i){



        apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);
        Call <Ingrediente> call = apiInterface.getIngredientebyId(i);
        call.enqueue(new Callback<Ingrediente>() {
            @Override
            public void onResponse(Call<Ingrediente> call, Response<Ingrediente> response) {

                if (!response.isSuccessful()){


                 Log.d("**", "onResponse: "+ response.code());
                    return;
                }

                Ingrediente ingredientes = response.body();

                Log.d(TAG,ingredientes.toString());

            }

            @Override
            public void onFailure(Call<Ingrediente> call, Throwable t) {

                Log.d(TAG,t.getMessage());


            }
        });

    }
    private void getIngredientes(){
    apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call <List<Ingrediente>> call = apiInterface.getIngredientes();
        call.enqueue(new Callback<List<Ingrediente>>() {
            @Override
            public void onResponse(Call<List<Ingrediente>> call, Response<List<Ingrediente>> response) {

                if (!response.isSuccessful()){

                    Toast.makeText(MainActivity.this, "Ha fallado la respuesta", Toast.LENGTH_SHORT).show();
//                  Log.d("**", "onResponse: "+ response.code());
                    return;
                }

                List<Ingrediente> ingredientes = response.body();

               Log.d(TAG,ingredientes.toString());




//                for (Ingrediente ingrediente: ingredientes){
//
//                     Log.d(TAG, "onResponse: "  + "\n" + response.body()  );
//                    Toast.makeText(MainActivity.this, "Habemus respuesta", Toast.LENGTH_SHORT).show();
//
//                    String content = "";
//                    content += "Nombre: " + ingrediente.getNombre()+"\n";
//                    content += "Id : " + ingrediente.getId() + "\n";
//                    content +="Medida : " + ingrediente.getMedida() + "\n";
//
////                    Log.d(TAG,content);
//                }




            }

            @Override
            public void onFailure(Call<List<Ingrediente>> call, Throwable t) {

                    Log.d(TAG,t.getMessage());

            }
        });



        }
    private void getRecetas(){

         apiInterface = RetrofitClientInstance.getRetrofitInstance().create(ApiInterface.class);

        Call <List<Receta>> call = apiInterface.getRecetas();
        call.enqueue(new Callback<List<Receta>>() {
            @Override
            public void onResponse(Call<List<Receta>> call, Response<List<Receta>> response) {

                if (!response.isSuccessful()){


                    Log.d(TAG, "onResponse: "+ response.code());
                    return;
                }

                List<Receta> recetas = response.body();

                Log.d(TAG,recetas.toString());

//                for (Receta receta: recetas){
//
//                    Log.d(TAG, "onResponse: "+response.body());
//
//                    String content = "" + "\n";
//                    content += "Nombre: " + receta.getNombre()+"\n";
//                    content += "Id : " + receta.getId() + "\n";
//                    content += "Tiempo: " + receta.getTiempoDeCoccion() + "\n";
//
//                    Log.d(TAG,content);
//
//                }
            }

            @Override
            public void onFailure(Call<List<Receta>> call, Throwable t) {

                Log.d("**",t.getMessage());

            }
        });

    }






}