package by.iba.gomel.logicdb;

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
import by.iba.gomel.connectiondb.ConnectionDB2;
import by.iba.gomel.exceptions.ViewException;

/**
 * This logic class uses for searching record from db.
 */
public class SearchLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);

    private SearchLogic() {
        // empty private constructor.
    }

    /**
     * 
     * @param searchPhrase
     *            phrase for searching.
     * @param category
     *            category where will be searching.
     * @return list of records.
     * @throws ViewException
     *             view exception.
     */
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
                listRecords.add(new Record(rs.getInt(Constants.INDEX_COLUMN_ITEM_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_FULLNAME_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_ADDRESS_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_PHONE_NUMER_VIEW_SQL), rs
                        .getDate(Constants.INDEX_COLUMN_CREATION_DATE_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_MAIL_VIEW_SQL), rs
                        .getDate(Constants.INDEX_COLUMN_BIRTHDATE_VIEW_SQL), rs
                        .getString(Constants.INDEX_COLUMN_IMAGE_VIEW_SQL)));
            }
        } catch (final SQLException e) {
            SearchLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
            throw new ViewException(e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (final SQLException e) {
                    SearchLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (final SQLException e) {
                    SearchLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (final SQLException e) {
                    SearchLogic.LOGGER.error(Constants.EXCEPTION_SQL, e);
                }
            }
        }
        return listRecords;
    }

}
