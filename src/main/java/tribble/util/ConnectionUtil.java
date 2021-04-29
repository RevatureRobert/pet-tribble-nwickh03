package tribble.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static Connection connection;

    private ConnectionUtil() {
    }

    public static synchronized Connection getConnection() throws SQLException {
        Properties properties = getConnectionProperties();
        if (connection == null) {
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            connection = DriverManager.getConnection(url, username,password);

        }
        return connection;
    }

    public static Properties getConnectionProperties() {
        final Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/sql/db.prop")) {
            properties.load(fis);
            return properties;} catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}