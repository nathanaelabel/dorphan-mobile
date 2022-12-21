package com.example.dorphan.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dorphan.Models.Course;
import com.example.dorphan.R;

import java.util.List;

public class rvAdapterFindTutorFragment extends RecyclerView.Adapter<rvAdapterFindTutorFragment
        .rvAdapterFindTutorFragmentHolder> {

    private List<Course.Result> listCourses;
    private Context context;

    public List<Course.Result> getListCourses() {
        return listCourses;
    }

    public void setListCoursesAdapter(List<Course.Result> listCourses) {
        this.listCourses = listCourses;
    }

    public rvAdapterFindTutorFragment(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public rvAdapterFindTutorFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_find_tutor, parent, false);
        return new rvAdapterFindTutorFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapterFindTutorFragment.rvAdapterFindTutorFragmentHolder holder, int position) {
        Course.Result course = getListCourses().get(position);
        holder.textViewNameCardFindTutor.setText(course.getTutor_user().getName() + " [Maksimum: " + course.getMaximum_member() + " Peserta Kursus]");
        holder.textViewPriceCardFindTutor.setText("Rp. " + String.valueOf(course.getPrice_sum()) + " [" + course.getHour_sum() + " jam]");
        holder.imageViewImageCardFindTutor.setImageResource(R.drawable.tutor2);
    }

    @Override
    public int getItemCount() {
        return getListCourses().size();
    }

    public class rvAdapterFindTutorFragmentHolder extends RecyclerView.ViewHolder {
        TextView textViewNameCardFindTutor, textViewPriceCardFindTutor;
        ImageView imageViewImageCardFindTutor;

        public rvAdapterFindTutorFragmentHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameCardFindTutor = itemView.findViewById(R.id.textViewNameCardFindTutor);
            textViewPriceCardFindTutor = itemView.findViewById(R.id.textViewPriceCardFindTutor);
            imageViewImageCardFindTutor = itemView.findViewById(R.id.imageViewImageCardFindTutor);
        }
    }
}