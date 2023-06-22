package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {
    private Long id;
    private String name;
    private LocalDateTime updatedAt;
    private Long homeworkId;



}