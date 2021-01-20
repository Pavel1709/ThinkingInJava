class First {
int l = 9;
 public String toString(){
  return ""+l;
 }
}
class Second extends First{
String s = "hi";
 public String toString(){
  return s;
 }
}
class Third extends Second{
float f = 9.99f;
 public String toString(){
  return "" + f;
 }
}
class Last extends Third{
boolean bul = true;
    public void recurs(Class c) {

        if(c.getSuperclass() != null) {
         System.out.println(c.getSuperclass().getSimpleName());
         for(Object cl : c.getDeclaredFields())
          System.out.println(cl.toString());
         recurs(c.getSuperclass());
        }
    }
    
    public static void main(String[] args) {
        Last l = new Last();
        Class s = l.getClass();
        l.recurs(s);
    }
    
}