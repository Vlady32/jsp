package by.iba.gomel.logicdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.connectiondb.ConnectionDB2;

/**
 * This logic class uses for editing record in db.
 */
public class EditLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLogic.class);

    private EditLogic() {
        // private empty constructor.
    }

    /**
     * 
     * @param record
     *            record for editing.
     * @return result operation.
     */
    public static boolean editRecord(final Record record) {
        Statement st = null;
        PreparedStatement pr = null;
        Connection cn = null;
        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            pr = cn.prepareStatement(Constants.REQUEST_DB_EDIT_RECORD);
            pr.setString(Constants.INDEX_COLUMN_FULLNAME_SQL, record.getFullName());
            pr.setString(Constants.INDEX_COLUMN_ADDRESS_SQL, record.getAddress());
            pr.setString(Constants.INDEX_COLUMN_PHONE_NUMBER_SQL, record.getPhoneNumber());
            pr.setString(Constants.INDEX_COLUMN_MAIL_SQL, record.getMail());
            pr.setDate(Constants.INDEX_COLUMN_DATE_SQL, new java.sql.Date(record.getBirthDate()
                    .getTime()));
            pr.setString(Constants.INDEX_COLUMN_IMAGE_SQL, record.getPathFile());
            pr.setInt(Constants.INDEX_COLUMN_ITEM_SQL, record.getItem());
            pr.executeUpdate();
        } catch (final SQLException e) {
            EditLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
            return false;
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (final SQLException e) {
                    EditLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (final SQLException e) {
                    EditLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (pr != null) {
                try {
                    pr.close();
                } catch (final SQLException e) {
                    EditLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
        }
        return true;
    }
}
