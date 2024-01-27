package ru.hogwarts.school.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "ru.hogwarts.school.controllers")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
