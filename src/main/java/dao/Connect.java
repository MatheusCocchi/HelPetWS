package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    Connection con = null;

    public Connection createConnection()throws SQLException, InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/helpets_db?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(url, user, password);
    }

    public void closeConnection() throws SQLException {
        con.close();
    }
}