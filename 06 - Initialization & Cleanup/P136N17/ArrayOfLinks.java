public class ArrayOfLinks {
 static Elements element1;
 static Elements element2;
 static Elements element3;
 static Elements element4; //их смысл в том, что мы не должны заполнять массив объектами, поэтому я заранее создал ссылки, которыми заполнил массив. Ну можно сделать попроще, но разницы особо не вижу- создал AlternativeArrayOfLinks в той же папке.
 static Elements element5;
 public static void main( String ... args) {

  Elements[] elements = new Elements[]{
   element1,
   element2,
   element3,
   element4,
   element5,
  };
 }
}
class Elements {
 Elements(String s) {
  System.out.println(s);
 }
}