package db;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {

        try {
            String url = "jdbc:mysql://localhost:3306/coursejdbc?user=root&password=1234567";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());

            }
        }
    }
    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }
}
