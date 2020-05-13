package UI.DetailedView;

import UI.Factory.ButtonFactory;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class TableDetailedView {
    private VBox mainPane;
    private Button searchButton;
    private VBox fieldsPane;
    private TableView tableView;

    public TableDetailedView(TableView tableView) {
        mainPane = new VBox();
        setTable(tableView);
    }

    public TableDetailedView(String fields[]) {
        mainPane = new VBox();
        fieldsPane = new VBox();

        searchButton = ButtonFactory.searchButton();
        HBox searchPane = getNewFieldPane();
        searchPane.getChildren().add(searchButton);
        searchPane.setAlignment(Pos.CENTER);
        searchPane.setPadding(new Insets(10));

        for (int i=0; i<fields.length; i++)
            addField(fields[i]);
        mainPane.getChildren().add(fieldsPane);
        mainPane.getChildren().add(searchPane);
        config();
    }

    public ObservableList<Node> getFields() {
        return fieldsPane.getChildren();
    }

    public void setOnSearchButtonAction(TableDetailedViewSearchButtonPressedAction action) {
        searchButton.setOnAction(e -> {
            List<String> fieldsToString = new ArrayList<>();
            textFields.forEach((item) -> {
                System.out.println(item.getText());
                fieldsToString.add(item.getText());
            });
            action.performAction(fieldsToString);
        });
    }

    private List<TextField> textFields = new ArrayList<>();

    private void addField(String fieldName) {
        HBox fieldPane = getNewFieldPane();

        Label label = new Label(fieldName);
        TextField textField = new TextField();
        textFields.add(textField);
        fieldPane.getChildren().addAll(label,textField);

        this.fieldsPane.getChildren().add(fieldPane);
    }

    public void setTable(TableView tableView) {
        if(this.tableView != null)
            mainPane.getChildren().remove(this.tableView);
        mainPane.getChildren().add(tableView);
        this.tableView = tableView;
    }

    private HBox getNewFieldPane() {
        HBox hBox = new HBox(10);

        return hBox;
    }

    private void config() {
        fieldsPane.setSpacing(10);
        fieldsPane.setPadding(new Insets(10));
        fieldsPane.setAlignment(Pos.CENTER_LEFT);


    }

    public Pane getMainPane() {
        return mainPane;
    }
}
