package com.example.socialmediaapp.Data;

import com.example.socialmediaapp.Models.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("/users")
    Call<Users> recoUsers();
}
