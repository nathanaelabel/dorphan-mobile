package com.example.dorphan.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dorphan.Models.Skill;
import com.example.dorphan.R;

import java.util.List;

public class rvAdapterFindSkillFragment extends RecyclerView.Adapter<rvAdapterFindSkillFragment
        .rvAdapterFindSkillFragmentHolder> {

    private List<Skill.Result> listSkills;
    private Context context;

    public List<Skill.Result> getListSkills() {
        return listSkills;
    }

    public void setListSkillsAdapter(List<Skill.Result> list_skills) {
        this.listSkills = list_skills;
    }

    public rvAdapterFindSkillFragment(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public rvAdapterFindSkillFragment.rvAdapterFindSkillFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_find_skill, parent, false);
        return new rvAdapterFindSkillFragment.rvAdapterFindSkillFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapterFindSkillFragment.rvAdapterFindSkillFragmentHolder holder, int position) {
        Skill.Result skill = getListSkills().get(position);

        holder.textViewNameCardFindSkill.setText(skill.getName());
        holder.textViewSumTutorCardFindSkill.setText(String.valueOf(skill.getCourses().size()) + " Tutor");
    }

    @Override
    public int getItemCount() {
        return getListSkills().size();
    }

    public class rvAdapterFindSkillFragmentHolder extends RecyclerView.ViewHolder {
        TextView textViewNameCardFindSkill, textViewSumTutorCardFindSkill;

        public rvAdapterFindSkillFragmentHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameCardFindSkill = itemView.findViewById(R.id.textViewNameCardFindSkill);
            textViewSumTutorCardFindSkill = itemView.findViewById(R.id.textViewSumTutorCardFindSkill);
        }
    }
}