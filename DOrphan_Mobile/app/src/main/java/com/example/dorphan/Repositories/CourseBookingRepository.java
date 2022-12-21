package com.example.dorphan.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseBookingRepository {
    private static CourseBookingRepository courseBookingRepository;
    private ApiService apiService;

    private CourseBookingRepository(String token) {
        apiService = ApiService.getInstance(token);
    }

    public static CourseBookingRepository getInstance(String token) {
        if (courseBookingRepository == null) {
            courseBookingRepository = new CourseBookingRepository(token);
        }
        return courseBookingRepository;
    }

    public static synchronized void resetInstance() {
        if (courseBookingRepository != null) {
            courseBookingRepository = null;
        } else {
            courseBookingRepository = null;
        }
    }

    public LiveData<String> addCourseBooking(int course_id, int member_sum) {
        final MutableLiveData<String> status = new MutableLiveData<>();
        apiService.addCourseBooking(course_id, member_sum) .enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String getStatus = object.getString("status");
                            status.postValue(getStatus);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
            }
        });
        return status;
    }
}
