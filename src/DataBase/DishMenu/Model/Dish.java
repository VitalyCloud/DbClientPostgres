package DataBase.DishMenu.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dish {
    int id;
    String name;
    DishType type;
    int totalWeight;
    int portionCount;
    String season;
    String stuff;
    int calories;
    String timeToCook;
    String recipe;

    public Dish(int id, String name, DishType type, int totalWeight,
                int portionCount, String season, String stuff,
                int calories, String timeToCook, String recipe) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.totalWeight = totalWeight;
        this.portionCount = portionCount;
        this.season = season;
        this.stuff = stuff;
        this.calories = calories;
        this.timeToCook = timeToCook;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", totalWeight=" + totalWeight +
                ", portionCount=" + portionCount +
                ", season='" + season + '\'' +
                ", stuff='" + stuff + '\'' +
                ", calories=" + calories +
                ", timeToCook='" + timeToCook + '\'' +
                ", recipe='" + recipe + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getPortionCount() {
        return portionCount;
    }

    public void setPortionCount(int portionCount) {
        this.portionCount = portionCount;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getStuff() {
        return stuff;
    }

    public void setStuff(String stuff) {
        this.stuff = stuff;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getTimeToCook() {
        return timeToCook;
    }

    public void setTimeToCook(String timeToCook) {
        this.timeToCook = timeToCook;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
