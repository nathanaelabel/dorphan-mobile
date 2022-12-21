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

        //mau ngasih tau isi headernya apa
        //jika tidak butuh bearer (header authorization di postman). Tidak butuh token untuk akses data
        if (token.equals("")) {
            //mulai bikin header
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(request);
            });
        } else { //jika butuh bearer (header authorization di postman). Butuh token untuk akses data
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder().addHeader("Accept", "application/json")
                        .addHeader("Authorization", token) //token akan otomatis dibuatkan
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

    //agar token yang didapatkan setelah atau sebelum login, dapat diakses di semua kelas
    public static ApiService getInstance(String token) {
        if (service == null) {
            service = new ApiService(token);
        } else if (!token.equals("")) {
            service = new ApiService(token);
        }
        return service;
    }

    //mengakses apiendpoint dengan memasukkan nilai untuk header yang telah diset pada code di atas
    public Call<TokenResponse> login(String email, String password) {
        return api.login(email, password);
    }

    public Call<Register> register(String name, String email, String password, String password_confirmation, String user_type) {
        return api.register(name, email, password, password_confirmation, user_type);
    }

    //public Call<JsonObject> logout(){
//        return api.logout();
//    }
    public Call<User> getUsers() {
        return api.getUsers();
    }

//    public Call<GetQuestionWithLevelid> getQuestionWithLevelId(String levelId) {
//        return api.getQuestionWithLevelId(levelId);
//    }

    // public Call<JsonObject> addUserAnswer(String quiz_history_id, String question_id, String user_answer) {return api.addUserAnswer(quiz_history_id, question_id, user_answer, helper.getUserId());}
    // public Call<GetQuestionWithHistoryId> getQuestionWithHistoryId(String quizHistoryId) {return api.getQuestionWithHistoryId(quizHistoryId);}
    public Call<User> getUserWithId(String userId) {
        return api.getUserWithId(userId);
    }

    public Call<JsonObject> updateRewardQuiz(String quiz_history_id, int score_level, int money_level, int ticket_level, String student_id, String active) {
        return api.updateRewardQuiz(quiz_history_id, score_level, money_level, ticket_level, student_id, active);
    }

//    public Call<CourseBooking> getCourseBooking(String user_id) {
//        return api.getCourseBooking(user_id);
//    }

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
