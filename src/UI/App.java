package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        stage.setTitle(AppProperties.APP_NAME);
        MainWindow mainWindow = new MainWindow();
        Scene mainScene = mainWindow.getScene();
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
