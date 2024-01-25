package ru.hogwarts.school.service;


import ru.hogwarts.school.model.House;
import java.util.List;
import java.util.Optional;

public interface HouseService {
    public List<House> getAllHouse();

    public House createHouse(House house);

    public Optional<House> getHouse(Long id);

    public House updateHouse(Long id, String newColor);

    public House deleteHouse(Long id);

    public List<House> getHousesByColor(String color);
}
