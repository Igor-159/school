package ru.hogwarts.school.integration.service.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import ru.hogwarts.school.annotation.IT;
//import ru.hogwarts.school.dto.StudentCreateEditDto;
//
//@IT
//@AutoConfigureMockMvc
//@RequiredArgsConstructor
//public class StudentControllerIT {
//    private final MockMvc mockMvc;

//    @Test
//    void findAll() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/students"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                );
//    }
//    @Test
//    void createStudent() throws Exception {
//        mockMvc.perform(post("/students")
//                .param(StudentCreateEditDto.Fields.name, "Ivan")
//                .param(StudentCreateEditDto.Fields.age, 35)
//                .param(StudentCreateEditDto.Fields.houseId, 1)
//                .param(StudentCreateEditDto.Fields.avatarId, 1)
//        )
//                .andExpectAll(
//                        status().is3
//                )
//    }
//}
