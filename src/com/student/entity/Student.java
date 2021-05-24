package com.student.entity;

/**
 * @author JOKRE
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String photo;

    public Student() {
    }

    public Student(String name, int age, String sex,String photo) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.photo = photo;
    }

    public Student(int id, String name, int age, String sex,String photo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
