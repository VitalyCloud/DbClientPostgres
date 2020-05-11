package DataBase.DishMenu;

import DataBase.ConnectionURL;

public class DishMenuConnectionURL implements ConnectionURL {

    private final String DB_NAME = "DishMenu";

    String connectionURL;

    public DishMenuConnectionURL() {
        connectionURL = "jdbc:postgresql://localhost/" + DB_NAME;
    }

    @Override
    public String getConnectionUrl() {
        return connectionURL;
    }
}
