package com.example.dorphan.Views.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dorphan.Adapters.rvAdapterFindSkillFragment;
import com.example.dorphan.Helpers.ItemClickSupport;
import com.example.dorphan.Helpers.SharedPreferenceHelper;
import com.example.dorphan.Models.Skill;
import com.example.dorphan.R;
import com.example.dorphan.ViewModels.SkillViewModel;

import java.util.List;

public class FindSkillFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FindSkillFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static FindSkillFragment newInstance(String param1, String param2) {
        FindSkillFragment fragment = new FindSkillFragment();
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
        return inflater.inflate(R.layout.fragment_find_skill, container, false);
    }

    private SkillViewModel skillViewModelFindSkillFragment;
    private SharedPreferenceHelper helperFindSkillFragment;
    private RecyclerView rvFindSkillFragment;
    private List<Skill.Result> arraySkillFindSkillFragment;
    private rvAdapterFindSkillFragment adapterFindSkillFragment;
    private Bundle bundleFindSkillFragment;
    private int bundleSkillId;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initial();
        addItemClickSupport();
        skillViewModelFindSkillFragment.init(helperFindSkillFragment.getAccessToken()); //unsend
        skillViewModelFindSkillFragment.getSkills();
        skillViewModelFindSkillFragment.getResultSkills().observe(getActivity(), showResultSkills);
    }

    private Observer<List<Skill.Result>> showResultSkills = new Observer<List<Skill.Result>>() {
        @Override
        public void onChanged(List<Skill.Result> results) {
            if (results != null) {
                setRvFindSkillFragment(results);
            }
        }
    };

    private void setRvFindSkillFragment(List<Skill.Result> results) {
        rvFindSkillFragment.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapterFindSkillFragment = new rvAdapterFindSkillFragment(getActivity());
        adapterFindSkillFragment.setListSkillsAdapter(results);
        rvFindSkillFragment.setAdapter(adapterFindSkillFragment);
    }

    private void initial() {
        helperFindSkillFragment = SharedPreferenceHelper.getInstance(requireActivity());
        rvFindSkillFragment = getActivity().findViewById(R.id.rvFindSkillFragment);
        skillViewModelFindSkillFragment = new ViewModelProvider(getActivity()).get(SkillViewModel.class);
    }

    private void addItemClickSupport() {
        ItemClickSupport.addTo(rvFindSkillFragment).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                bundleFindSkillFragment = new Bundle();
                bundleSkillId = adapterFindSkillFragment.getListSkills().get(position).getId();
                bundleFindSkillFragment.putString("skillId", "" + bundleSkillId);
                Navigation.findNavController(v).navigate(R.id.action_findSkillFragment_to_findTutorFragment, bundleFindSkillFragment);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getActivity().getViewModelStore().clear();
    }
}