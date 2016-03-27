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
import by.iba.gomel.Record;
import by.iba.gomel.connectionDB.ConnectionDB2;
import by.iba.gomel.exceptions.ViewException;

/**
 * This logic class uses for searching record from db.
 */
public class SearchLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);

    public static List<Record> extract(final String searchPhrase, final String category)
            throws ViewException {
        Statement st = null;
        ResultSet rs = null;
        Connection cn = null;
        List<Record> listRecords = null;
        try {
            cn = ConnectionDB2.getConnection();
            listRecords = new ArrayList<Record>();
            st = cn.createStatement();
            final String getRecordsAll = Constants.REQUEST_DB_GET_RECORDS_ALL_COLUMNS_FIRST_PART
                    + searchPhrase.toLowerCase()
                    + Constants.REQUEST_DB_GET_RECORDS_ALL_COLUMNS_SECOND_PART
                    + searchPhrase.toLowerCase()
                    + Constants.REQUEST_DB_GET_RECORDS_ALL_COLUMNS_THIRD_PART
                    + searchPhrase.toLowerCase()
                    + Constants.REQUEST_DB_GET_RECORDS_ALL_COLUMNS_FOURTH_PART;
            final String getRecordsCertainColumn = Constants.REQUEST_DB_GET_RECORDS_CERTAIN_COLUMN_FIRST_PART
                    + category
                    + Constants.REQUEST_DB_GET_RECORDS_CERTAIN_COLUMN_SECOND_PART
                    + searchPhrase.toLowerCase()
                    + Constants.REQUEST_DB_GET_RECORDS_CERTAIN_COLUMN_THIRD_PART;
            if (category.equals(Constants.PARAMETER_ALL)) {
                rs = st.executeQuery(getRecordsAll);
            } else {
                rs = st.executeQuery(getRecordsCertainColumn);
            }
            while (rs.next()) {
                listRecords.add(new Record(rs.getInt(1), rs.getString(2), rs.getString(3), rs
                        .getString(4), rs.getDate(5), rs.getString(6), rs.getDate(7)));
            }
        } catch (final SQLException e) {
            SearchLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
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
        return listRecords;
    }

}
