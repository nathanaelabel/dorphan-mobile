package com.example.dorphan.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.Register;
import com.example.dorphan.Models.TokenResponse;
import com.example.dorphan.Retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static AuthRepository authRepository;
    private ApiService apiService;
    private static final String TAG = "AuthRepository";

    private AuthRepository() {
        apiService = ApiService.getInstance("");
    }

    public static AuthRepository getInstance() {
        if (authRepository == null) {
            authRepository = new AuthRepository();
        }
        return authRepository;
    }

    public MutableLiveData<TokenResponse> login(String email, String password) {
        MutableLiveData<TokenResponse> tokenResponseMutableLiveData = new MutableLiveData<>();

        apiService.login(email, password).enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                System.out.println("respon:" + response.body());
                if (response.body() != null) {
                    tokenResponseMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {

            }
        });
        return tokenResponseMutableLiveData;
    }

    public MutableLiveData<Register> register(String name, String email, String password, String password_confirmation, String user_type) {
        MutableLiveData<Register> RegisterResponseMutableLiveData = new MutableLiveData<>();

        apiService.register(name, email, password, password_confirmation, user_type).enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            RegisterResponseMutableLiveData.postValue(response.body());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {

            }
        });
        return RegisterResponseMutableLiveData;
    }
}
