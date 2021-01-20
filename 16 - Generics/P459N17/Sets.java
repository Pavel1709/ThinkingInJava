//: net/mindview/util/Sets.java 
package net.mindview.util; 
import java.util.*;
import java.lang.reflect.*;
public class Sets {
 public static <T extends Enum<T>> Set<T> union(Set<T> a, Set<T> b) throws InstantiationException, IllegalAccessException {
     if(a.getClass().getSimpleName().contains("EnumSet")) {
     Class aa = a.getClass() ;
     Class bb = b.getClass();
     EnumSet<T> aaa=EnumSet.allOf(aa);
     EnumSet<T> bbb=EnumSet.allOf(bb);
    
     EnumSet<T> result = aaa.clone();
     result.addAll(bbb);
     return result;
    }
  Set<T> result = new HashSet<T>(a); 
  result.addAll(b);
  return result;
 }
 public static <T extends Enum<T>> Set<T> intersection(Set<T> a, Set<T> b) {
     if(a.getClass().getSimpleName().contains("EnumSet")) {
     Class aa = a.getClass() ;
     Class bb = b.getClass();
     EnumSet<T> aaa=EnumSet.allOf(aa);
     EnumSet<T> bbb=EnumSet.allOf(bb);

     EnumSet<T> result = aaa.clone();
     result.retainAll(bbb);
     return result;
    }
  Set<T> result = new HashSet<T>(a); 
  result.retainAll(b);
  return result;
 }
 // Subtract subset from superset:
 public static <T extends Enum<T>> Set<T> difference(Set<T> superset, Set<T> subset) {
     if(superset.getClass().getSimpleName().contains("EnumSet")) {
     Class aa = superset.getClass() ;
     Class bb = subset.getClass();
     EnumSet<T> aaa=EnumSet.allOf(aa);
     EnumSet<T> bbb=EnumSet.allOf(bb);
    
     EnumSet<T> result = aaa.clone();
     result.removeAll(bbb);
     return result;
    }
  Set<T> result = new HashSet<T>(superset); 
  result.removeAll(subset);
  return result;
 }
 // Reflexive--everything not in the intersection:
 public static <T extends Enum<T>> Set<T> complement( Set<T> a,  Set<T> b) throws InstantiationException, IllegalAccessException {
  return difference(union(a, b), intersection(a, b)); 
 }
 private enum Watercolors {
        ZINC, LEMON_YELLOW, MEDIUM_YELLOW, DEEP_YELLOW, ORANGE,
        BRILLIANT_RED, CRIMSON, MAGENTA, ROSE_MADDER, VIOLET,
        CERULEAN_BLUE_HUE, PHTHALO_BLUE, ULTRAMARINE,
        COBALT_BLUE_HUE, PERMANENT_GREEN, VIRIDIAN_HUE,
        SAP_GREEN, YELLOW_OCHRE, BURNT_SIENNA, RAW_UMBER,
        BURNT_UMBER, PAYNES_GRAY, IVORY_BLACK
    }
 public static void main(String[] args) throws InstantiationException, IllegalAccessException {

         Set<Watercolors> set1 =   EnumSet.range(Watercolors.BRILLIANT_RED, Watercolors.VIRIDIAN_HUE);
         Set<Watercolors> set2 =   EnumSet.range(Watercolors.CERULEAN_BLUE_HUE, Watercolors.BURNT_UMBER);
        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        System.out.println("union(set1, set2): " + Sets.union(set1, set2));
         Set<Watercolors> subset = Sets.intersection(set1, set2);
        System.out.println("intersection(set1, set2): " + subset);
        System.out.println("difference(set1, subset): " + Sets.difference(set1, subset));
        System.out.println("difference(set2, subset): " + Sets.difference(set2, subset));
        System.out.println("complement(set1, set2): " + Sets.complement(set1, set2));
    }
}
//не работает, не знаю, как сделать так, чтобы в качестве аргумента передавался именно enum. Запутался, потратил около двух часов, возможности решать дальше нет.