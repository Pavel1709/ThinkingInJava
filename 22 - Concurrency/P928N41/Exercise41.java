import java.util.concurrent.*;
import java.util.*;

public class Exercise41{
    private ExecutorService exec = Executors.newSingleThreadExecutor();
    private List<Future<String>> intResults=new CopyOnWriteArrayList<Future<String>>();
    private List<Future<String>> floatResults=new CopyOnWriteArrayList<Future<String>>();
    private Random rand=new Random();

    //calculateInt
    public void calculateInt(final int a, final int b){
        intResults.add(exec.submit(new Callable<String>(){
            public String call(){
                sleep(100);
                return "    "+a+" + "+b+" = "+(a+b);
            }
        }));
    }

    //calculateFloat
    public void calculateFloat(final float a, final float b){
        floatResults.add(exec.submit(new Callable<String>(){
            public String call(){
                sleep(100);
                return "    "+a+" + "+b+" = "+(a+b);
            }
        }));
    }

    //tools
    public void sleep(int time){
        try{
            TimeUnit.MILLISECONDS.sleep(time);
        }catch(InterruptedException ie){
            System.out.println("Calculator is interrupted!");
        }
    }
    public void shutdown(){exec.shutdownNow();}

    //message handler
    public void showResults(){
        long endAt=System.currentTimeMillis()+5000;   //5 secs
        while(true){
            for(Future<String> r:intResults){
                if(r.isDone()){
                    try{
                        System.out.println(r.get());
                    }catch(Exception e){
                        throw new RuntimeException();
                    }
                    intResults.remove(r);
                }
            }
            for(Future<String> r:floatResults){
                if(r.isDone()){
                    try{
                        System.out.println(r.get());
                    }catch(Exception e){
                        throw new RuntimeException();
                    }
                    floatResults.remove(r);
                }
            }
            if(System.currentTimeMillis()>=endAt){
                break;
            }
            sleep(100);
        }
    }
    public static void main(String[] args){
        Exercise41 test=new Exercise41();
        for(int i=0;i<5;i++){
            test.calculateInt(test.rand.nextInt(100),test.rand.nextInt(100));
            test.calculateFloat((test.rand.nextFloat()*test.rand.nextInt(100)),(test.rand.nextFloat()*test.rand.nextInt(100)));
        }
        test.showResults();
        test.shutdown();
    }
}
