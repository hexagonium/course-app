package com.example.courseapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courseapp.CoursePageActivity;
import com.example.courseapp.R;
import com.example.courseapp.model.CourseModel;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    Context context;
    List<CourseModel> courses;

    public CourseAdapter(Context context, List<CourseModel> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.courseBg.setBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imgId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImg.setImageResource(imgId);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());

        // При нажатии на карточку курса, запускается страница курса и передаются соответствующие данные
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePageActivity.class);

                intent.putExtra("course_page_bg", Color.parseColor(courses.get(position).getColor()));
                intent.putExtra("course_page_img", imgId);
                intent.putExtra("course_page_title", courses.get(position).getTitle());
                intent.putExtra("course_page_date", courses.get(position).getDate());
                intent.putExtra("course_page_level", courses.get(position).getLevel());
                intent.putExtra("course_page_desc", courses.get(position).getDesc());
                intent.putExtra("course_page_id", courses.get(position).getId());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout courseBg;
        ImageView courseImg;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = (RelativeLayout) itemView.findViewById(R.id.course_bg);
            courseImg = (ImageView) itemView.findViewById(R.id.course_img);
            courseTitle = (TextView) itemView.findViewById(R.id.course_title);
            courseDate = (TextView) itemView.findViewById(R.id.course_date);
            courseLevel = (TextView) itemView.findViewById(R.id.course_level);
        }
    }
}
