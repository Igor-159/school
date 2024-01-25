package ru.hogwarts.school.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.StudentCreateEditDto;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.HouseRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentCreateEditMapper implements BaseMapper<StudentCreateEditDto, Student>{

    private final HouseRepository houseRepository;
    private final AvatarRepository avatarRepository;

    @Override
    public Student map(StudentCreateEditDto fromObject, Student toObject) {

        copy(fromObject, toObject);
        return toObject;
    }
    @Override
    public Student map(StudentCreateEditDto object) {
        Student student = new Student();
        copy(object, student);


        return student;
    }

    private void copy(StudentCreateEditDto object, Student student) {
        student.setName(object.getName());
        student.setAge(object.getAge());
        student.setHouse(getHouse(object.getHouseId()));
        student.setAvatar((getAvatar(object.getAvatarId())));
    }

    private Avatar getAvatar(Long avatarId) {
        return Optional.ofNullable(avatarId)
                .flatMap(avatarRepository::findById)
                .orElse(null);
    }

    private House getHouse(Long houseId) {
        return Optional.ofNullable(houseId)
                .flatMap(houseRepository::findById)
                .orElse(null);
    }

}
