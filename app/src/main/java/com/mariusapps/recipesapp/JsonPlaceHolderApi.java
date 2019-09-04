package com.mariusapps.recipesapp;

import com.mariusapps.recipesapp.model.Ingrediente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JsonPlaceHolderApi {

  //  @GET("camareros")
   @GET("ingredientes")

     public Call<List<Ingrediente>> getIngredientes();





}
