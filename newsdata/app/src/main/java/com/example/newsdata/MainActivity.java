package com.example.newsdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "55b6e6e5855341ca8ec441aeecca466e";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsinterface apiService = mycaller.getInstance().getRetrofit().create(newsinterface.class);
        Call<newsdata> call = newsinterface.gettopheadline("us");

        call.enqueue(new Callback<newsdata>() {
            @Override
            public void onResponse(Call<newsdata> call, Response<newsdata> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Step 4: Handle the successful response
                    List<article> articles = response.body().getarticle();
                    Log.d("News", "Articles fetched: " + articles.size());
                    // You can now display these articles in a RecyclerView or any other UI component
                    // Example: Update RecyclerView Adapter with fetched articles
                    // myAdapter.updateData(articles);
                } else {
                    // Step 5: Handle response failure (e.g., invalid API call)
                    Log.e("API_ERROR", "Response failed");
                    Toast.makeText(MainActivity.this, "Failed to fetch articles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<newsdata> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        }
    }




}