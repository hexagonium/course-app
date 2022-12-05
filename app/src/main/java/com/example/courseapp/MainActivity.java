package com.example.courseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.courseapp.adapter.CategoryAdapter;
import com.example.courseapp.adapter.CourseAdapter;
import com.example.courseapp.model.CategoryModel;
import com.example.courseapp.model.CourseModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<CourseModel> courseList;
    static List<CourseModel> fullCourseList;

    final int ID_COURSE_CATEGORY_GAMES = 1;
    final int ID_COURSE_CATEGORY_LANGUAGES = 2;
    final int ID_COURSE_CATEGORY_COURSES = 3;
    final int ID_COURSE_CATEGORY_SITES = 4;
    final int ID_COURSE_CATEGORY_OTHER = 5;

    ImageView filterClear;

    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<CategoryModel> categoryList = new ArrayList<>();
        categoryList.add(new CategoryModel(1, "Игры"));
        categoryList.add(new CategoryModel(2, "Языки"));
        categoryList.add(new CategoryModel(3, "Курсы"));
        categoryList.add(new CategoryModel(4, "Сайты"));
        categoryList.add(new CategoryModel(5, "Прочее"));

        setCategoryRecycler(categoryList);

        String javaDesc = "Программа обучения Джава – рассчитана на новичков в данной сфере.\n\nЗа программу вы изучите построение графических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!";
        String pythonDesc = "Программа рассчитана на новичков, которые хотят изучить язык Python и начать разрабатывать программы на этом языке.\n\nЗа программу вы изучите разработку консольных, а также графических программ на Python, научитесь создавать простые программы с искусственным интеллектом, изучите работу с базами данных, а также построите и выгрузите в Интернет несколько веб сайтов, написанных на Django.";
        String unityDesc = "Программа рассчитана на новичков, которые хотят войти в сферу построения игр.\n\nЗа программу вы изучите разработку как 2D, так и 3D игр при помощи движка Unity и языка C#. Вы пройдете все этапы построения игр, научитесь работать в Unity, писать C# скрипты, добавлять анимацию и рекламу в игры, а также загрузите вашу игру в Google Play и App Store.";
        String cppDesc = "Программа рассчитана на новичков, которые хотят изучить язык программирования C++ с самых основ и до построения полноценных проектов на его основе.\n\nЗа программу вы изучите все основные и важные концепции языка: динамическая память, ООП, многопоточность, базы данных, шаблоны, STL и многое другое. Дополнительно вы разработаете несколько крутых приложений под Windows на основе WinForms и QT.";
        String frontEndDesc = "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени начать создавать веб сайты.\n\nЗа время программы вы узнаете множество новых понятий, изучите теорию, а также на практике научитесь строить полноценные веб сайты, применяя все современные технологии и навыки.";
        String nodeJsDesc = "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени стать Full Stack разработчиками на Node JS.\n\nВ ходе программы вы изучите множество технологий. Вы изучите теорию и на практике научитесь строить полноценные веб сайты, применяя все современные технологии и навыки.";

        courseList = new ArrayList<>();
        courseList.add(new CourseModel(1, ID_COURSE_CATEGORY_LANGUAGES, "Профессия Java разработчик", "java", "01.09.22", "начальный", "#424345", javaDesc));
        courseList.add(new CourseModel(2, ID_COURSE_CATEGORY_LANGUAGES, "Продвинутый Python разработчик", "python", "01.11.22", "продолжающий", "#9FA52D", pythonDesc));
        courseList.add(new CourseModel(3, ID_COURSE_CATEGORY_GAMES, "Профессия Unity разработчик", "unity", "01.08.22", "начинающий", "#f44336", unityDesc));
        courseList.add(new CourseModel(4, ID_COURSE_CATEGORY_OTHER, "Профессия C++ разработчик", "cpp", "24.10.22", "начинающий", "#007aaa", cppDesc));
        courseList.add(new CourseModel(5, ID_COURSE_CATEGORY_SITES, "Профессия Front-End разработчик", "front_end", "14.07.22", "начинающий", "#ea6a45", frontEndDesc));
        courseList.add(new CourseModel(6, ID_COURSE_CATEGORY_SITES, "Продвинутый Full-Stack разработчик", "node_js", "3.09.22", "продолжающий", "#fff112", nodeJsDesc));

        fullCourseList = new ArrayList<>();
        fullCourseList.addAll(courseList);

        setCourseRecycler(courseList);

        filterClear = (ImageView) findViewById(R.id.filter);
        filterClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                courseList.clear();
                courseList.addAll(fullCourseList);
                courseAdapter.notifyDataSetChanged();
            }
        });

        cart = (Button) findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setCategoryRecycler(List<CategoryModel> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.category_recycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setCourseRecycler(List<CourseModel> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.course_recycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    public static void showCoursesByCategory(int category) {
        courseList.clear();
        courseList.addAll(fullCourseList);

        List<CourseModel> filterCourses = new ArrayList<>();

        for (CourseModel course: courseList) {
            if (course.getCategory() == category) {
                filterCourses.add(course);
            }
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        courseAdapter.notifyDataSetChanged();
    }
}