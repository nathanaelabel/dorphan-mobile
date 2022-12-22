package com.example.dorphan.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dorphan.Adapters.rvAdapterCourseOrderTabFragment;
import com.example.dorphan.Helpers.ItemClickSupport;
import com.example.dorphan.Helpers.SharedPreferenceHelper;
import com.example.dorphan.Models.CourseBooking;
import com.example.dorphan.R;
import com.example.dorphan.ViewModels.CourseBookingViewModel;

import java.util.ArrayList;
import java.util.List;

public class CourseOrderTabFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseOrderTabFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static CourseOrderTabFragment newInstance(String param1, String param2) {
        CourseOrderTabFragment fragment = new CourseOrderTabFragment();
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
        return inflater.inflate(R.layout.fragment_course_order_tab, container, false);
    }

    private CourseBookingViewModel courseBookingViewModelCourseOrderTabFragment;
    private SharedPreferenceHelper helperCourseOrderTabFragment;
    private RecyclerView rvCourseOrderTabFragment;
    private TextView textViewNullValueCourseOrderTabFragment;
    private List<CourseBooking.Result> arrayCourseBookingCourseOrderTabFragment;
    private rvAdapterCourseOrderTabFragment adapterCourseOrderTabFragment;
    private Bundle bundleCourseOrderTabFragment;
    private int bundleCourseBookingId;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();
        addItemClickSupport();
        courseBookingViewModelCourseOrderTabFragment.init(helperCourseOrderTabFragment.getAccessToken());
        courseBookingViewModelCourseOrderTabFragment.getCourseBookings();
        courseBookingViewModelCourseOrderTabFragment.getResultCourseBookings().observe(getActivity(), showResultCourseBookings);
    }

    private Observer<List<CourseBooking.Result>> showResultCourseBookings = new Observer<List<CourseBooking.Result>>() {
        @Override
        public void onChanged(List<CourseBooking.Result> results) {
            if (results != null) {

                List<CourseBooking.Result> listCourseBookingsNew = new ArrayList<CourseBooking.Result>();
                for (int i = 0; i < results.size(); i++) {
                    if (results.get(i).getStatus().equalsIgnoreCase("pending")) {
                        listCourseBookingsNew.add(results.get(i));
                    }
                }
                if (listCourseBookingsNew.size() > 0) {
                    textViewNullValueCourseOrderTabFragment.setVisibility(View.GONE);
                    setRvCourseOrderTabFragment(listCourseBookingsNew);
                } else {
                    textViewNullValueCourseOrderTabFragment.setVisibility(View.VISIBLE);
                    textViewNullValueCourseOrderTabFragment.setText("Data kursus masih kosong");
                }
            }
        }
    };

    private void setRvCourseOrderTabFragment(List<CourseBooking.Result> listCourseBookingsNew) {
        rvCourseOrderTabFragment.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapterCourseOrderTabFragment = new rvAdapterCourseOrderTabFragment(getActivity());
        adapterCourseOrderTabFragment.setListCourseBookingsAdapter(listCourseBookingsNew);
        rvCourseOrderTabFragment.setAdapter(adapterCourseOrderTabFragment);
    }

    private void initial() {
        helperCourseOrderTabFragment = SharedPreferenceHelper.getInstance(requireActivity());
        rvCourseOrderTabFragment = getActivity().findViewById(R.id.rvCourseOrderTabFragment);
        textViewNullValueCourseOrderTabFragment = getActivity().findViewById(R.id.textViewNullValueCourseOrderTabFragment);
        courseBookingViewModelCourseOrderTabFragment = new ViewModelProvider(getActivity()).get(CourseBookingViewModel.class);
    }

    private void addItemClickSupport() {
        ItemClickSupport.addTo(rvCourseOrderTabFragment).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                bundleCourseOrderTabFragment = new Bundle();
                bundleCourseBookingId = adapterCourseOrderTabFragment.getListCourseBookings().get(position).getId();
                bundleCourseOrderTabFragment.putString("courseBookingId", "" + bundleCourseBookingId);
                bundleCourseOrderTabFragment.putBoolean("isReservation", false);
                Navigation.findNavController(v).navigate(R.id.action_courseOrderTabFragment_to_courseBookingDetailFragment, bundleCourseOrderTabFragment);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}
