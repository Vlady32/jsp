package by.iba.gomel.logicDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.connectionDB.ConnectionDB2;
import by.iba.gomel.exceptions.DuplicateLoginException;

/**
 * This logic class uses for registration user in db.
 */
public class RegistrationLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLogic.class);

    public static void AddToDB(final String userName, final String password, final String type)
            throws DuplicateLoginException {
        Statement st = null;
        PreparedStatement pr = null;
        Connection cn = null;

        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            pr = cn.prepareStatement(Constants.REQUEST_DB_REGISTRATION_USER);
            pr.setString(Constants.INDEX_COLUMN_FULLNAME_SQL, userName);
            pr.setString(Constants.INDEX_COLUMN_PASSWORD_SQL, password);
            pr.setString(Constants.INDEX_COLUMN_TYPE_USER_SQL, type);
            pr.executeUpdate();
        } catch (final SQLException e) {
            RegistrationLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
            throw new DuplicateLoginException(userName, e);
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
            if (pr != null) {
                try {
                    pr.close();
                } catch (final SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
