interface U {
 void U1();
 void U2();
 void U3();
 String getName();
 void setName(String name);
}
class A {
 U creator(String nam ) {
  return new U() {
   String name;
   public void setName(String name) {
    this.name = name;
   }
   public String getName() {
    return name;
   } 
   public void U1() {
    System.out.println("method U1");
   }
   public void U2() {
    System.out.println("method U2");
   }
   public void U3() {
    System.out.println("method U3");
   }
   {
    setName(nam );
   }
  };
 }
}
public class B {
 int i = 0;
 U[] arr = new U[3];
 void add(U[] array, U u) {
  array[i] = u;
  i++;
 }
 void toMas(U u) {
  add(arr , u);
 }
 void toNull(U u) {
  for (int i = 0; i< arr.length; i++) {
   if (arr[i] == u)
    arr[i] = null;
  }
 }
 void perebor() {
  for (U u: arr) {
   if (u != null) {
    System.out.println(u.getName());
    u.U1();
    u.U2();
    u.U3();
   }
  }
 }
 public static void main(String[] args) {
  A a1 = new A();
  A a3 = new A();
  A a2 = new A();
  B b = new B();
  U u1 = a1.creator("u1");
  U u2 = a2.creator("u2");
  U u3 = a3.creator("u3");
  b.toMas(u1);
  b.toMas(u2);
  b.toMas(u3);
  b.perebor();
  b.toNull(u2);
  b.perebor();
 }
}
  
  

 
