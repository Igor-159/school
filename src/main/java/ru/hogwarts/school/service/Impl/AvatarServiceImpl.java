package ru.hogwarts.school.service.Impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;

import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.AvatarService;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Slf4j
@Service
public class AvatarServiceImpl implements AvatarService {


    private final AvatarRepository avatarRepository;
    private final StudentRepository studentRepository;

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    public AvatarServiceImpl(AvatarRepository avatarRepository, StudentRepository studentRepository) {
        this.avatarRepository = avatarRepository;
        this.studentRepository = studentRepository;
    }

    public Page<Avatar> getAllAvatars(Pageable pageable) {
        log.info("getAllAvatars");
        return avatarRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {

        Student student = studentRepository
                .findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student id " + studentId + " was not found"));
        Path filePath = Path.of(avatarsDir, student.getId() + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try(
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                BufferedInputStream bis = new BufferedInputStream(is, 1024);
                BufferedOutputStream bos = new BufferedOutputStream(os, 1024);

                ) {
                bis.transferTo(bos);
        }

//        Avatar avatar = findAvatar(studentId);
        Avatar avatar = new Avatar();
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());
        avatarRepository.save(avatar);

        student.setAvatar(avatar);

        studentRepository.save(student);
        log.info("uploadAvatar");

    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }



    @Override
    public Avatar findAvatar(Long studentId) {
         Student result = studentRepository.findById(studentId).get();
         log.info("findAvatar");
         return result.getAvatar();
    }
}
