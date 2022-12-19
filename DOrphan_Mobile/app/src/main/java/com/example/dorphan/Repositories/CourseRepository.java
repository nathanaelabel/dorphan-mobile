package com.example.dorphan.Repositories;
import com.example.dorphan.Retrofit.ApiService;

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
}
