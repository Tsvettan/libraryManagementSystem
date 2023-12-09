package bg.softuni.lms.service;

import bg.softuni.lms.model.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> getAllAuthors();
}
