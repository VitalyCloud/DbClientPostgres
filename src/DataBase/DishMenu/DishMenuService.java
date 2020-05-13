package DataBase.DishMenu;

import DataBase.DataBaseManager;
import DataBase.DishMenu.Model.*;
import DataBase.DishMenu.Model.Base.Composition;
import DataBase.DishMenu.Model.Base.Dish;
import DataBase.DishMenu.Model.Base.DishType;
import DataBase.DishMenu.Model.Base.Ingredient;
import DataBase.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishMenuService {
    DataBaseManager db;

    //Get tables methods

    public DishMenuService() throws SQLException {
        db =  new DataBaseManager(new DishMenuConnectionURL());
    }

    public List<DishType> getDishTypes() {
        List<DishType> dishTypes = new ArrayList<>();

        executeSelect("select * from dishtypes", (result) -> {
            try {
                String type = result.getString(1);
                dishTypes.add(new DishType(
                        parseString(type)
                ));
            } catch (SQLException throwables) {}
        });

        return dishTypes;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();

        executeSelect("select * from ingredients where", (result) -> {
            try {
                int id = result.getInt(1);
                String name = result.getString(2);
                String note = result.getString(3);
                ingredients.add(new Ingredient(
                        id,
                        parseString(name),
                        parseString(note)));
            } catch (SQLException throwables) {}
        });

        return ingredients;
    }


    public List<Composition> getCompositions() {
        List<Composition> compositions = new ArrayList<>();
        executeSelect("select * from composition", (result)-> {
            try {
                int dish = result.getInt(1);
                int ingredient = result.getInt(2);
                int count = result.getInt(3);
                String unitType = result.getString(4);
                compositions.add(new Composition(
                        dish,
                        ingredient,
                        count,
                        parseString(unitType)));
            }catch (SQLException ex) {}
        });
        return compositions;
    }

    public List<Dish> getDishes() {

        List<Dish> dishes = new ArrayList<>();
        executeSelect("select * from dish", (result) -> {
            try {
                int id = result.getInt(1);
                String name = result.getString(2);
                String typeString = result.getString(3);
                double totalWeight = result.getDouble(4);
                int portionCount = result.getInt(5);
                String season = result.getString(6);
                String stuff = result.getString(7);
                int calories = result.getInt(8);
                String timeToCook = result.getString(9);
                String recipe = result.getString(10);

                DishType type = new DishType(parseString(typeString));
                Dish dish = new Dish(
                        id,
                        parseString(name),
                        type,
                        totalWeight, portionCount,
                        parseString(season),
                        parseString(stuff),
                        calories,
                        parseString(timeToCook),
                        parseString(recipe)
                );
                dishes.add(dish);
            }catch (SQLException ex) {}
        });
        return dishes;
    }

    public List<CaloriesInPortion> getCaloriesInPortion() {
        List<CaloriesInPortion> resultList = new ArrayList<>();
        String sqlQuery = "select * from CaloriesInPortion";
        executeSelect(sqlQuery, (result) -> {
            try {
                String name = result.getString(1);
                int weight = result.getInt(2);
                int calories = result.getInt(3);
                resultList.add(new CaloriesInPortion(
                        parseString(name),
                        weight,
                        calories
                ));
            } catch (SQLException ex) {}
        });
        return resultList;
    }

    public List<DishComposition> getIngredients(String dishName) {
        String sqlQuery =
                "select Ingredients.name, Ingredients.info, Composition.count, Composition.unitType " +
                "from Composition " +
                "INNER JOIN Ingredients on Ingredients.id = Composition.ingredient and " +
                "Composition.dish = (select Dish.id from Dish where Dish.name = '"+ dishName +"');";

        List<DishComposition> resultList = new ArrayList<>();
        executeSelect(sqlQuery, (result) -> {
            try {
                String name = result.getString(1);
                String info = result.getString(2);
                int count = result.getInt(3);
                String unitType =  result.getString(4);

                resultList.add(new DishComposition(
                        parseString(name),
                        parseString(info),
                        count,
                        parseString(unitType)
                ));
            } catch (SQLException ex) {}
        });
        return resultList;
    }

    public List<Dish> getDishesWithStuff(String stuffToSearch) {
        String sqlQuery = "select * from dish where stuff like '%"+stuffToSearch+"%'";
        List<Dish> dishes = new ArrayList<>();
        executeSelect(sqlQuery, (result) -> {
            try {
                int id = result.getInt(1);
                String name = result.getString(2);
                String typeString = result.getString(3);
                double totalWeight = result.getDouble(4);
                int portionCount = result.getInt(5);
                String season = result.getString(6);
                String stuff = result.getString(7);
                int calories = result.getInt(8);
                String timeToCook = result.getString(9);
                String recipe = result.getString(10);

                DishType type = new DishType(parseString(typeString));
                Dish dish = new Dish(
                        id,
                        parseString(name),
                        type,
                        totalWeight, portionCount,
                        parseString(season),
                        parseString(stuff),
                        calories,
                        parseString(timeToCook),
                        parseString(recipe)
                );
                dishes.add(dish);
            }catch (SQLException ex) {}
        });
        return dishes;
    }

    //Helper Classes

    private String parseString(String str) {
        return str == null ? "null" : str.strip();
    }

    private void executeSelect(String query, ResultHandler handler) {
        ResultSet resultSet;
        try {
            resultSet = db.getStatement().executeQuery(query);
            while(resultSet.next()) {
                handler.handle(resultSet);
            }
        } catch (SQLException ex){}
    }
}
