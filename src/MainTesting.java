import DataBase.DishMenu.DishMenuService;

import java.sql.SQLException;

public class MainTesting {
    public static void main(String[] args) {
        DishMenuService dishMenuService;
        try {
            dishMenuService = new DishMenuService();
            Testing(dishMenuService);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void Testing(DishMenuService service) {
//        service.getDishTypes().forEach((type) -> System.out.println(type));
//        service.getIngredients().forEach((item) -> System.out.println(item));
//        service.getCompositions().forEach((item) -> System.out.println(item));
        service.getDishes().forEach((item) -> System.out.println(item));
//        service.getCaloriesInPortion().forEach((item) -> System.out.println(item));
//
//        service.getIngredients("Салат с сыром").forEach((item) -> System.out.println(item));

        service.getDishesWithStuff("нож").forEach((dish -> System.out.println(dish)));
    }
}
