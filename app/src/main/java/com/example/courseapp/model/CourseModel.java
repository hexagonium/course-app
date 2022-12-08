package com.example.courseapp.model;

// Класс, описывающий карточки курсов на главной странице
public class CourseModel {
    private int id, category;
    private String title, img, date, level, color, desc;

    public CourseModel(int id, int category, String title, String img, String date, String level, String color, String desc) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.img = img;
        this.date = date;
        this.level = level;
        this.color = color;
        this.desc = desc;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
