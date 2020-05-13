package UI.Factory;

import DataBase.DishMenu.Model.Base.Dish;
import DataBase.DishMenu.Model.CaloriesInPortion;
import DataBase.DishMenu.Model.DishComposition;
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

    public static TableView<Dish> dish(List<Dish> values) {
        DBTableView<Dish> tableView = new DBTableView<>(values);
        tableView.addColumns(
                new DBTableColumn<Dish, Integer>("id", "id"),
                new DBTableColumn<Dish, String>("Блюдо", "Name"),
                new DBTableColumn<Dish, String>("Тип", "type"),
                new DBTableColumn<Dish, Double>("Вес", "totalWeight"),
                new DBTableColumn<Dish, Integer>("Порций", "portionCount"),
                new DBTableColumn<Dish, String>("Сезон", "season"),
                new DBTableColumn<Dish, String>("Оборудование", "stuff"),
                new DBTableColumn<Dish, Integer>("Калории", "calories"),
                new DBTableColumn<Dish, String>("Время приготовления", "timeToCook"),
                new DBTableColumn<Dish, String>("Рецепт", "recipe")
        );

        return tableView;
    }

    public static TableView<DishComposition> dishComposition(List<DishComposition> values) {
        DBTableView<DishComposition> tableView = new DBTableView<>(values);
        tableView.addColumns(
                new DBTableColumn<DishComposition, String>("Ингредиент", "ingredientName"),
                new DBTableColumn<DishComposition, String>("Инфо", "info"),
                new DBTableColumn<DishComposition, String>("Количество", "count"),
                new DBTableColumn<DishComposition, String>("Ед. измерения", "unitType")
        );
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
