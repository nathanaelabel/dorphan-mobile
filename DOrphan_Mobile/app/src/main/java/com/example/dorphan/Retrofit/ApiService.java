package com.example.dorphan.Retrofit;

import com.example.dorphan.Helpers.Const;
import com.example.dorphan.Models.Course;
import com.example.dorphan.Models.Register;
import com.example.dorphan.Models.Skill;
import com.example.dorphan.Models.TokenResponse;
import com.example.dorphan.Models.User;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private final ApiEndPoint api;
    private static ApiService service;
    private static final String TAG = "ApiService";

    public ApiService(String token) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (token.equals("")) {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(request);
            });
        } else {
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json")
                        .addHeader("Authorization", token)
                        .build();
                return chain.proceed(request);
            });
        }

        api = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(ApiEndPoint.class);
    }

    public static ApiService getInstance(String token) {
        if (service == null) {
            service = new ApiService(token);
        } else if (!token.equals("")) {
            service = new ApiService(token);
        }
        return service;
    }

    public Call<TokenResponse> login(String email, String password) {
        return api.login(email, password);
    }

    public Call<Register> register(String name, String email, String password, String password_confirmation, String user_type) {
        return api.register(name, email, password, password_confirmation, user_type);
    }

    public Call<User> getUsers() {
        return api.getUsers();
    }

    public Call<User> getUserWithId(String userId) {
        return api.getUserWithId(userId);
    }

    public Call<Skill> getSkills() {
        return api.getSkills();
    }

    public Call<Course> getCoursesFromSkill(int skill_id) {
        return api.getCoursesFromSkill(skill_id);
    }

    public Call<Course> getCourses(int course_id) {
        return api.getCourses(course_id);
    }

    public Call<JsonObject> addCourseBooking(int course_id, int member_sum) {
        return api.addCourseBooking(course_id, member_sum);
    }

}
