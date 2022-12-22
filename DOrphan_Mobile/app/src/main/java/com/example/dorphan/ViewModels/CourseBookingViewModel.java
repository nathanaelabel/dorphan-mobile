package com.example.dorphan.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.CourseBooking;
import com.example.dorphan.Repositories.CourseBookingRepository;

import java.util.List;

public class CourseBookingViewModel extends AndroidViewModel {

    private CourseBookingRepository courseBookingRepository;

    public CourseBookingViewModel(Application application) {
        super(application);
    }

    public void init(String token) {
        courseBookingRepository = CourseBookingRepository.getInstance(token);
    }

    private MutableLiveData<List<CourseBooking.Result>> resultCourseBookings = new MutableLiveData<>();

    public void getCourseBookings() {
        resultCourseBookings = courseBookingRepository.getCourseBookings();
    }

    public LiveData<List<CourseBooking.Result>> getResultCourseBookings() {
        return resultCourseBookings;
    }

    private MutableLiveData<List<CourseBooking.Result>> resultCourseBooking = new MutableLiveData<>();

    public void getCourseBooking(int course_booking_id) {
        resultCourseBooking = courseBookingRepository.getCourseBooking(course_booking_id);
    }

    public LiveData<List<CourseBooking.Result>> getResultCourseBooking() {
        return resultCourseBooking;
    }

    public LiveData<String> addCourseBooking(int course_id, int member_sum) {
        return courseBookingRepository.addCourseBooking(course_id, member_sum);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        courseBookingRepository.resetInstance();
    }
}
