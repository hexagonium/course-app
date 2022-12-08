package com.example.courseapp.model;

// Класс, описывающий категории фильтра курсов на главной странице
public class CategoryModel {

    private int id;
    private String title;

    public CategoryModel(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
