package com.example.socialmediaapp.Data;

import com.example.socialmediaapp.Models.Posts;
import com.example.socialmediaapp.Models.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    @GET("/posts")
    Call<List<Posts>> recoPosts();

}
