import java.util.*;
public class HolderTest {
 public void MethOne(Holder<List<?>> h, Object o) {
  //h.set(o);
  // error: incompatible types: Object cannot be converted to List<?>
  //h.set(o);

  h.set(new ArrayList());
  Object ob = h.get();
  List<?> l = h.get();
  //l.add(o); //HolderTest.java:11: error: no suitable method found for add(Object)
 }
 public void MethTwo(List<Holder<?>> l, Object o) {
  //l.add(o);
  //error: no suitable method found for add(Object)
  

  Holder<?> h = new Holder<Object>();
  l.add(h);
  //l.get(0).set(o); //incompatible types: Object cannot be converted to CAP#1

  //Holder<Object> h1 = l.get(0).get(); //error: incompatible types: CAP#1 cannot be converted to Holder<Object>

  l.remove(o);
 }
 public static void main(String[] args) {
  HolderTest ht = new HolderTest();
  Holder raw = new Holder<ArrayList<Long>>();
  Holder<List<?>> qualified = new Holder< List<?>>();
  Holder<?> unbounded = new Holder<ArrayList<Long>>();
  Holder<? extends ArrayList<Long>> bounded = new Holder<ArrayList<Long>>();
  Long lng = 1L;
  //ht.MethOne(raw , lng); //error: method MethOne in class HolderTest cannot be applied to given types;

   ht.MethOne(qualified, lng); 
  //ht.MethOne(unbounded, lng); // error: method MethOne in class HolderTest cannot be applied to given types;

  // ht.MethOne(bounded, lng); error: method MethOne in class HolderTest cannot be applied to given types;

  //List<Holder> list1 = new ArrayList<Holder<Long>>();  //error: incompatible types: ArrayList<Holder<Long>> cannot be converted to List<Holder>
  List<Holder<Long>> list2 = new ArrayList<Holder<Long>>();
  //List<Holder<?>> list3 = new ArrayList<Holder<Long>>(); //error: incompatible types: ArrayList<Holder<Long>> cannot be converted to List<Holder<?>>
  //List<Holder<? extends Long>> list4 = new ArrayList<Holder<Long>>(); //incompatible types: ArrayList<Holder<Long>> cannot be converted to List<Holder<? extends Long>>
  //List<Holder<? super Long>> list6 = new ArrayList<Holder<Long>>();  //error: incompatible types: ArrayList<Holder<Long>> cannot be converted to List<Holder<? super Long>>
  List<?> list5 = new ArrayList<Holder<Long>>();
  List<? extends Holder<? extends Long>> list6 = new ArrayList<Holder<Long>>();
  List<Holder<?>> list = new ArrayList<Holder<?>>();
  //ht.MethTwo(list1, lng );
   ht.MethTwo(list , lng);
  //ht.MethTwo(list3, lng);
  //ht.MethTwo(list4, lng);
  //ht.MethTwo(list5, lng);
  //ht.MethTwo(list6, lng); //error: method MethTwo in class HolderTest cannot be applied to given types;
  //required: List<Holder<?>>,Object
  //found: List<CAP#1>
 }
}