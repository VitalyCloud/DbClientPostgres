package UI.DetailedView;

import UI.Factory.ButtonFactory;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class DetailedView {
    Button returnButton;
    BorderPane mainPane;

    public DetailedView(ReturnButtonAction caller) {

        mainPane = new BorderPane();

        //Top view
        returnButton = ButtonFactory.returnButton();
        HBox topHBox = new HBox(50);
        topHBox.setPadding(new Insets(10,10,10,10));
        topHBox.getChildren().add(returnButton);


        mainPane.setTop(topHBox);
        returnButton.setOnAction(e-> caller.returnButtonPressed());
    }



    public BorderPane getMainPane() {
        return mainPane;
    }
}
