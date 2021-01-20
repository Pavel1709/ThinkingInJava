public class EnumShow {
 public static void main(String[] args) {
  for(Money m : Money.values()) {
   System.out.print(m+ " " + m.ordinal() + " ") ;
   detail(m);
  } 
 }
 public static void detail(Money m) {
  switch(m) {
   case USD_DOLLAR : System.out.println("This is American currency(USD-United States Dollar). The official sign is $. The range of 1$ is 75 rubles");
   break;
   case EURO : System.out.println("This is European currency.  The official sign is €. The range of 1€ is 85 rubles");
   break;
   case POUND: System.out.println(" This is the UK currency. The official sign is £. The range of 1 £ is 95 rubles");
   break;
   case RUBLE: System.out.println("Everybody knows what it is");
   break;
  }
 }
}
enum Money {
 USD_DOLLAR,
 EURO,
 POUND,
 RUBLE,
}