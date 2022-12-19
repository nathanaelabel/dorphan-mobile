package com.example.dorphan.Repositories;

import com.example.dorphan.Retrofit.ApiService;

public class AuthRepository {

    private static AuthRepository authRepository;
    private ApiService apiService;
    private static final String TAG = "AuthRepository";

    private AuthRepository() {
        apiService = ApiService.getInstance(""); //getinstance("") krna ktika login tdk mmbthkn token (barier, header di postman)
    }

    public static AuthRepository getInstance() {
        if (authRepository == null) {
            authRepository = new AuthRepository();
        }
        return authRepository;
    }
}
