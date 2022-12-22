package com.example.dorphan.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dorphan.Models.CourseBooking;
import com.example.dorphan.R;

import java.util.List;

public class rvAdapterCourseOrderTabFragment extends RecyclerView.Adapter<rvAdapterCourseOrderTabFragment
        .rvAdapterCourseOrderTabFragmentHolder> {
    private List<CourseBooking.Result> listCourseBookings;
    private Context context;

    public List<CourseBooking.Result> getListCourseBookings() {
        return listCourseBookings;
    }

    public void setListCourseBookingsAdapter(List<CourseBooking.Result> listCourseBookings) {
        this.listCourseBookings = listCourseBookings;
    }

    public rvAdapterCourseOrderTabFragment(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public rvAdapterCourseOrderTabFragment.rvAdapterCourseOrderTabFragmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_course_order, parent, false);
        return new rvAdapterCourseOrderTabFragment.rvAdapterCourseOrderTabFragmentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapterCourseOrderTabFragment.rvAdapterCourseOrderTabFragmentHolder holder, int position) {
        CourseBooking.Result courseBooking = getListCourseBookings().get(position);
        holder.textViewTutorNameCourseOrderTabFragment.setText(courseBooking.getTutor_user().getName());

        if (courseBooking.getCourse().getIs_online() == 1) {
            holder.textViewIsOnlineCourseOrderTabFragment.setText("Daring");
            holder.textViewIsOnlineCourseOrderTabFragment.setTextColor(Color.GREEN);
        } else {
            holder.textViewIsOnlineCourseOrderTabFragment.setText("Luring");
            holder.textViewIsOnlineCourseOrderTabFragment.setTextColor(Color.RED);
        }

        holder.textViewCourseNameCourseOrderTabFragment.setText(courseBooking.getCourse().getSkill().getName());
        holder.textViewCourseDayCourseOrderTabFragment.setText(courseBooking.getCourse().getDay() + ", Jam " + courseBooking.getCourse().getStart_time());
        holder.textViewCourseMemberSumCourseOrderTabFragment.setText(String.valueOf(courseBooking.getMember_sum() + " Peserta"));
        holder.textViewCoursePriceSumCourseOrderTabFragment.setText("Rp. " + String.valueOf(courseBooking.getCourse().getPrice_sum()));
    }

    @Override
    public int getItemCount() {
        return getListCourseBookings().size();
    }

    public class rvAdapterCourseOrderTabFragmentHolder extends RecyclerView.ViewHolder {
        TextView textViewTutorNameCourseOrderTabFragment, textViewIsOnlineCourseOrderTabFragment,
                textViewCourseNameCourseOrderTabFragment, textViewCourseDayCourseOrderTabFragment,
                textViewCourseMemberSumCourseOrderTabFragment, textViewCoursePriceSumCourseOrderTabFragment;

        public rvAdapterCourseOrderTabFragmentHolder(@NonNull View itemView) {
            super(itemView);
            textViewTutorNameCourseOrderTabFragment = itemView.findViewById(R.id.textViewTutorNameCourseOrderTabFragment);
            textViewIsOnlineCourseOrderTabFragment = itemView.findViewById(R.id.textViewIsOnlineCourseOrderTabFragment);
            textViewCourseNameCourseOrderTabFragment = itemView.findViewById(R.id.textViewCourseNameCourseOrderTabFragment);
            textViewCourseDayCourseOrderTabFragment = itemView.findViewById(R.id.textViewCourseDayCourseOrderTabFragment);
            textViewCourseMemberSumCourseOrderTabFragment = itemView.findViewById(R.id.textViewCourseMemberSumCourseOrderTabFragment);
            textViewCoursePriceSumCourseOrderTabFragment = itemView.findViewById(R.id.textViewCoursePriceSumCourseOrderTabFragment);
        }
    }
}
