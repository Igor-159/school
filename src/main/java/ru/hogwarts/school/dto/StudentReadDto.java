package ru.hogwarts.school.dto;


import lombok.AllArgsConstructor;
import lombok.Value;

@Value
public class StudentReadDto {

     Long id;
     String name;
     int age;
     AvatarReadDto avatar;
     HouseReadDto house;
}
