package com.example.dorphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.dorphan.Repositories.CourseRepository;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {
    private CourseRepository courseRepository;

    public CourseViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        courseRepository = CourseRepository.getInstance(token);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        courseRepository.resetInstance();
    }
}
