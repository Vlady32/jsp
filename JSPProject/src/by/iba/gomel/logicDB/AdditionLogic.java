package by.iba.gomel.logicDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.Record;
import by.iba.gomel.connectionDB.ConnectionDB2;

/**
 * This logic class uses for adding record to db.
 */
public class AdditionLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLogic.class);

    public static boolean addRecord(final Record record) {
        Statement st = null;
        PreparedStatement pr = null;
        Connection cn = null;
        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            pr = cn.prepareStatement(Constants.REQUEST_DB_ADD_RECORD);
            pr.setString(Constants.INDEX_COLUMN_FULLNAME_SQL, record.getFullName());
            pr.setString(Constants.INDEX_COLUMN_ADDRESS_SQL, record.getAddress());
            pr.setString(Constants.INDEX_COLUMN_PHONE_NUMBER_SQL, record.getPhoneNumber());
            pr.setString(Constants.INDEX_COLUMN_MAIL_SQL, record.getMail());
            pr.setDate(Constants.INDEX_COLUMN_DATE_SQL, new java.sql.Date(record.getBirthDate()
                    .getTime()));
            pr.executeUpdate();
        } catch (final SQLException e) {
            AdditionLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
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
