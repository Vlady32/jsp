package by.iba.gomel.logicDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.connectionDB.ConnectionDB2;

/**
 * This class contains method checkUser that to check login and password according to database.
 */
public class LoginLogic {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);

    public static String checkUser(final String enterLogin, final String enterPassword) {
        Statement st = null;
        ResultSet rs = null;
        Connection cn = null;
        String result = null;

        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            final String request = "SELECT \"Type\" FROM VLADY.\"Users\" WHERE  \"UserName\"='"
                    + enterLogin + "' AND \"Password\"='" + enterPassword + "'";
            rs = st.executeQuery(request);

            if (rs.next()) {
                result = rs.getString(Constants.INDEX_COLUMN_TYPE_SQL);
            }

        } catch (final SQLException e) {
            LoginLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
