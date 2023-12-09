package bg.softuni.lms.repository;

import bg.softuni.lms.model.entity.UserRoleEntity;
import bg.softuni.lms.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findAllByRole(List<UserRoleEnum> roleEnums);
}
