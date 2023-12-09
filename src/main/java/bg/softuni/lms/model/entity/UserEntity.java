package bg.softuni.lms.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    private String username;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> roleEntityList = new ArrayList<>();
    private String password;
    private boolean active;

    @Column(unique = true)
    private String email;

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<UserRoleEntity> getRoleEntityList() {
        return roleEntityList;
    }

    public UserEntity setRoleEntityList(List<UserRoleEntity> roleEntityList) {
        this.roleEntityList = roleEntityList;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public UserEntity setActive(boolean active) {
        this.active = active;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }
}
