package ru.hogwarts.school.dto;

public class StudentDto {
    private Long id;
    private String name;
    private int age;
    private HouseReadDto house;
    private AvatarReadDto avatarDto;

    public AvatarReadDto getAvatar() {
        return avatarDto;
    }

    public void setAvatar(AvatarReadDto avatarDto) {
        this.avatarDto = avatarDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HouseReadDto getHouse() {
        return house;
    }

    public void setHouse(HouseReadDto house) {
        this.house = house;
    }
}
