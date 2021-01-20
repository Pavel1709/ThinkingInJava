public class EnumShow {
 public static void main(String[] args) {
  for(Money m : Money.values()) {
   System.out.println(m+ " " + m.ordinal()) ;
  } 
 }
}
enum Money {
 ONE_DOLLAR,
 TWO_DOLLARS,
 FIVE_DOLLARS,
 TEN_DOLLARS,
 FIFTY_DOLLARS,
 ONE_HUNDRED_DOLLARS,
}