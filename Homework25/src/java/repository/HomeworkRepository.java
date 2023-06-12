package repository;

import lombok.SneakyThrows;

import java.sql.*;

public class HomeworkRepository {
    private final String URL = "jdbc:mysql://localhost/homework23";
    private final String USER = "taya";
    private final String PASS = "password";
    @SneakyThrows
    public void getAll() {
        String query = "SELECT * FROM homework";

       try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
           Statement statement = connection.createStatement();
       ) {
           ResultSet resultSet = statement.executeQuery(query);
           while (resultSet.next()) {
               System.out.print("ID: " + resultSet.getInt("id"));
               System.out.print(", NAME: " + resultSet.getString("name"));
               System.out.print(", DESC: " + resultSet.getString("description"));
               System.out.println();
           }
    }

    }

    @SneakyThrows
    public void add() {

        String insert = "INSERT INTO homework(name, description) " +
                "values ('?', '?')";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement statement = connection.prepareStatement(insert);
        ) {
            statement.setString(1, "Homework");
            statement.setString(2, "Unit");
            System.out.println("result: " + statement.execute());

        }

    }



    
}
