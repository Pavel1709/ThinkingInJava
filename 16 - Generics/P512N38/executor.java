class Coffee {
 int gramsOfCoffee;
 public void set(int grams) {
  gramsOfCoffee = grams;
 }
 public int get() {
  return gramsOfCoffee;
 }
 public String toString() {
  return "There are "+ this.get() +" grams in " + this.getClass().getSimpleName();
 }
}
class Decorator extends Coffee {
 protected Coffee coffee;
 public Decorator() {}
 public Decorator(Coffee coffee) {
  this.coffee = coffee;
 }
 public void set(int grams) {
  coffee.set(grams);
 }
 public int get() {
  return coffee.get();
 }

}
class CoffeeWithSteamedMilk extends Decorator {
 String addition;
 public CoffeeWithSteamedMilk() {}
 public CoffeeWithSteamedMilk(Coffee coffee) {
  super(coffee);
  addition = "SteamedMilk";
 }
 public String getAddition() {
  return addition;
 }
}
class CoffeeWithFoam extends Decorator {
 String addition;
 public CoffeeWithFoam() {}
 public CoffeeWithFoam(Coffee coffee) {
  super(coffee);
  addition = "Foam";
 }
 public String getAddition() {
  return addition;
 }
}
class CoffeeWithChocolate extends Decorator {
 String addition;
 public CoffeeWithChocolate() {}
 public CoffeeWithChocolate(Coffee coffee) {
  super(coffee);
  addition = "Chocolate";
 }
 public String getAddition() {
  return addition;
 }
}
class CoffeeWithCaramel extends Decorator {
 String addition;
 public CoffeeWithCaramel() {}
 public CoffeeWithCaramel(Coffee coffee) {
  super(coffee);
  addition = "Caramel";
 }
 public String getAddition() {
  return addition;
 }
}
class CoffeeWithWhippedCream extends Decorator {
 String addition;
 public CoffeeWithWhippedCream() {}
 public CoffeeWithWhippedCream(Coffee coffee) {
  super(coffee);
  addition = "Whipped Cream";
 }
 public String getAddition() {
  return addition;
 }
}
public class executor {
 public static void main(String[] args) {
  Coffee  c1 = new Coffee ();
  c1.set(12);
  CoffeeWithSteamedMilk cwm = new CoffeeWithSteamedMilk(c1);
  Coffee  c2 = new Coffee ();
  c2.set(16);
  CoffeeWithFoam cvw = new CoffeeWithFoam(c2);
  Coffee  c3 = new Coffee ();
  c3.set(15);
  CoffeeWithChocolate cwco  = new CoffeeWithChocolate(c3);
  Coffee  c4 = new Coffee ();
  c4.set(14);
  CoffeeWithCaramel cwca = new CoffeeWithCaramel(c4);
  Coffee  c5 = new Coffee ();
  c5.set(12);
  CoffeeWithWhippedCream cwwc = new CoffeeWithWhippedCream(c5);
  System.out.println(cwm);
  System.out.println(cvw);
  System.out.println(cwco);
  System.out.println(cwca);
  System.out.println(cwwc);
 }
}
 