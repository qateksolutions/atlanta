package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class SqlConnector {
    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);
    private static final String Url = "jdbc:postgresql://localhost:5432/mortgage_calculator";
    private static final String User = "postgres";
    private static final String Password = "root";

    /**
     * Connect to the postgreSQL database
     * @return a Connection Object
     */
    private static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Url, User, Password);
            LOGGER.info("Connected to the PostgreSQL server successfully");
        } catch (SQLException e) {
            LOGGER.error("SQL Connection exception: " + e.getMessage());
        }

        return conn;
    }

    /**
     * Reading Data from the database
     * @param SQL is he method parameter to accept SQL Query
     * @return a ResultSet Object
     */
    public static ResultSet readData(String SQL) {
        ResultSet rs = null;
        try {
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);
        } catch (SQLException e) {
            LOGGER.error("SQL ResultSet exception: " + e.getMessage());
        }
        return rs;
    }

}
