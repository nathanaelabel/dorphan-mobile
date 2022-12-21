package com.example.dorphan.Views.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dorphan.Adapters.rvAdapterFindTutorFragment;
import com.example.dorphan.Helpers.SharedPreferenceHelper;
import com.example.dorphan.Models.Course;
import com.example.dorphan.R;
import com.example.dorphan.ViewModels.CourseBookingViewModel;
import com.example.dorphan.ViewModels.CourseViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseBookingDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseBookingDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseBookingDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseBookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseBookingDetailFragment newInstance(String param1, String param2) {
        CourseBookingDetailFragment fragment = new CourseBookingDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_booking_detail, container, false);
    }

    private CourseViewModel courseViewModelCourseBookingDetailFragment;
    private CourseBookingViewModel courseBookingViewModelCourseBookingDetailFragment;
    private SharedPreferenceHelper helperCourseBookingDetailFragment;
    private int courseId, courseBookingId;
    private Boolean isReservation;
    private TextView textViewTutorNameCourseBookingDetailFragment, textViewTutorGenderCourseBookingDetailFragment,
            textViewIsOnlineCourseBookingDetailFragment, textViewCourseNameCourseBookingDetailFragment,
            textViewCourseDescriptionCourseBookingDetailFragment, textViewCourseLocationCourseBookingDetailFragment,
            textViewCourseToolDescriptionCourseBookingDetailFragment, textViewCourseTimeCourseBookingDetailFragment,
            textViewCourseDayCourseBookingDetailFragment, textViewCourseHourSumCourseBookingDetailFragment,
            textViewCourseToolPriceCourseBookingDetailFragment, textViewCoursePriceSumCourseBookingDetailFragment,
            textViewMemberSumMaximalDescriptionCourseBookingDetailFragment, textViewMemberSumCourseBookingDetailFragment;
    private TextInputLayout textInputLayoutMemberSumCourseBookingDetailFragment;
    private Button buttonReservationCourseBookingDetailFragment;
    private int memberSumTextInputLayout, memberSum;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();

        if (isReservation) {
            courseViewModelCourseBookingDetailFragment.init(helperCourseBookingDetailFragment.getAccessToken()); //unsend
            courseViewModelCourseBookingDetailFragment.getCourses(courseId);
            courseViewModelCourseBookingDetailFragment.getResultForCoursesDetail().observe(getActivity(), showResultForCoursesDetail);
        } else {
//            courseBookingViewModelCourseBookingDetailFragment.init(helperCourseBookingDetailFragment.getAccessToken()); //unsend
//            courseBookingViewModelCourseBookingDetailFragment.getCourseBooking(courseBookingId);
//            courseBookingViewModelCourseBookingDetailFragment.getResultCourseBooking().observe(getActivity(), showResultCourseBooking);
        }
        //checkButtonReservation();
        reservationProccess();

    }

    private Observer<List<Course.Result>> showResultForCoursesDetail = new Observer<List<Course.Result>>() {
        @Override
        public void onChanged(List<Course.Result> results) {
            if (results != null) {

                memberSum = results.get(0).getMaximum_member();

                textViewTutorNameCourseBookingDetailFragment.setText(results.get(0).getTutor_user().getName());
                textViewTutorGenderCourseBookingDetailFragment.setText(results.get(0).getTutor_user().getGender());

                if (results.get(0).getIs_online() == 1) {
                    textViewIsOnlineCourseBookingDetailFragment.setText("Daring");
                    textViewIsOnlineCourseBookingDetailFragment.setTextColor(getResources().getColor(R.color.green500));
                } else {
                    textViewIsOnlineCourseBookingDetailFragment.setText("Luring");
                    textViewIsOnlineCourseBookingDetailFragment.setTextColor(getResources().getColor(R.color.red500));
                }

                textViewCourseNameCourseBookingDetailFragment.setText(results.get(0).getSkill().getName());

                textViewCourseDescriptionCourseBookingDetailFragment.setText(results.get(0).getDescription());
                if (results.get(0).getIs_online() == 1) {
                    textViewCourseLocationCourseBookingDetailFragment.setText(results.get(0).getLocation());
                } else {
                    if (results.get(0).getIs_visit() == 1) {
                        textViewCourseLocationCourseBookingDetailFragment.setText("Kursus diadakan di lokasi Panti Asuhan");
                    } else {
                        textViewCourseLocationCourseBookingDetailFragment.setText(results.get(0).getLocation());
                    }
                }

                textViewCourseToolDescriptionCourseBookingDetailFragment.setText(results.get(0).getTool_description());
                textViewCourseTimeCourseBookingDetailFragment.setText(results.get(0).getStart_time());
                textViewCourseDayCourseBookingDetailFragment.setText(results.get(0).getDay());
                textViewCourseHourSumCourseBookingDetailFragment.setText(String.valueOf(results.get(0).getHour_sum()));
                textViewCourseToolPriceCourseBookingDetailFragment.setText(String.valueOf(results.get(0).getTool_price()));
                textViewCoursePriceSumCourseBookingDetailFragment.setText(String.valueOf(results.get(0).getPrice_sum()));
                textViewMemberSumMaximalDescriptionCourseBookingDetailFragment.setText("Maksimum " + String.valueOf(results.get(0).getMaximum_member()) + " Peserta Kursus");
            }
        }
    };

//    private Observer<List<CourseBooking.Result>> showResultCourseBooking = new Observer<List<CourseBooking.Result>>() {
//        @Override
//        public void onChanged(List<CourseBooking.Result> results) {
//            if (results != null) {
//               // textViewMemberSumCourseBookingDetailFragment.setText(results.get(0).get);
//            }
//        }
//    };

    private void initial() {
        textViewTutorNameCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewTutorNameCourseBookingDetailFragment);
        textViewTutorGenderCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewTutorGenderCourseBookingDetailFragment);
        textViewIsOnlineCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewIsOnlineCourseBookingDetailFragment);
        textViewCourseNameCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseNameCourseBookingDetailFragment);
        textViewCourseDescriptionCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseDescriptionCourseBookingDetailFragment);
        textViewCourseLocationCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseLocationCourseBookingDetailFragment);
        textViewCourseToolDescriptionCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseToolDescriptionCourseBookingDetailFragment);
        textViewCourseTimeCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseTimeCourseBookingDetailFragment);
        textViewCourseDayCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseDayCourseBookingDetailFragment);
        textViewCourseHourSumCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseHourSumCourseBookingDetailFragment);
        textViewCourseToolPriceCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCourseToolPriceCourseBookingDetailFragment);
        textViewCoursePriceSumCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewCoursePriceSumCourseBookingDetailFragment);
        textViewMemberSumMaximalDescriptionCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewMemberSumMaximalDescriptionCourseBookingDetailFragment);
        textViewMemberSumCourseBookingDetailFragment = getActivity().findViewById(R.id.textViewMemberSumCourseBookingDetailFragment);

        textInputLayoutMemberSumCourseBookingDetailFragment = getActivity().findViewById(R.id.textInputLayoutMemberSumCourseBookingDetailFragment);

        buttonReservationCourseBookingDetailFragment = getActivity().findViewById(R.id.buttonReservationCourseBookingDetailFragment);

        isReservation = getArguments().getBoolean("isReservation");
        helperCourseBookingDetailFragment = SharedPreferenceHelper.getInstance(requireActivity());
        courseBookingViewModelCourseBookingDetailFragment = new ViewModelProvider(getActivity()).get(CourseBookingViewModel.class);

        if (isReservation) {
            courseId = Integer.parseInt(getArguments().getString("courseId"));
            courseViewModelCourseBookingDetailFragment = new ViewModelProvider(getActivity()).get(CourseViewModel.class);
            textViewMemberSumCourseBookingDetailFragment.setVisibility(View.GONE);
            textInputLayoutMemberSumCourseBookingDetailFragment.setVisibility(View.VISIBLE);
            buttonReservationCourseBookingDetailFragment.setVisibility(View.VISIBLE);
        } else {
            courseBookingId = Integer.parseInt(getArguments().getString("courseBookingId"));
            textViewMemberSumCourseBookingDetailFragment.setVisibility(View.VISIBLE);
            textInputLayoutMemberSumCourseBookingDetailFragment.setVisibility(View.GONE);
            buttonReservationCourseBookingDetailFragment.setVisibility(View.GONE);
        }
    }

    private void reservationProccess() {
        buttonReservationCourseBookingDetailFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    memberSumTextInputLayout = Integer.parseInt(textInputLayoutMemberSumCourseBookingDetailFragment.getEditText().getText().toString());
                } catch (NumberFormatException ex) { // handle your exception
                }

                if (memberSumTextInputLayout > 0 && memberSumTextInputLayout <= memberSum) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setTitle("Konfirmasi");
                    alert.setMessage("Reservasi kursus akan dikirim. Apakah anda yakin?");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                            objMemberSumCourseBookingDetailFragment = Integer.parseInt(textInputLayoutMemberSumCourseBookingDetailFragment.getEditText().getText().toString());

                            courseBookingViewModelCourseBookingDetailFragment.init(helperCourseBookingDetailFragment.getAccessToken()); //unsend

                            courseBookingViewModelCourseBookingDetailFragment.addCourseBooking(courseId, memberSumTextInputLayout).observe(CourseBookingDetailFragment.this.requireActivity(), status -> {
                                if (!status.isEmpty()) {
                                    if (status == "Reservasi kursus berhasil!") {
                                        // Navigation.findNavController(view).navigate(R.id.action_courseBookingDetailFragment_to_findSkillFragment);
                                        Toast.makeText(CourseBookingDetailFragment.this.requireActivity(), status, Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(CourseBookingDetailFragment.this.requireActivity(), status, Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(CourseBookingDetailFragment.this.requireActivity(), "Terjadi kesalahan!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.create().show();
                } else {
                    if (memberSumTextInputLayout > memberSum) {
                        Toast.makeText(CourseBookingDetailFragment.this.requireActivity(), "Kuota peserta kursus tidak memenuhi!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CourseBookingDetailFragment.this.requireActivity(), "Jumlah peserta kursus minimal 1 peserta!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

//    private void checkButtonReservation() {
//        if (textInputLayoutMemberSumCourseBookingDetailFragment.getEditText().getText().toString().trim() != null) {
//            buttonReservationCourseBookingDetailFragment.setEnabled(true);
//            buttonReservationCourseBookingDetailFragment.setBackgroundResource(R.color.blue500);
//        } else {
//            buttonReservationCourseBookingDetailFragment.setEnabled(false);
//            buttonReservationCourseBookingDetailFragment.setBackgroundResource(R.color.grey500);
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}
