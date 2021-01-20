import java.util.*;
 
/**
 *
 * @author pavel1709
 */
public class JavaApplication66 {
  static String sent;
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        for(String s: args) {
             str.append(s);
        }
        sent = str.toString();
        List<String> simvoli = new ArrayList<String>();   
        simvoli.addAll(Arrays.asList(sent.split("")));
        System.out.println((simvoli.get(0).matches("[A-Z]")) && (simvoli.get(simvoli.size()-1).matches("[.]")));
    }
    
}