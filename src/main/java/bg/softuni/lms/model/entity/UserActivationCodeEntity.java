package bg.softuni.lms.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.Instant;

@Entity
public class UserActivationCodeEntity extends BaseEntity {

    private String activationCode;
    private Instant created;

    @ManyToOne
    private UserEntity userEntity;

    public String getActivationCode() {
        return activationCode;
    }

    public UserActivationCodeEntity setActivationCode(String activationCode) {
        this.activationCode = activationCode;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public UserActivationCodeEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public UserActivationCodeEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
