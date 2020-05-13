package DataBase.DishMenu.Model.Base;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Ingredient {
    SimpleIntegerProperty id;
    SimpleStringProperty name;
    SimpleStringProperty note;


    public Ingredient(int id, String name, String note) {
        setName(name);
        setNote(note);
        setId(id);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getNote() {
        return note.get();
    }

    public void setNote(String note) {
        this.note = new SimpleStringProperty(note);
    }
}
