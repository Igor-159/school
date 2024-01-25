package ru.hogwarts.school.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.AvatarReadDto;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.model.Student;

import java.util.Optional;


@Component
@RequiredArgsConstructor
public class StudentReadMapper implements BaseMapper<Student, StudentReadDto>{

    private final HouseReadMapper houseReadMapper;
    private final AvatarReadMapper avatarReadMapper;
    @Override
    public StudentReadDto map(Student object) {
        HouseReadDto house = Optional.ofNullable(object.getHouse())
                .map(houseReadMapper::map)
                .orElse(null);

        AvatarReadDto avatar = Optional.ofNullable(object.getAvatar())
                .map(avatarReadMapper::map)
                .orElse(null);

        return new StudentReadDto(
                object.getId(),
                object.getName(),
                object.getAge(),
                avatar,
                house
        );
    }
}
