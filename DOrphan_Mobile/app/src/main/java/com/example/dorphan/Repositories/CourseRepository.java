package com.example.dorphan.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.Course;
import com.example.dorphan.Retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {
    private static CourseRepository courseRepository;
    private ApiService apiService;

    private CourseRepository(String token) {
        apiService = ApiService.getInstance(token);
    }

    public static CourseRepository getInstance(String token) {
        if (courseRepository == null) {
            courseRepository = new CourseRepository(token);
        }
        return courseRepository;
    }

    public static synchronized void resetInstance() {
        if (courseRepository != null) {
            courseRepository = null;
        } else {
            courseRepository = null;
        }
    }

    public MutableLiveData<List<Course.Result>> getCoursesFromSkill(int skill_id) {
        final MutableLiveData<List<Course.Result>> listCourses = new MutableLiveData<>();

        apiService.getCoursesFromSkill(skill_id).enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    listCourses.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
            }
        });

        return listCourses;
    }

    public MutableLiveData<List<Course.Result>> getCourses(int course_id) {
        final MutableLiveData<List<Course.Result>> listForCoursesDetail = new MutableLiveData<>();

        apiService.getCourses(course_id).enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if (response.isSuccessful()) {
                    listForCoursesDetail.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
            }
        });

        return listForCoursesDetail;
    }
}
