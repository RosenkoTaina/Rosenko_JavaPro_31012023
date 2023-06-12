package repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkRepositoryTest {

    @Test
    void getAll() {
            new HomeworkRepository().getAll();
    }

    @Test
    void getInsert() {
        new HomeworkRepository().add();
    }



}