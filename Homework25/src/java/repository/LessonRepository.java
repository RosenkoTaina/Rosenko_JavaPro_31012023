package repository;

import entity.Lesson;
import enums.DataSourceFactory;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class LessonRepository implements Repository<Lesson> {
    private HomeworkRepository homeworkRepository = new HomeworkRepository();

    @SneakyThrows
    @Override
    public List<Lesson> getAll() {
        String query = "SELECT l.id, l.name, l.updatedAt, h.id AS homeworkId" +
                " FROM lesson l" +
                " LEFT JOIN homework h ON l.homework_id = h.id";
        List<Lesson> lessons = new ArrayList<>();

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Lesson lesson = buildLessonFromResultSet(resultSet);
                lessons.add(lesson);
            }
        }
        return lessons;
    }
    @SneakyThrows
    @Override
    public List<Lesson> get(Long id) {
        String query = "SELECT l.id, l.name, l.updatedAt, h.id AS homeworkId" +
                " FROM lesson l" +
                " LEFT JOIN homework h ON l.homework_id = h.id" +
                " WHERE l.id = ?";
        List<Lesson> getLesson = new ArrayList<>();

        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lesson lesson = buildLessonFromResultSet(resultSet);
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
            statement.setString(2, item.getUpdatedAt());
            if (item.getHomework() != null) {
                statement.setLong(3, item.getHomework().getId());
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
            statement.setString(2, lesson.getUpdatedAt());
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

    private Lesson buildLessonFromResultSet(ResultSet resultSet) throws SQLException {
        Lesson lesson = new Lesson();
        lesson.setId(resultSet.getLong("id"));
        lesson.setName(resultSet.getString("name"));
        lesson.setUpdatedAt(resultSet.getString("updatedAt"));
        lesson.setHomeworkId(resultSet.getLong("homeworkId"));
        return lesson;
    }
}
