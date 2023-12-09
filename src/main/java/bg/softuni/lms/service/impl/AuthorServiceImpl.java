package bg.softuni.lms.service.impl;

import bg.softuni.lms.model.dto.AuthorDto;
import bg.softuni.lms.repository.AuthorRepository;
import bg.softuni.lms.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.getAllAuthors()
                .stream()
                .map(author -> new AuthorDto())
                .sorted(Comparator.comparing(AuthorDto::getName))
                .collect(Collectors.toList());
    }
}
