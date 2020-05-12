package UI;

import DataBase.DishMenu.DishMenuService;
import DataBase.DishMenu.Model.CaloriesInPortion;
import UI.Factory.ButtonFactory;
import UI.Factory.TableViewFactory;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {
    private Scene scene;
    private VBox vbox;

    private DishMenuService db;

    public MainWindow() {
        vbox = new VBox();
        scene = new Scene(vbox, AppProperties.INIT_WIDTH, AppProperties.INIT_HEIGHT);
        try {
            db = new DishMenuService();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        config();
    }

    private void config() {

        //Насктройка отображения
        vbox.setStyle("-fx-background-color: gray");
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(15);


        //Кнопка "Калорийность/порция"
        Button caloriesButton = ButtonFactory.menuButton();
        caloriesButton.setText("Калорийность/порция");
        vbox.getChildren().add(caloriesButton);
        caloriesButton.setOnAction(e -> {
            List<CaloriesInPortion> values = db.getCaloriesInPortion();
            TableView<CaloriesInPortion> table = TableViewFactory.caloriesInPortion(values);
            FlowPane root = new FlowPane(10, 10, table);
            vbox.getChildren().add(root);
        });


        //Кнопка "Состав блюд"
        Button dishCompositionButton = new ButtonFactory().menuButton();
        dishCompositionButton.setText("Состав блюд");
        vbox.getChildren().add(dishCompositionButton);

    }


    public Scene getScene() {
        return scene;
    }
}
