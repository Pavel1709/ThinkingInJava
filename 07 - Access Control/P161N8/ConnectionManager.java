class Connection {
  private Connection() {
   //System.out.println("Поздравляем, новый объект создан");
  }
  static Connection[] makeConnectionAr() {
   return new Connection[10];
  }
  private static Connection c = new Connection();
  static Connection makeConnection() {
   return c;
  }
}
public class ConnectionManager {
  static int i = -1;
  static Connection[] l = Connection.makeConnectionAr();
 static Connection Manipulator() {
    while ( i < l.length-1) {
    i++;
   l[i] = Connection.makeConnection();
      return l[i];
      
  }
  
  return null;
 }
 public static void main(String[] args) {
  int j = i;
  while (j < l.length) {
  System.out.println(Manipulator());
  j++;
  }
 }
}
  
  