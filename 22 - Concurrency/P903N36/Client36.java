import java.util.concurrent.*;
import java.util.*;

public class Client36 implements Runnable{
    private static int count=0;
    private final int id=++count;
    private final String name="Client";
    public String toString(){return name+" #"+id;}

    private Restaurant36 restaurant;     
    private Table36 table=null;   
    private boolean foundTable=false;
    private BlockingQueue<Client36> serviceQueue;
    private SynchronousQueue<Plate36> hisSpace;  
    private OrderTicket36 ticket;
    private int finished;
    public Client36(Restaurant36 r){
        restaurant=r;
        serviceQueue=r.getServiceQueue();
        hisSpace=new SynchronousQueue<Plate36>();
        finished=0;
    }
    public synchronized void lookForTable(){
        try{
            table=restaurant.getTables().take();    
            sit(table);
        }catch(InterruptedException ie){
            System.out.println(this+" is interrupted in the queue of table!");
        }
    }
    public boolean foundTable(){return table!=null;}
    public Table36 getTable(){return table;}
    public BlockingQueue<Plate36> getSpace(){return hisSpace;}
    public void keepTicket(OrderTicket36 t){ticket=t;}
    public OrderTicket36 getTicket(){return ticket;}
    public boolean checkOrder(Order36 o){
        if(ticket==null){return false;}
        return ticket.getOrders().contains(o);
    }

    public synchronized void sit(Table36 table){
        table.oneSit(this);
        System.out.println(this+" sit on "+table+". "+"["+table.left()+" left]");
    }

    public synchronized void leave(Table36 table){
        table.oneLeave(this);
        System.out.println(this+" leave "+table+". ["+table.left()+" left]");
    }
    public boolean finishEat(){return finished==ticket.getOrders().size();}
    public void pay(){
        if(ticket==null){System.out.println("Sorry, I didn't eat anything!");return;}
        if(!finishEat()){System.out.println("Sorry, I didn't finish the dinner!");return;}
        System.out.println(this+" Pay "+ticket.getTotalPrice()+". Bye-Bye!");
    }

    public void run(){
        try{
            //look for table
            lookForTable();
            //wait in serviceQueue
            serviceQueue.put(this);
          
            while(ticket==null){
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(1);
            }
          
            while(!finishEat()){
                Plate36 plate=hisSpace.take();  
                if(checkOrder(plate.getOrder())){
                    System.out.println(this+" is eating "+plate+"...");
                    finished++;
                    TimeUnit.MILLISECONDS.sleep(1);
                }
            }
        
            pay();
        }catch(InterruptedException ie){
            System.out.println(this+" Eat interrupted!");
        }finally{
            
            if(foundTable()){
                leave(table);
            }
        }
    }
    public static void main(String[] args){
        System.out.println(Course36.random());
    }
}