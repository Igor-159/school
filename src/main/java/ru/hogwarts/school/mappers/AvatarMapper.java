package ru.hogwarts.school.mappers;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.AvatarReadDto;
import ru.hogwarts.school.model.Avatar;


//@Component
//public class AvatarMapper {
//
//    public AvatarReadDto mapToAvatarDto (Avatar avatar) {
//        AvatarReadDto dto = new AvatarReadDto();
//        dto.setId(avatar.getId());
//        dto.setFilePath(avatar.getFilePath());
//        dto.setFileSize(avatar.getFileSize());
//        dto.setMediaType(avatar.getMediaType());
//        return dto;
//    }
//
//    public  Avatar mapToAvatar(AvatarReadDto dto) {
//        Avatar avatar = new Avatar();
//        avatar.setId(dto.getId());
//        avatar.setFilePath(dto.getFilePath());
//        avatar.setFileSize(dto.getFileSize());
//        avatar.setMediaType(dto.getMediaType());
//        return avatar;
//    }
//}
