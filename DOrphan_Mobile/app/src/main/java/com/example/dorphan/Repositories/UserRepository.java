package com.example.dorphan.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.User;
import com.example.dorphan.Retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static UserRepository userRepository;
    private ApiService apiService;

    private UserRepository() {
        apiService = ApiService.getInstance("");
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public MutableLiveData<List<User.Result>> getUsers() {
        final MutableLiveData<List<User.Result>> LIST_USERS = new MutableLiveData<>();

        apiService.getUsers().enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        LIST_USERS.postValue(response.body().getResult());
                    }

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
            }

        });

        return LIST_USERS;
    }
}
