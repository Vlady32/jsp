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

public class EditLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationLogic.class);

    public static boolean editRecord(final Record record) {
        Statement st = null;
        PreparedStatement pr = null;
        Connection cn = null;
        try {
            cn = ConnectionDB2.getConnection();
            st = cn.createStatement();
            final String EDIT_RECORD = "UPDATE VLADY.\"PhoneBook\" SET \"fullName\"=?, \"address\"=?, \"phoneNumber\"=?, \"mail\"=?, \"birthDate\"=? WHERE VLADY.\"PhoneBook\".\"item\"=?";
            pr = cn.prepareStatement(EDIT_RECORD);
            pr.setString(1, record.getFullName());
            pr.setString(2, record.getAddress());
            pr.setString(3, record.getPhoneNumber());
            pr.setString(4, record.getMail());
            pr.setDate(5, new java.sql.Date(record.getBirthDate().getTime()));
            pr.setInt(6, record.getItem());
            pr.executeUpdate();
        } catch (final SQLException e) {
            EditLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
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
