package entity;

import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "homework_id")
    private Homework homework;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setHomeworkId(Long homeworkId) {
        if (this.homework == null) {
            this.homework = new Homework();
        }
        this.homework.setId(homeworkId);
    }

    public Long getHomeworkId() {
        return this.homework != null ? this.homework.getId() : null;
    }
}

