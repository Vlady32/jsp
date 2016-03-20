package by.iba.gomel.connectionDB;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This class contains method getConnection that gets connection from Connection pool from
 * Websphere.
 */
public class ConnectionDB2 {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        InitialContext ctx = null;
        DataSource ds = null;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/JSP");
            connection = ds.getConnection();
        } catch (final NamingException e) {
            System.out.println("peformanceappraisalstatus: COULDN'T CREATE CONNECTION!");
            e.printStackTrace();
        }
        return connection;
    }

}
