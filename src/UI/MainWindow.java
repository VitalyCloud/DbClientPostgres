package UI;

import DataBase.DishMenu.DishMenuService;
import DataBase.DishMenu.Model.Base.Dish;
import DataBase.DishMenu.Model.CaloriesInPortion;
import DataBase.DishMenu.Model.DishComposition;
import UI.DetailedView.DetailedView;
import UI.DetailedView.ReturnButtonAction;
import UI.DetailedView.TableDetailedView;
import UI.Factory.ButtonFactory;
import UI.Factory.TableViewFactory;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class MainWindow implements ReturnButtonAction {
    private Scene scene;
    private VBox buttonsPane;
    private DetailedView detailedView;

    private BorderPane mainPane;

    private DishMenuService db;

    public MainWindow() {
        buttonsPane = new VBox();
        mainPane = new BorderPane();
        mainPane.setCenter(buttonsPane);
        scene = new Scene(mainPane, AppProperties.INIT_WIDTH, AppProperties.INIT_HEIGHT);
        try {
            db = new DishMenuService();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        //Whet return button pressed
        detailedView = new DetailedView(() -> {
            getMainPane().setCenter(buttonsPane);
        });
        config();
    }

    private void config() {

        //Насктройка отображения
        buttonsPane.setStyle("-fx-background-color: gray");
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setSpacing(15);


        //Кнопка "Калорийность/порция"
        Button caloriesButton = ButtonFactory.menuButton();
        caloriesButton.setText("Калорийность/порция");
        buttonsPane.getChildren().add(caloriesButton);
        caloriesButton.setOnAction(e -> {
            List<CaloriesInPortion> values = db.getCaloriesInPortion();
            TableView<CaloriesInPortion> table = TableViewFactory.caloriesInPortion(values);
            TableDetailedView tdView = new TableDetailedView(table);
            showDetailedView(tdView.getMainPane());
        });


        //Кнопка "Состав блюд"
        Button dishCompositionButton = new ButtonFactory().menuButton();
        dishCompositionButton.setText("Состав блюдa");
        buttonsPane.getChildren().add(dishCompositionButton);
        dishCompositionButton.setOnAction(e -> {
            String fields[] = {"Название блюда"};
            TableDetailedView tdView = new TableDetailedView(fields);
            tdView.setOnSearchButtonAction((fieldsResult)->{
                //Perform search
                if(!fieldsResult.get(0).isEmpty()) {
                    String name = fieldsResult.get(0);
                    List<DishComposition> values = db.getIngredients(name);
                    TableView<DishComposition> table = TableViewFactory.dishComposition(values);
                    tdView.setTable(table);
                }
            });
            showDetailedView(tdView.getMainPane());
        });

        //Кнопка Оборудование->Блюда
        Button stuffToDishes = new ButtonFactory().menuButton();
        stuffToDishes.setText("Оборудование->Блюда");
        buttonsPane.getChildren().add(stuffToDishes);
        stuffToDishes.setOnAction(e -> {
            String fields[] = {"Название оборудования"};
            TableDetailedView tdView = new TableDetailedView(fields);
            tdView.setOnSearchButtonAction((fieldsResult)->{
                //Perform search
                if(!fieldsResult.get(0).isEmpty()) {
                    String name = fieldsResult.get(0);
                    List<Dish> values = db.getDishesWithStuff(name);
                    TableView<Dish> table = TableViewFactory.dish(values);
                    tdView.setTable(table);
                }
            });
            showDetailedView(tdView.getMainPane());
        });

    }

    private BorderPane getMainPane() {return mainPane;}
    public Scene getScene() {
        return scene;
    }

    private void showDetailedView(Pane pane) {
        mainPane.setCenter(detailedView.getMainPane());
        detailedView.getMainPane().setCenter(pane);
    }

    @Override
    public void returnButtonPressed() {

    }
}
