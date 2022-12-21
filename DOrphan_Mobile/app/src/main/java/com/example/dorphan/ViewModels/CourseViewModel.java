package com.example.dorphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.Course;
import com.example.dorphan.Models.Skill;
import com.example.dorphan.Repositories.CourseRepository;
import com.example.dorphan.Repositories.SkillRepository;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {
    private CourseRepository courseRepository;

    public CourseViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        courseRepository = CourseRepository.getInstance(token);
    }

    //== Begin of view model to get all category
    private MutableLiveData<List<Course.Result>> resultCourses = new MutableLiveData<>();

    public void getCoursesFromSkill(int skill_id) {
        resultCourses = courseRepository.getCoursesFromSkill(skill_id);
    }

    public LiveData<List<Course.Result>> getResultCoursesFromSkill() {
        return resultCourses;
    }

    ///
    private MutableLiveData<List<Course.Result>> resultForCoursesDetail = new MutableLiveData<>();

    public void getCourses(int course_id) {
        resultForCoursesDetail = courseRepository.getCourses(course_id);
    }

    public LiveData<List<Course.Result>> getResultForCoursesDetail() {
        return resultForCoursesDetail;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        courseRepository.resetInstance();
    }
}
