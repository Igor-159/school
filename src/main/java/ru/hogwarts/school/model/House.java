package ru.hogwarts.school.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;




//    public House(String name, String color) {
//        this.name = name;
//        this.color = color;
//    }
//
//    public House() {
//    }
//
////    public List<Student> getStudents() {
////        return new ArrayList<>(students);
////    }
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
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        House house = (House) o;
//        return Objects.equals(id, house.id) && Objects.equals(name, house.name) && Objects.equals(color, house.color);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, color);
//    }
//
//    @Override
//    public String toString() {
//        return "House{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", color='" + color + '\'' +
//                '}';
//    }
}
