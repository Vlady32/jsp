package by.iba.gomel.logicDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.connectionDB.ConnectionDB2;

/**
 * This logic class uses for deleting record from db.
 */
public class DeleteRecordLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLogic.class);

    public static boolean deleteRecord(final int item) {
        Statement st = null;
        PreparedStatement pr = null;
        Connection cn = null;
        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            pr = cn.prepareStatement(Constants.REQUEST_DB_DELETE_RECORD);
            pr.setInt(Constants.INDEX_COLUMN_FULLNAME_SQL, item);
            pr.executeUpdate();
        } catch (final SQLException e) {
            DeleteRecordLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
            return false;
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
        return true;
    }

}
