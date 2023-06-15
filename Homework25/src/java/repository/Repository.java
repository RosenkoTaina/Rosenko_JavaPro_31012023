package repository;

import entity.Lesson;
import lombok.SneakyThrows;

import java.util.List;

public interface Repository <T> {
    List<T> getAll();
    List<T> get(Long id);
    void update(Long id, T item);

    void add(T item);

    void delete(Long item);


}
