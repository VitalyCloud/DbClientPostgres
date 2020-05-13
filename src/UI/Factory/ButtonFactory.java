package UI.Factory;


import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;

public class ButtonFactory {
    public static Button menuButton() {
        Button button = new Button();
//        button.setStyle(
//                        "-fx-background-color: white;" +
//                        "-fx-border-width: 2;" +
//                        "-fx-background-radius: 5;" +
//                        "-fx-border-color: black;" +
//                        "-fx-border-radius: 5;" +
//                        "-fx-min-width: 150");

        button.setMinWidth(150);

        return button;
    }

    public static Button returnButton() {
        return new Button("Return");
    }

    public static Button searchButton() {return  new Button("Search"); }
}
