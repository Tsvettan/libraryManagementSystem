package bg.softuni.lms.model.entity;

import jakarta.persistence.Entity;

@Entity
public class Genre extends BaseEntity {
    private String genreName;

    public String getName() {
        return genreName;
    }

    public void setName(String name) {
        this.genreName = name;
    }
}
