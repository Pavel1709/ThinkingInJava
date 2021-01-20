class First {}
class Second extends First{}
class Third extends Second{}
class Last extends Third{
    public void recurs(Class c) {

        if(c.getSuperclass() != null) {
         System.out.println(c.getSuperclass().getSimpleName());
         recurs(c.getSuperclass());
        }
    }
    
    public static void main(String[] args) {
        Last l = new Last();
        Class s = l.getClass();
        l.recurs(s);
    }
    
}