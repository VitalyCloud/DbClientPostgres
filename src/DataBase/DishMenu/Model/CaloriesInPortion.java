package DataBase.DishMenu.Model;

public class CaloriesInPortion {
    String dishName;
    int weight;
    int calories;

    public CaloriesInPortion(String dishName, int weight, int calories) {
        this.dishName = dishName;
        this.weight = weight;
        this.calories = calories;
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
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
