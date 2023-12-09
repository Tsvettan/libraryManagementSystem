package bg.softuni.lms.model.dto;

import bg.softuni.lms.model.entity.BaseEntity;

public class AuthorDto extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public AuthorDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
