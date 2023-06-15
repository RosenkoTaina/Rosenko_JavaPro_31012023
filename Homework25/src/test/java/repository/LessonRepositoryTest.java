package repository;

import entity.Lesson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LessonRepositoryTest {
    private LessonRepository lessonRepository;

    @BeforeEach
    public void setUp() {
        lessonRepository = new LessonRepository();
    }

    @Test
    public void testGetAll() {
        new LessonRepository().getAll()
                .forEach(System.out::println);
    }

    @Test
    public void testAddAndGetLesson() {
        Lesson lesson = new Lesson();
        lesson.setName("Lesson6");
        lesson.setUpdatedAt("2023-06-14");
        lesson.setHomeworkId(6L);

        lessonRepository.add(lesson);

        new LessonRepository().getAll()
                .forEach(System.out::println);
    }

    @Test
    public void testUpdateLesson() {


        lessonRepository.getAll().forEach(System.out::println);

        Lesson retrievedLesson = new Lesson();
        retrievedLesson.setName("Science");
        retrievedLesson.setUpdatedAt("2023-09-15");
        retrievedLesson.setHomeworkId(9L);

        System.out.println("-------------");
        lessonRepository.update(9L, retrievedLesson);

        lessonRepository.getAll().forEach(System.out::println);

    }

    @Test
    public void testDeleteLesson() {

        List<Lesson> lessons = lessonRepository.getAll();


        Lesson lesson = new Lesson();
        lesson.setName("Lesson34");
        lesson.setUpdatedAt("2023-06-14");
        lesson.setHomeworkId(8L);


        Long after = (long) lessons.size()+1;
        Long before = (long) lessons.size();

        lessonRepository.add(lesson);
        lessonRepository.delete(after);


        lessonRepository.getAll();
        assertNotNull(lessons);
        assertEquals(before, lessons.size());


    }
}

