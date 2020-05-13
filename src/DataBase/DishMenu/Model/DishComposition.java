package DataBase.DishMenu.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DishComposition {

    SimpleStringProperty ingredientName;
    SimpleStringProperty info;
    SimpleIntegerProperty count;
    SimpleStringProperty unitType;

    public DishComposition(String ingredientName, String info, int count, String unitType) {
        setIngredientName(ingredientName);
        setInfo(info);
        setCount(count);
        setUnitType(unitType);
    }

    @Override
    public String toString() {
        return "DishComposition{" +
                "ingredientName=" + ingredientName +
                ", info=" + info +
                ", count=" + count +
                ", unitType=" + unitType +
                '}';
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = new SimpleStringProperty(ingredientName);
    }

    public void setInfo(String info) {
        this.info = new SimpleStringProperty(info);
    }

    public void setCount(int count) {
        this.count = new SimpleIntegerProperty(count);
    }

    public void setUnitType(String unitType) {
        this.unitType = new SimpleStringProperty(unitType);
    }

    public String getIngredientName() {
        return ingredientName.get();
    }

    public String getInfo() {
        return info.get();
    }


    public int getCount() {
        return count.get();
    }

    public String getUnitType() {
        return unitType.get();
    }

}
