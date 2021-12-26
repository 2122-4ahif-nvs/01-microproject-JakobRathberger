package at.htl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

@Entity
public class Poll {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Name may not be blank")
    @Size(min = 4, max = 100, message = "poll name should have size [{min},{max}]")
    private String name;
    @NotBlank(message="Description may not be blank")
    @Size(min = 4, max = 255, message = "poll description should have size [{min},{max}]")
    private String description;

    public Poll(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Poll() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
