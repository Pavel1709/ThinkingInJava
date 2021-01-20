 
import java.util.*;

public enum Course36 {
 
    APPETIZER(Food36.Appetizer.class),
    MAINCOURSE(Food36.MainCourse.class),
    DESSERT(Food36.Dessert.class),
    COFFEE(Food36.Coffee.class);
 
    private static final Random rand=new Random();
    private Food36[] values;
    private Course36(Class<? extends Food36> kind) {
        values = kind.getEnumConstants();
    }
    public Food36 randomFood() {
        return values[rand.nextInt(values.length)];
    }
 
    public static Course36 randomType(){
        return values()[rand.nextInt(values().length)];
    }
    public static Food36 random(){
        return randomType().randomFood();
    }
    public static Food36 randomAppet(){
        return APPETIZER.randomFood();
    }
    public static Food36 randomMain(){
        return MAINCOURSE.randomFood();
    }
    public static Food36 randomDessert(){
        return DESSERT.randomFood();
    }
    public static Food36 randomCoffee(){
        return COFFEE.randomFood();
    }

    public static void main(String[] args){
        Food36 food=Course36.random();
        System.out.println(food);
    }
}