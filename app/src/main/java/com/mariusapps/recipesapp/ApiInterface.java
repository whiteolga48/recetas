package com.mariusapps.recipesapp;

import com.mariusapps.recipesapp.model.Ingrediente;
import com.mariusapps.recipesapp.model.Receta;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiInterface {


//    String BASE_URL = "http://10.0.2.2:8081/";


   @GET("ingredientes")

     public Call<List<Ingrediente>> getIngredientes();


   @GET("recetas")
   public Call<List<Receta>> getRecetas();

    @GET("/ingredientes/{id}")

    Call<List<Ingrediente>> getIngredientebyId(@Path("id") int id);







}
