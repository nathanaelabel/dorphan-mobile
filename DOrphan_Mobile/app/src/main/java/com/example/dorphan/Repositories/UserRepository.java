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

    private UserRepository(String token) {
        apiService = ApiService.getInstance(token);
    }

    public static UserRepository getInstance(String token) {
        if (userRepository == null) {
            userRepository = new UserRepository(token);
        }
        return userRepository;
    }

    public static synchronized void resetInstance() {
        if (userRepository != null) {
            userRepository = null;
        } else {
            userRepository = null;
        }
    }

    public MutableLiveData<List<User.Result>> getUser() {
        final MutableLiveData<List<User.Result>> LIST_USER = new MutableLiveData<>();

        apiService.getUser().enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {

                    if (response.body() != null) {
                        LIST_USER.postValue(response.body().getResult());
                    }

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
            }

        });

        return LIST_USER;
    }
}
