package DataBase.DishMenu.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CaloriesInPortion {
    SimpleStringProperty dishName;
    SimpleIntegerProperty weight;
    SimpleIntegerProperty calories;

    public CaloriesInPortion(String dishName, int weight, int calories) {
        this.dishName = new SimpleStringProperty(dishName);
        this.weight = new SimpleIntegerProperty(weight);
        this.calories = new SimpleIntegerProperty(calories);
    }

    @Override
    public String toString() {
        return "CaloriesInPortion{" +
                "dishName='" + dishName + '\'' +
                ", weight=" + weight +
                ", calories=" + calories +
                '}';
    }

    public String getDishName() {
        return dishName.get();
    }

    public SimpleStringProperty dishNameProperty() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName.set(dishName);
    }

    public int getWeight() {
        return weight.get();
    }

    public SimpleIntegerProperty weightProperty() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight.set(weight);
    }

    public int getCalories() {
        return calories.get();
    }

    public SimpleIntegerProperty caloriesProperty() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories.set(calories);
    }
}
