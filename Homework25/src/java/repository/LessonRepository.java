package repository;

import entity.Lesson;
import enums.DataSourceFactory;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class LessonRepository implements Repository<Lesson> {
    private HomeworkRepository homeworkRepository = new HomeworkRepository();

    @SneakyThrows
    @Override
    public List<Lesson> getAll() {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT * FROM lesson";

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Lesson lesson = Lesson.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .updatedAt(resultSet.getTimestamp("updatedAt").toLocalDateTime())
                        .homeworkId(resultSet.getLong("homework_id"))
                        .build();

                lessons.add(lesson);
            }
        }

        return lessons;
    }

    @SneakyThrows
    @Override
    public List<Lesson> get(Long id) {
        String query = "SELECT * FROM lesson WHERE id = ?";
        List<Lesson> getLesson = new ArrayList<>();

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lesson lesson = Lesson.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .updatedAt(resultSet.getTimestamp("updatedAt").toLocalDateTime())
                        .homeworkId(resultSet.getLong("homework_id"))
                        .build();

                getLesson.add(lesson);
            }
        }

        return getLesson;
    }

    @SneakyThrows
    @Override
    public void update(Long id, Lesson item) {
        String query = "UPDATE lesson SET name = ?, updatedAt = ?, homework_id = ? WHERE id = ?";

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getUpdatedAt()));
            if (item.getHomeworkId() != null) {
                statement.setLong(3, item.getHomeworkId());
            } else {
                statement.setNull(3, Types.NULL);
            }
            statement.setLong(4, id);

            statement.executeUpdate();
        }
    }

    @SneakyThrows
    @Override
    public void add(Lesson lesson) {
        String query = "INSERT INTO lesson (name, updatedAt, homework_id) VALUES (?, ?, ?)";

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, lesson.getName());
            statement.setTimestamp(2, Timestamp.valueOf(lesson.getUpdatedAt()));
            statement.setLong(3, lesson.getHomeworkId());

            statement.execute();
        }
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
        String query = "DELETE FROM lesson WHERE id = ?";

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}