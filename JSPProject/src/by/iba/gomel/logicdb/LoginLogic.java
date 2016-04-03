package by.iba.gomel.logicdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.connectiondb.ConnectionDB2;

/**
 * This class contains method checkUser that to check login and password according to database.
 */
public class LoginLogic {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);

    private LoginLogic() {
        // empty private constructor.
    }

    /**
     * 
     * @param enterLogin
     *            login.
     * @param enterPassword
     *            password.
     * @return result operation.
     */
    public static String checkUser(final String enterLogin, final String enterPassword) {
        Statement st = null;
        ResultSet rs = null;
        Connection cn = null;
        String result = null;
        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            final String checkingRequest = Constants.REQUEST_DB_CHECK_USER_FIRST_PART + enterLogin
                    + Constants.REQUEST_DB_CHECK_USER_SECOND_PART + enterPassword
                    + Constants.REQUEST_DB_CHECK_USER_THIRD_PART;
            rs = st.executeQuery(checkingRequest);
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
                    LoginLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (final SQLException e) {
                    LoginLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (final SQLException e) {
                    LoginLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
        }
        return result;
    }
}
