package enums;

import lombok.SneakyThrows;
import service.PropertyReader;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public enum DataSourceFactory {
    INSTANCE;
    private final DataSource dataSource;

    DataSourceFactory() {
        this.dataSource = getDataSource();
    }

    private DataSource getDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        Properties properties = new PropertyReader().getProperties("app.properties");
        mysqlDataSource.setURL(properties.getProperty("db.url"));
        mysqlDataSource.setUser(properties.getProperty("db.user"));
        mysqlDataSource.setPassword(properties.getProperty("db.pass"));
        return mysqlDataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


}
