package by.iba.gomel.logicdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.connectiondb.ConnectionDB2;

/**
 * This logic class uses for deleting user from db.
 */
public class DeleteUserLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLogic.class);

    private DeleteUserLogic() {
        // private empty constructor.
    }

    /**
     * 
     * @param userName
     *            name for deleting.
     * @return result operation.
     */
    public static boolean deleteUser(final String userName) {
        Statement st = null;
        PreparedStatement pr = null;
        Connection cn = null;
        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            pr = cn.prepareStatement(Constants.REQUEST_DB_DELETE_USER);
            pr.setString(Constants.INDEX_COLUMN_FULLNAME_SQL, userName);
            pr.executeUpdate();
        } catch (final SQLException e) {
            DeleteUserLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (final SQLException e) {
                    DeleteUserLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (final SQLException e) {
                    DeleteUserLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (pr != null) {
                try {
                    pr.close();
                } catch (final SQLException e) {
                    DeleteUserLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
        }
        return true;
    }
}
