package DataBase;
import java.sql.*;
import java.sql.SQLException;

public class DataBaseManager {

    Connection db;
    Statement statement;

    public DataBaseManager(ConnectionURL connectionURL) throws SQLException {
        this.db = DriverManager.getConnection(connectionURL.getConnectionUrl());
        this.statement = this.db.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }
}
