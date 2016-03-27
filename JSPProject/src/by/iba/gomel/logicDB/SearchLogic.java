package by.iba.gomel.logicDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class SearchLogic {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogic.class);

    public static List<Record> extract(final String searchPhrase, final String category)
            throws ViewException {
        Statement st = null;
        ResultSet rs = null;
        Connection cn = null;
        PreparedStatement pr = null;
        List<Record> listRecords = null;
        try {
            cn = ConnectionDB2.getConnection();
            listRecords = new ArrayList<Record>();
            st = cn.createStatement();
            final String getRecordsAll = "SELECT \"item\",\"fullName\",\"address\",\"phoneNumber\",\"creationDate\",\"mail\",\"birthDate\"  FROM VLADY.\"PhoneBook\" WHERE LOWER(\"fullName\") LIKE '%?%' OR LOWER(\"address\") LIKE '%?%' OR LOWER(\"phoneNumber\") LIKE '%?%'";
            final String getRecords = "SELECT \"item\",\"fullName\",\"address\",\"phoneNumber\",\"creationDate\",\"mail\",\"birthDate\" FROM VLADY.\"PhoneBook\" WHERE LOWER(\"?\") LIKE '%?%'";
            if (category.equals("all")) {
                pr = cn.prepareStatement(getRecordsAll);
                pr.setString(1, searchPhrase.toLowerCase());
                pr.setString(2, searchPhrase.toLowerCase());
                pr.setString(3, searchPhrase.toLowerCase());
                rs = pr.executeQuery(getRecordsAll);
            } else {
                pr = cn.prepareStatement(getRecords);
                pr.setString(1, category);
                pr.setString(2, searchPhrase.toLowerCase());
                rs = pr.executeQuery(getRecords);
            }
            while (rs.next()) {
                listRecords.add(new Record(rs.getInt(1), rs.getString(2), rs.getString(3), rs
                        .getString(4), rs.getDate(5), rs.getString(6), rs.getDate(7)));
            }
        } catch (final SQLException e) {
            SearchLogic.LOGGER.info("ExceptionSearchLogic");
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
