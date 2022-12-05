package com.example.courseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseapp.model.OrderModel;

public class CoursePageActivity extends AppCompatActivity {
    ConstraintLayout coursePageBg;
    ImageView coursePageImg;
    TextView coursePageTitle, coursePageDate, coursePageLevel, coursePageDesc;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        coursePageBg = (ConstraintLayout) findViewById(R.id.course_page_bg);
        coursePageImg = (ImageView) findViewById(R.id.course_page_img);
        coursePageTitle = (TextView) findViewById(R.id.course_page_title);
        coursePageDate = (TextView) findViewById(R.id.course_page_date);
        coursePageLevel = (TextView) findViewById(R.id.course_page_level);
        coursePageDesc = (TextView) findViewById(R.id.course_page_desc);

        coursePageBg.setBackgroundColor(getIntent().getIntExtra("course_page_bg", 0));
        coursePageImg.setImageResource(getIntent().getIntExtra("course_page_img", 0));
        coursePageTitle.setText(getIntent().getStringExtra("course_page_title"));
        coursePageDate.setText(getIntent().getStringExtra("course_page_date"));
        coursePageLevel.setText(getIntent().getStringExtra("course_page_level"));
        coursePageDesc.setText(getIntent().getStringExtra("course_page_desc"));

        addToCart = (Button) findViewById(R.id.course_page_add_to_basket);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int courseID = getIntent().getIntExtra("course_page_id", 0);
                OrderModel.itemsID.add(courseID);

                Toast.makeText(getBaseContext(), "Добавлено!", Toast.LENGTH_LONG).show();
            }
        });
    }
}