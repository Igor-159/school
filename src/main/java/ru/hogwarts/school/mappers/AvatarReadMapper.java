package ru.hogwarts.school.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.AvatarReadDto;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.House;

@Component
public class AvatarReadMapper implements BaseMapper<Avatar, AvatarReadDto> {

    @Override
    public AvatarReadDto map(Avatar object) {
        return new AvatarReadDto(
                object.getId(),
                object.getFilePath(),
                object.getFileSize(),
                object.getMediaType()
        );
    }
}
