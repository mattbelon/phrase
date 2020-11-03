package com.m.fraseswiki.model;

import com.m.fraseswiki.model.items.ItemResponse;
import com.m.fraseswiki.model.menu.MenuResponse;

import java.lang.reflect.Array;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {


    @GET("{palabra}")
    public Call<MenuResponse> fetchMenu(@Path("palabra") String palabra);

    @GET("{menu_id}")
    public Call<ItemResponse> fetchResults(@Path("menu_id") int menu_id);



    @GET("{obra}")
    public Call<MenuResponse> fetchAutores(@Path("obra") String obra);

    @GET("{obra_id}")
    public Call<ItemResponse> fetchAutor(@Path("obra_id") int obra_id);

    @GET("{frase}")
    public Call<ItemResponse> fetchAutor(@Path("Obra") String frase);



}
