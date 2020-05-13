package UI.Factory;


import UI.App;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;

public class ButtonFactory {
    public static Button menuButton() {
        Button button = new Button();

        button.setMinWidth(150);
        button.setPrefWidth(200);

        return button;
    }

    public static Button returnButton() {
        return new Button("Return");
    }

    public static Button searchButton() {return  new Button("Search"); }
}
