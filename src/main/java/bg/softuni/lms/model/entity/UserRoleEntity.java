package bg.softuni.lms.model.entity;

import bg.softuni.lms.model.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum roleEnum;

    public Long getId() {
        return id;
    }

    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleEnum getRoleEnum() {
        return roleEnum;
    }

    public UserRoleEntity setRoleEnum(UserRoleEnum roleEnum) {
        this.roleEnum = roleEnum;
        return this;
    }
}
