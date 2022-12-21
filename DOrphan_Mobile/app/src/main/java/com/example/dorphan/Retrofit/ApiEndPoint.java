package com.example.dorphan.Retrofit;

import com.example.dorphan.Models.Course;
import com.example.dorphan.Models.Register;
import com.example.dorphan.Models.Skill;
import com.example.dorphan.Models.TokenResponse;
import com.example.dorphan.Models.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @POST("login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @POST("register")
    @FormUrlEncoded
    Call<Register> register(@Field("name") String name,
                            @Field("email") String email,
                            @Field("password") String password,
                            @Field("password_confirmation") String password_confirmation,
                            @Field("user_type") String user_type
    );

    @POST("logout")
    @FormUrlEncoded
    Call<JsonObject> logout(@Field("student_id") String student_id);

    @GET("user")
    Call<User> getUsers();

    @POST("get_user")
    @FormUrlEncoded
    Call<User> getUserWithId(@Field("user_id") String user_id);

    @GET("skill")
    Call<Skill> getSkills();

    @GET("course_from_skill/{id}")
    Call<Course> getCoursesFromSkill(@Path("id") int skill_id);

    @GET("course/{id}")
    Call<Course> getCourses(@Path("id") int course_id);

    @POST("course-booking")
    @FormUrlEncoded
    Call<JsonObject> addCourseBooking(@Field("course_id") int course_id, @Field("member_sum") int member_sum);
}
