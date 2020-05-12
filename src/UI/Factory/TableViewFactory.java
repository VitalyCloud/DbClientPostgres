package UI.Factory;

import DataBase.DishMenu.Model.CaloriesInPortion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class TableViewFactory  {

    public static TableView<CaloriesInPortion> caloriesInPortion(List<CaloriesInPortion> values) {
        DBTableView<CaloriesInPortion> tableView = new DBTableView<>(values);
        tableView.addColumns(
                new DBTableColumn<CaloriesInPortion, String>("Блюдо", "dishName"),
                new DBTableColumn<CaloriesInPortion, Integer>("Вес", "weight"),
                new DBTableColumn<CaloriesInPortion, Integer>("Калории", "calories"));

        return tableView;
    }



    //Helper Classes

    static class DBTableColumn<TableType, ColumnType> extends TableColumn<TableType, ColumnType> {
        public DBTableColumn(String columnName, String columnBind) {
            super(columnName);
            setCellValueFactory(new PropertyValueFactory<TableType, ColumnType>(columnBind));
        }
    }

    static class DBTableView<TableType> extends TableView<TableType> {
        public DBTableView(List<TableType> items) {
            super();
            setItems(getObservable(items));
        }

        public void addColumns(DBTableColumn... column) {
            getColumns().addAll(column);
        }

        private ObservableList<TableType> getObservable(List<TableType> items) {
            return FXCollections.observableArrayList(items);
        }
    }

    // ---------------

}
