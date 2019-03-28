package com.example.retrofitandrxjava;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryRetrofit {

    private static final String BASE_URL = "https://reqres.in/api/";

    private static RepositoryRetrofit repositoryRetrofitInstance;

    HttpLoggingInterceptor interceptor;
    OkHttpClient client;

    Retrofit retrofitInstance;
    ApiRetrofit apiRetrofit;

    public static RepositoryRetrofit getInstance() {

        if (repositoryRetrofitInstance == null) {
            repositoryRetrofitInstance = new RepositoryRetrofit();
        }
        return repositoryRetrofitInstance;
    }

    private RepositoryRetrofit() {

        interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        client  = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofitInstance = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        apiRetrofit = retrofitInstance.create(ApiRetrofit.class);
    }

    public Single<ApiResponseUser> getUser(int userId) {

        return apiRetrofit.getUserById(userId);
    }
}
