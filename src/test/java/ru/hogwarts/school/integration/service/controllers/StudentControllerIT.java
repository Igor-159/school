package ru.hogwarts.school.integration.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import ru.hogwarts.school.annotation.IT;

@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class StudentControllerIT {
    private final MockMvc mockMvc;
}
