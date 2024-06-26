package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTemplate {

    public static Connection getConn() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "C##FINAL";
        String pwd = "1234";
        Connection conn = DriverManager.getConnection(url, id, pwd);
//        conn.setAutoCommit(false);
        return conn;
    }

}
