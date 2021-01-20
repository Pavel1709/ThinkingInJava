//: typeinfo/PetCount4.java
import typeinfo.pets.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
    public class PetCount4 {
      public static void main(String[] args) {
       TypeCounter counter = new TypeCounter(Pet.class); 
       for(Pet pet : Pets.createArray(20)) {
        printnb(pet.getClass().getSimpleName() + " ");
        counter.count(pet); 
       }
       print();
       print(counter);
      }
} /* Output: (Sample)
EgyptianMau Gerbil Cymric EgyptianMau Cymric EgyptianMau Pug Rat Mutt Cymric Manx Manx Manx Cymric EgyptianMau Pug Hamster Cymric Gerbil Pug 
{Cat=12, Pet=20, EgyptianMau=4, Pug=3, Dog=4, Mutt=1, Rat=1, Cymric=5, Rodent=4, Hamster=1, Manx=8, Gerbil=2}
*///:~