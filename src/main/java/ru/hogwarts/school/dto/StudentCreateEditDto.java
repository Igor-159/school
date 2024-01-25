package ru.hogwarts.school.dto;

import lombok.Value;

@Value
public class StudentCreateEditDto {

     String name;
     int age;
     Long houseId;
     Long avatarId;
}
