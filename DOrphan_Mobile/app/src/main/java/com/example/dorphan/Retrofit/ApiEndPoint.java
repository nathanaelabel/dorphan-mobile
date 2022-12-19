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

    @POST("user_answer")
    @FormUrlEncoded
    Call<JsonObject> addUserAnswer(@Field("quiz_history_id") String quiz_history_id,
                                   @Field("question_id") String question_id,
                                   @Field("user_answer") String user_answer,
                                   @Field("user_id") String userId);

    @POST("get_user")
    @FormUrlEncoded
    Call<User> getUserWithId(@Field("user_id") String user_id);

    @GET("skill")
    Call<Skill> getSkills();

    @GET("course_from_skill/{id}")
    Call<Course> getCoursesFromSkill(@Path("id") int skill_id);
}