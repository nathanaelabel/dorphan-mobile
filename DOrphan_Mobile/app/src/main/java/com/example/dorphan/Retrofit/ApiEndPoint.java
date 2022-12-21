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

//    @GET("question/{levelId}")
//    Call<GetQuestionWithLevelid> getQuestionWithLevelId(@Path("levelId") String levelId);

//    @GET("level")
//    Call<Level> getAllLevel();

//    @GET("level/{levelId}")
//    Call<Level> getLevelWithID(@Path("levelId") String level_id);
//
//    @POST("quiz_history")
//    @FormUrlEncoded
//    Call<QuizHistory> addQuizHistory(@Field("student_id") String student_id,
//                                     @Field("fis8_level_id") String fis8_level_id,
//                                     @Field("user_id") String userId);

//    @GET("quiz_history_all")
//    Call<QuizHistory> showQuizHistory();
//
//    @GET("user_history/{student_id}")
//
//    Call<userHistory> getQuizHistory(@Path("student_id") String student_id);

    @POST("user_answer")
    @FormUrlEncoded
    Call<JsonObject> addUserAnswer(@Field("quiz_history_id") String quiz_history_id,
                                   @Field("question_id") String question_id,
                                   @Field("user_answer") String user_answer,
                                   @Field("user_id") String userId);

//    @GET("rank")
//
//    Call<Rank> getRank();

    //@GET("quiz_history/{quizHistoryId}")
    // Call<GetQuestionWithHistoryId> getQuestionWithHistoryId(@Path("quizHistoryId") String quizHistoryId);

    @POST("get_user")
    @FormUrlEncoded
    Call<User> getUserWithId(@Field("user_id") String user_id);

//    @POST("all_data_course_booking")
//    @FormUrlEncoded
//    Call<CourseBooking> getCourseBooking(@Field("user_id") String user_id);

    @POST("add_reward")
    @FormUrlEncoded
    Call<JsonObject> updateRewardQuiz(@Field("history_id") String quiz_history_id,
                                      @Field("score_level") int score_level,
                                      @Field("money_level") int money_level,
                                      @Field("ticket_level") int ticket_level,
                                      @Field("student_id") String student_id,
                                      @Field("active") String active);

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
