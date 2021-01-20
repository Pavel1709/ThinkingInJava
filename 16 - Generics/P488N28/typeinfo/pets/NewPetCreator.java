package typeinfo.pets;
import java.util.*;
import inter.*;
public class NewPetCreator extends PetCreator {
 public String toString() {
  return getClass().getSimpleName();
 }
 static List<Factory<? extends Pet>> FactoryTypes = new ArrayList<Factory<? extends Pet>>();
 static {
  FactoryTypes.add(new Cat.Factory());
  FactoryTypes.add(new Cymric.Factory());
  FactoryTypes.add(new Dog.Factory());
  FactoryTypes.add(new EgyptianMau.Factory());
  FactoryTypes.add(new Hamster.Factory());
  FactoryTypes.add(new Manx.Factory());
  FactoryTypes.add(new Mouse.Factory());
  FactoryTypes.add(new Mutt.Factory());
  FactoryTypes.add(new Pug.Factory());
  FactoryTypes.add(new Rat.Factory());
  FactoryTypes.add(new Rodent.Factory());
  FactoryTypes.add(new Gerbil.Factory());
 }
  //List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
  public List<Class<? extends Pet>> types() { 
   //for(Factory<? extends Pet> f: FactoryTypes) {
    //types.add(f.newInstance());
   //}
    //return types;
    return null;
  }
 private static Random rand = new Random(47);
 public Pet randomPet()  {
  int n = rand.nextInt(FactoryTypes.size());
  Pet p;
  p = FactoryTypes.get(n).create();
  return p;
 }
 public Pet[] createArray(int size) {
   Pet[] result = new Pet[size];
   for(int i = 0; i < size; i++)
    result[i] = randomPet(); 
   return result;
  }
  public ArrayList<Pet> arrayList(int size) {
   ArrayList<Pet> result = new ArrayList<Pet>(); 
   Collections.addAll(result, createArray(size)); 
   return result;
  }

}