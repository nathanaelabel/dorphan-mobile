package com.example.dorphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.User;
import com.example.dorphan.Repositories.CourseRepository;
import com.example.dorphan.Repositories.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        userRepository = UserRepository.getInstance(token);
    }

    //== Begin of view model to get all category
    private MutableLiveData<List<User.Result>> resultUser = new MutableLiveData<>();

    public void getUser() {
        resultUser = userRepository.getUser();
    }

    public LiveData<List<User.Result>> getResultUser() {
        return resultUser;
    }
}
