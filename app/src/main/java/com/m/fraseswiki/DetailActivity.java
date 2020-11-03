package com.m.fraseswiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.m.fraseswiki.model.Api;
import com.m.fraseswiki.model.items.ItemResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    private Api api;
    private RecyclerView recyclerView;
    private DataRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setContentView(R.layout.activity_temas);
        setContentView(R.layout.activity_autores);
        setupRecyclerView();
        setupRetrofitApi();

        int menuId = getIntent().getIntExtra("menuid",-1);
        fetchDataFromMenu(menuId);

    }


    private void fetchDataFromMenu(int id) {
        api.fetchResults(id).enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                if (response.isSuccessful()) {
                    adapter.putList(response.body().getRows());
                } else {
                    Log.v("retrofiterror", "" + "data response not successful " + response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                Log.v("retrofiterror", "" + t.getMessage());
            }
        });


    }



    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.rv);
        adapter= new DataRecyclerAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void setupRetrofitApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fraseswiki.com/tema/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);

    }
}