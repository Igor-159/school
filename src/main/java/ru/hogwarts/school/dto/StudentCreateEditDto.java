package ru.hogwarts.school.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;

@Value
@FieldNameConstants
public class StudentCreateEditDto {

     String name;
     int age;
     Long houseId;
     Long avatarId;
}
