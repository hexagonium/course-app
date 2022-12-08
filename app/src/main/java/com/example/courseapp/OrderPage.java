package com.example.courseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.courseapp.model.CourseModel;
import com.example.courseapp.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

// Экран с добавленными в корзину курсами
public class OrderPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        // Если курс был добавлен в корзину, то на этом экране в ListView будет отображено название добавленного курса
        List<String> coursesTitle = new ArrayList<>();
        for (CourseModel course: MainActivity.fullCourseList) {
            if (OrderModel.itemsID.contains(course.getId())) {
                coursesTitle.add(course.getTitle());
            }
        }

        // Создание элемента экрана списка с добавленными курсами и установка дизайна
        ListView orderList = (ListView) findViewById(R.id.cart_list);
        orderList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
    }
}