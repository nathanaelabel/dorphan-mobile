package com.example.dorphan.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dorphan.Adapters.rvAdapterFindSkillFragment;
import com.example.dorphan.Adapters.rvAdapterFindTutorFragment;
import com.example.dorphan.Helpers.ItemClickSupport;
import com.example.dorphan.Helpers.SharedPreferenceHelper;
import com.example.dorphan.Models.Course;
import com.example.dorphan.Models.Skill;
import com.example.dorphan.R;
import com.example.dorphan.ViewModels.CourseViewModel;
import com.example.dorphan.ViewModels.SkillViewModel;

import java.util.List;

public class FindTutorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FindTutorFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static FindTutorFragment newInstance(String param1, String param2) {
        FindTutorFragment fragment = new FindTutorFragment();
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
        return inflater.inflate(R.layout.fragment_find_tutor, container, false);
    }

    private CourseViewModel courseViewModelFindTutorFragment;
    private SharedPreferenceHelper helperFindTutorFragment;
    private RecyclerView rvFindTutorFragment;
    private List<Course.Result> arrayCourseFindTutorFragment;
    private rvAdapterFindTutorFragment adapterFindTutorFragment;
    private Bundle bundleFindTutorFragment;
    private int bundleCourseId, skillId;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();

        skillId = Integer.parseInt(getArguments().getString("skillId"));

        courseViewModelFindTutorFragment.init(helperFindTutorFragment.getAccessToken());
        courseViewModelFindTutorFragment.getCoursesFromSkill(skillId);
        courseViewModelFindTutorFragment.getResultCoursesFromSkill().observe(getActivity(), showResultCoursesFromSkill);
        addItemClickSupport();
    }

    private Observer<List<Course.Result>> showResultCoursesFromSkill = new Observer<List<Course.Result>>() {
        @Override
        public void onChanged(List<Course.Result> results) {
            if (results != null) {
                System.out.println("results" + results.size());
                setRvFindTutorFragment(results);
            }
        }
    };

    private void setRvFindTutorFragment(List<Course.Result> results) {
        rvFindTutorFragment.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapterFindTutorFragment = new rvAdapterFindTutorFragment(getActivity());
        adapterFindTutorFragment.setListCoursesAdapter(results);
        rvFindTutorFragment.setAdapter(adapterFindTutorFragment);
    }

    private void initial() {
        helperFindTutorFragment = SharedPreferenceHelper.getInstance(requireActivity());
        rvFindTutorFragment = getActivity().findViewById(R.id.rvFindTutorFragment);
        courseViewModelFindTutorFragment = new ViewModelProvider(getActivity()).get(CourseViewModel.class);
    }

    private void addItemClickSupport() {
        ItemClickSupport.addTo(rvFindTutorFragment).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                bundleFindTutorFragment = new Bundle();
                bundleCourseId = adapterFindTutorFragment.getListCourses().get(position).getId();
                bundleFindTutorFragment.putString("courseId", "" + bundleCourseId);
                bundleFindTutorFragment.putBoolean("isReservation", true);
                Navigation.findNavController(v).navigate(R.id.action_findTutorFragment_to_courseBookingDetailFragment, bundleFindTutorFragment);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}