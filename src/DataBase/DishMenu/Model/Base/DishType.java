package DataBase.DishMenu.Model.Base;

public class DishType {
    String type;

    public DishType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
