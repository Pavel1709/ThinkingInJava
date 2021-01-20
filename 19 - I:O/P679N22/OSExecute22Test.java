import java.io.*;
import java.util.*;
 class OSExecute22Exception extends RuntimeException {
	public OSExecute22Exception(String s) { super(s); }
}

class OSExecute22 {
	public static List<String> command(String command) {
		boolean err = false;
		List<String> ls = new ArrayList<String>(); 
		try {
			Process process = new ProcessBuilder(
				command.split(" ")).start();
			BufferedReader results = new BufferedReader(
				new InputStreamReader(process.getInputStream()));
			String s;			
			while((s = results.readLine()) != null) {
				ls.add(s);
			}
			BufferedReader errors = new BufferedReader(
				new InputStreamReader(process.getErrorStream()));
			// Report errors and return nonzero value to calling
			// process if there are problems:
			while((s = errors.readLine()) != null) { 
				System.err.println(s);
				err = true;
			}
		} catch(Exception e) {
			// Compensate for Windows 2000, which throws an exception
			// for the default command line:
			if(!command.startsWith("CMD /C"))	
				command("CMD /C " + command);
			else
				throw new RuntimeException(e);
		}
		if(err)
			throw new OSExecute22Exception("Errors executing " + command);
		return ls;
	}
} 

public class OSExecute22Test {
	public static void main(String[] args) {
		for(String s : OSExecute22.command("javap OSExecute22Test"))
			System.out.println(s);
	}
}