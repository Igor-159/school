package ru.hogwarts.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;


    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @OneToOne
    Avatar avatar;

    public Avatar getAvatar() {
        return avatar;
    }


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

//    public House getHouse() {
//        return house;
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setHouse(House house) {
//        this.house = house;
//    }
//
//
//    public void setAvatar(Avatar avatar) {
//        this.avatar = avatar;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", house=" + house +
//                ", avatar=" + avatar +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(house, student.house) && Objects.equals(avatar, student.avatar);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, age, house, avatar);
//    }
}






