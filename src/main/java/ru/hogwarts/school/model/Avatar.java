package ru.hogwarts.school.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.Objects;

@Entity
@Data
@Table(name = "avatar")
public class Avatar {
    @Id
    @GeneratedValue
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;
    private byte[] data;

}
