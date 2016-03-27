package by.iba.gomel.logicDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.iba.gomel.Constants;
import by.iba.gomel.User;
import by.iba.gomel.connectionDB.ConnectionDB2;
import by.iba.gomel.exceptions.ViewException;

/**
 * This logic class uses for getting users from db.
 */
public class ControlLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);
    private static int          qualityUsers;

    public static List<User> extract(final int start) throws ViewException {
        Statement st = null;
        ResultSet rs = null;
        Connection cn = null;
        List<User> listUsers = null;
        try {
            cn = ConnectionDB2.getConnection();
            listUsers = new ArrayList<User>();
            st = cn.createStatement();
            final String requestGetAllUsers = Constants.REQUEST_DB_GET_ALL_USERS_FIRST_PART + start
                    + Constants.REQUEST_DB_GET_ALL_USERS_SECOND_PART;
            rs = st.executeQuery(Constants.REQUEST_DB_QUALITY_USERS);
            if (rs.next()) {
                ControlLogic.qualityUsers = rs.getInt(1);
            }
            rs.close();
            rs = st.executeQuery(requestGetAllUsers);
            while (rs.next()) {
                listUsers.add(new User(rs.getString(1), rs.getString(2)));
            }
        } catch (final SQLException e) {
            ControlLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
            throw new ViewException(e);
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
        return listUsers;
    }

    public static int getQualityUsers() {
        return ControlLogic.qualityUsers;
    }

}
