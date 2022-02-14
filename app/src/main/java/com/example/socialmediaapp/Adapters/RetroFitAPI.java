package com.example.socialmediaapp.Adapters;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.socialmediaapp.Data.PostService;
import com.example.socialmediaapp.Data.UserService;
import com.example.socialmediaapp.Models.Posts;
import com.example.socialmediaapp.Models.Users;
import com.example.socialmediaapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitAPI extends AppCompatActivity {

     Retrofit retrofit;

     List<Posts> postList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

     void recoverRetrofitUsers(){

        UserService userService = retrofit.create(UserService.class);


        Call<Users> call1 = userService.recoUsers();



        call1.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                if(response.isSuccessful()){

                    Users users = response.body();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });
    }

    void recoverRetrofitPosts(){

        PostService postService = retrofit.create(PostService.class);
        Call<List<Posts>> call2 = postService.recoPosts();

        call2.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful()){
                    postList = response.body();
                    for(int i = 0; i< postList.size(); i++){
                        Posts post = postList.get(i);
                        //preencher visual com dados dos posts
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
        };
}

