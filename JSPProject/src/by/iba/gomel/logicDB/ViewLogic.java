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
 * This class contains method extract that extracts data from database.
 */
public class ViewLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);
    private static int          qualityRecords;
    private static List<Record> listRecords;

    /**
     * 
     * @param start
     *            position.
     * @return list of records.
     * @throws ViewException
     *             exception database.
     */
    public static List<Record> extract(final int start) throws ViewException {
        Statement st = null;
        ResultSet rs = null;
        Connection cn = null;
        List<Record> listRecords = null;
        try {
            cn = ConnectionDB2.getConnection();
            listRecords = new ArrayList<Record>();
            st = cn.createStatement();
            final String getAllRecordsRequest = Constants.REQUEST_DB_GET_ALL_RECORDS_FIRST_PART
                    + start + Constants.REQUEST_DB_GET_ALL_RECORDS_SECOND_PART;
            final String qualityRequest = Constants.REQUEST_DB_QUALITY_RECORDS;
            rs = st.executeQuery(qualityRequest);
            if (rs.next()) {
                ViewLogic.qualityRecords = rs.getInt(Constants.INDEX_COLUMN_FULLNAME_SQL);
            }
            rs.close();
            rs = st.executeQuery(getAllRecordsRequest);
            while (rs.next()) {
                listRecords.add(new Record(rs.getInt(Constants.INDEX_COLUMN_ITEM_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_FULLNAME_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_ADDRESS_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_PHONE_NUMER_VIEW_SQL), rs
                        .getDate(Constants.INDEX_COLUMN_CREATION_DATE_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_MAIL_VIEW_SQL), rs
                        .getDate(Constants.INDEX_COLUMN_BIRTHDATE_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_IMAGE_VIEW_SQL)));
            }
            Record.setListRecords(listRecords);
        } catch (final SQLException e) {
            ViewLogic.LOGGER.info("ExceptionViewLogic");
            ViewLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
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

    public static int getQualityRecords() {
        return ViewLogic.qualityRecords;
    }

    public static List<Record> getListRecords() {
        return ViewLogic.listRecords;
    }

    public static void setListRecords(final List<Record> listRecords) {
        ViewLogic.listRecords = listRecords;
    }
}
