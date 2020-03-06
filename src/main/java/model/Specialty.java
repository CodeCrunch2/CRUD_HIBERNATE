package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "specialities")
public class Specialty extends BaseEntity {
    @Column(name = "speciality_name")
    private String specialtyName;
    @Column(name = "description")
    private String description;

    public Specialty() {
    }

    public Specialty(String specialtyName, String description) {
        this.specialtyName = specialtyName;
        this.description = description;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;
        Specialty specialty = (Specialty) o;
        return Objects.equals(specialtyName, specialty.specialtyName) &&
                Objects.equals(description, specialty.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specialtyName, description);
    }
}
