package ru.hogwarts.school.mappers;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.HouseReadDto;

import ru.hogwarts.school.mappers.BaseMapper;
import ru.hogwarts.school.model.House;


@Component
public class HouseReadMapper implements BaseMapper<House, HouseReadDto> {

    @Override
    public HouseReadDto map(House object) {
        return new HouseReadDto(
                object.getId(),
                object.getName(),
                object.getColor()
        );
    }
}
