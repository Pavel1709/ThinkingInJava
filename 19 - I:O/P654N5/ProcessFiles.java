//: net/mindview/util/ProcessFiles.java
 
import java.io.*;
import java.util.regex.*;
public class ProcessFiles {
  public interface Strategy {
    void process(File file);
  }
  private Strategy strategy;
  private String ext;
  public ProcessFiles(Strategy strategy, String ext) {
    this.strategy = strategy;
    this.ext = ext;
  }
  public void start(String[] args) {
      Pattern pattern = Pattern.compile(ext);
    try {
      if(args.length == 0)
        processDirectoryTree(new File("."));
      else
        for(String arg : args) {
         if (pattern.matcher(arg).matches()) {
          File fileArg = new File(arg);
          if(fileArg.isDirectory() )
            processDirectoryTree(fileArg);
          else {
            
            // Allow user to leave off extension:

            strategy.process(
              new File(arg).getCanonicalFile());
          }
         }
        }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public void
  processDirectoryTree(File root) throws IOException {
    for(File file : Directory.walk(
        root.getAbsolutePath(), ".*\\." + ext))
      strategy.process(file.getCanonicalFile());
  }
  // Demonstration of how to use it:
  public static void main(String[] args) {
    new ProcessFiles(new ProcessFiles.Strategy() {
      public void process(File file) {
        System.out.println(file);
      }
    }, "T.*\\.java").start(args);
  }
} /* java ProcessFiles T.java *///:~