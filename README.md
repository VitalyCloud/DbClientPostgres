# DbClientPostgres

Позволяет просматривать базу данных Рецептов блюд
- Калорийность одной порции
- Состав блюда
- Поиск блюд, для которых необходимо определенное оборудование

### Таблицы

```sql
create table Ingredients (
        id NUMERIC(6) PRIMARY KEY,
        name CHAR(50) NOT NULL,
        info CHAR(200)
    );
    

create table DishTypes (
        type CHAR(25) PRIMARY KEY 
    );
    

create table Dish (
        id NUMERIC(6) PRIMARY KEY,
        name CHAR(50) NOT NULL,
        type CHAR(25) references DishTypes(type), --  ref
        totalWeight NUMERIC(5,2) NOT NULL,
        counts NUMERIC(2) DEFAULT 1,
        season CHAR(20),
        stuff CHAR(50),
        calories NUMERIC(4),
        makingTime TIME NOT NULL,
        recept CHAR(255) NOT NULL
    );
    

create table Composition (
        dish NUMERIC(6)  REFERENCES Dish(id), -- ref
        ingredient NUMERIC(6) REFERENCES Ingredients(id), -- ref 
        count NUMERIC(6),
        unitType CHAR(50) /*единицы измеррения*/
    );
```
    
В работе использовалось представление:
```sql
create view CaloriesInPortion as
select Dish.name, 
case Dish.totalWeight
when NULL then 100 else Dish.totalWeight/Dish.counts END weight,
case Dish.calories
when Dish.counts=1 then Dish.calories else Dish.calories/Dish.counts END calories
from Dish;
```

### Запросы, которые были отправлены из кода:
```Java

//Калорийность одной порции
String sqlQuery = "select * from CaloriesInPortion";

//Состав блюда
String sqlQuery =
                "select Ingredients.name, Ingredients.info, Composition.count, Composition.unitType " +
                "from Composition " +
                "INNER JOIN Ingredients on Ingredients.id = Composition.ingredient and " +
                "Composition.dish = (select Dish.id from Dish where Dish.name = '"+ dishName +"');";

//Поиск блюд, для которых необходимо определенное оборудование
String sqlQuery = "select * from dish where stuff like '%"+stuffToSearch+"%'";
```
Подробнее в классе DishMenuService.java (DataBase/DishMenu/)

## Скриншоты

### Таблицы базы данных
Dish

![Dish](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/DishTable.png)


DishTypes

![DishTypes](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/DishTypesTable.png)

Ingredients

![Ingredients](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/IngredientsTable.png)

Composition

![Composition](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/CompositionTable.png)

### Приложение 

Главный экран

![Главный экран](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/MainWindow.png)

Калории/порция

![Калории/порция](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/CaloriesInPortion.png)

Состав блюда

![Состав блюда](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/DishCompositionCesar.png)

Оборудование->Блюда

![Оборудование->Блюда](https://github.com/VitalyCloud/DbClientPostgres/blob/master/Screenshots/StuffToDish.png)

