package DataBase.DishMenu.Model.Base;

public class Composition {
    int dish;
    int ingredient;
    int count;
    String unitType;

    public Composition(int dish, int ingredient, int count, String unitType) {
        this.dish = dish;
        this.ingredient = ingredient;
        this.count = count;
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "dish=" + dish +
                ", ingredient=" + ingredient +
                ", count=" + count +
                ", unitType='" + unitType + '\'' +
                '}';
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
        this.dish = dish;
    }

    public int getIngredient() {
        return ingredient;
    }

    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
