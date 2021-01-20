 
import java.util.concurrent.*;
import java.util.*;

public class WaitPerson36 implements Runnable{
    private static final Random rand=new Random();
    private static int count=0;
    private final int id=++count;
    private final String name="Wait Person";
    public String toString(){return name+" #"+id;}

    private Restaurant36 restaurant;   
    private BlockingQueue<Client36> serviceQueue;    
    private BlockingQueue<OrderTicket36> orderQueue;   
    private BlockingQueue<Plate36> plateQueue;   
    public WaitPerson36(Restaurant36 r){
        restaurant=r;
        serviceQueue=restaurant.getServiceQueue();
        orderQueue=restaurant.getOrderQueue();
        plateQueue=restaurant.getPlateQueue();
    }

    public void run(){
        try{
            while(!Thread.interrupted()){
             
                Client36 client=serviceQueue.poll(1,TimeUnit.MILLISECONDS);  
                if(client!=null){
                    OrderTicket36 ticket=new OrderTicket36(client,this);
                    ticket.addOrder(new Order36(Course36.randomAppet(),ticket));
                    ticket.addOrder(new Order36(Course36.randomMain(),ticket));
                    ticket.addOrder(new Order36(Course36.randomDessert(),ticket));
                    ticket.addOrder(new Order36(Course36.randomCoffee(),ticket));
                    System.out.println(ticket.readTicket());
                    orderQueue.put(ticket);  
                    client.keepTicket(ticket);
                }
                TimeUnit.MILLISECONDS.sleep(1);
 
                Plate36 plate=plateQueue.poll(1,TimeUnit.MILLISECONDS);  
                if(plate!=null){
                    Client36 client2=plate.getOrder().getTicket().getClient();
                    client2.getSpace().put(plate);   
                }
            }
        }catch(InterruptedException ie){
            System.out.println(this+" Service Interrupted!");
        }
    }
}