package repository;

import entity.Homework;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkRepositoryTest {

    @Test
    void getAll() {
            new HomeworkRepository().getAll()
            .forEach(System.out::println);
    }

    @Test
    void getInsert() {

      Homework homework = Homework.builder()
                .name("homework25")
                .description("SQL")
                .build();
        new HomeworkRepository().add(homework);
    }

    @Test
    public void testGetHomeworkById() {
        Homework homework = new Homework();

        Long idToGet = 1L;
        new HomeworkRepository().get(idToGet).forEach(System.out::println);

    }


}



