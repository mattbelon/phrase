package com.m.fraseswiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.m.fraseswiki.model.Api;
import com.m.fraseswiki.model.menu.MenuResponse;
import com.m.fraseswiki.model.menu.MenuRowsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TemasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Api api;
    private List<MenuRowsItem> menuList = null; //esta es nva
    private MenuRecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setContentView(R.layout.activity_temas);

        setupRecyclerView();
        setupRetrofitApi();
        fetchMenuItems(); //nva
    }

    private void fetchMenuItems() {
        String palabra = getIntent().getStringExtra("palabra");

        api.fetchMenu(palabra).enqueue(new Callback<MenuResponse>() {
            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                if (response.isSuccessful()) {
                    menuList = response.body().getRows();
                    adapter.putList(menuList);
                } else {
                    Log.v("retrofiterror", "" + "menu item response not successful " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                Log.v("retrofiterror", "" + t.getMessage());
            }
        });

    }


    @Override

    public boolean onPrepareOptionsMenu(Menu menu) {
//        if (menuList != null) {
//            for (MenuRowsItem item : menuList) {
//                menu.add(0, item.getId(), 0, item.getTema());
//            }
//        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
//        fetchDataFromMenu(id);

        return super.onOptionsItemSelected(item);
    }


    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.rv);
        adapter= new MenuRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupRetrofitApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fraseswiki.com/temas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

    }
}