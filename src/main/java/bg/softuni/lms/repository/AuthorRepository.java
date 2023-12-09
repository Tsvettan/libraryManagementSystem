package bg.softuni.lms.repository;

import bg.softuni.lms.model.dto.AuthorDto;
import bg.softuni.lms.model.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    Optional<AuthorEntity> findByName(String name);

    @Query("SELECT a FROM AuthorEntity a")
    List<AuthorDto> getAllAuthors();
}
