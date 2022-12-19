package com.example.dorphan.Repositories;

import com.example.dorphan.Retrofit.ApiService;

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
}
