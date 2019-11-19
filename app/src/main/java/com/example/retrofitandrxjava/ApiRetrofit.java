package com.example.retrofitandrxjava;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiRetrofit {

    @GET("users/{id}")
    Single<ApiResponseUser> getUserById(@Path("id") Integer id);
}
