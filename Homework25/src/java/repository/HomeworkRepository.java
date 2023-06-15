package repository;

import entity.Homework;
import enums.DataSourceFactory;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeworkRepository implements Repository<Homework> {
    @Override
    @SneakyThrows
    public List<Homework> getAll() {
        String query = "SELECT * FROM homework";
        List<Homework> homeworks = new ArrayList<>();

       try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
            Statement statement = connection.createStatement();
       ) {
           ResultSet resultSet = statement.executeQuery(query);

           while (resultSet.next()) {

            Homework homework = Homework.builder()
               .id(resultSet.getLong("id"))
               .name(resultSet.getString("name"))
               .description(resultSet.getString("description"))
               .build();

            homeworks.add(homework);
           }
    }
       return homeworks;
    }

    @SneakyThrows
    @Override
    public List<Homework> get(Long id) {
        String query = "SELECT * FROM homework WHERE id = ?";
        List<Homework> getHomework = new ArrayList<>();
        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Homework homework = Homework.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .description(resultSet.getString("description"))
                        .build();

                getHomework.add(homework);
            }
        }
        return getHomework;
    }


    @Override
    @SneakyThrows
    public void update(Long id, Homework item) {
        String query = "UPDATE homework SET name = ?, description = ? WHERE id = ?";
        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setObject(3, id);

            statement.executeUpdate();
        }
    }


    @Override
    @SneakyThrows
    public void delete(Long id) {
        String query = "DELETE FROM homework WHERE id = ?";
        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }



    @Override
    @SneakyThrows
    public void add(Homework homework) {
        String insert = "INSERT INTO homework(name, description) " +
                "values (?, ?)";
        try (Connection connection = DataSourceFactory.INSTANCE.getConnection();
             PreparedStatement statement = connection.prepareStatement(insert);
        ) {
            statement.setString(1, homework.getName());
            statement.setString(2, homework.getDescription());
            statement.execute();
        }
    }



    
}
