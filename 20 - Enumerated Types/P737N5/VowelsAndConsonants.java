//: control/VowelsAndConsonants.java
// Demonstrates the switch statement.
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;
public enum VowelsAndConsonants { 
 
  VOWEL(Letter.Vowel.class),
  SOMETIMES_A_VOWEL(Letter.Sometimes_A_Vowel.class),
  CONSONANT(Letter.Consonant.class);
  private Letter[] values;

  private VowelsAndConsonants(Class<? extends Letter> kind) {
   values = kind.getEnumConstants();
  }
  interface Letter{
   enum Vowel implements Letter {
    a, e, i, u, o;
   }
   enum Sometimes_A_Vowel implements Letter {
    y, w;
   }
   enum Consonant implements Letter {
    q, w, r, t , p, s, d , f , g ,h , j , k, l, z, x, c, v, b, n, m; 
   }
  }
   public Letter randomSelection() {
    return Enums.random(values);
   }


  
   public static void main(String[] args) {
   VowelsAndConsonants v  ;

    for(int i = 0; i < 100; i++) {
      for (VowelsAndConsonants vaw: VowelsAndConsonants.values()) {
        Letter c = vaw.randomSelection();
        if (c.getClass().getSimpleName().equals("Vowel"))  {
          print(c + " vowel");
        }
        else if (c.getClass().getSimpleName().equals("Sometimes_A_Vowel")) {
          print(c + " Sometimes a vowel");
        }
        else  {
           print(c + " consonant");
        }
         
    }
   }
} 
}
