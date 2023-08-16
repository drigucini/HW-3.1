package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.dto.AvatarDTO;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService{
    void uploadAvatar (long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatar(Long studentId);
    Collection<AvatarDTO> getAvatars(int pageNumber, int pageSize);
}
