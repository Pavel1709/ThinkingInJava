//: concurrency/BankTellerSimulation.java
// Using queues and multithreading.
// {Args: 5}
import java.util.concurrent.*;
import java.util.*;
 
class WebClient {
  private final int serviceTime;
  public WebClient(int tm) { serviceTime = tm; }
  public int getServiceTime() { return serviceTime; }
  public String toString() {
    return "[" + serviceTime + "]";
  }
}
// Teach the customer line to display itself:
 
class WebClientLine extends ArrayBlockingQueue<WebClient> {
  public WebClientLine(int maxLineSize) {
    super(maxLineSize);
  }
  public String toString() {
    if(this.size() == 0)
      return "[Empty]";
    StringBuilder result = new StringBuilder();
    for(WebClient webClient : this)
      result.append(webClient);
    return result.toString();
  }
}
// Randomly add customers to a queue:
class WebClientGenerator implements Runnable {
  private WebClientLine webClients;
  private static Random rand = new Random(47);
  public WebClientGenerator(WebClientLine cq) {
    webClients = cq;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
        webClients.put(new WebClient(rand.nextInt(1000)));
      }
    } catch(InterruptedException e) {
      System.out.println("WebClientGenerator interrupted");
    }
    System.out.println("CustomerGenerator terminating");
  }
}

class Server implements Runnable, Comparable<Server> {
  private static int counter = 0;
  private final int id = counter++;
  // Clients served during this shift:
  private int webClientsServed = 0;
  private WebClientLine webClients;
  private int maxWeight;
  private boolean servingWebClientsLine = true;
  public Server(WebClientLine cq, int maxWeight) { webClients = cq; 
   this.maxWeight = maxWeight;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        if (webClientsServed < maxWeight) {
         WebClient webClient = webClients.take();
         TimeUnit.MILLISECONDS.sleep(
           webClient.getServiceTime());
         synchronized(this) {
           webClientsServed++;
           while(!servingWebClientsLine)
             wait();
        }
       }
       else doSomethingElse();
      }
    } catch(InterruptedException e) {
      System.out.println(this + "interrupted");
    }
    System.out.println(this + "terminating");
  }
  public synchronized void doSomethingElse() {
    webClientsServed = 0;
    servingWebClientsLine = false;
  }
  public synchronized void serveWebClientsLine() {
    assert !servingWebClientsLine :"already serving: " + this;
    servingWebClientsLine = true;
    notifyAll();
  }
  public String toString() { return "Server " + id + " "; }
  public String shortString() { return "S" + id; }
  // Used by priority queue:
  public synchronized int compareTo(Server other) {
    return webClientsServed < other.webClientsServed ? -1 :
      (webClientsServed == other.webClientsServed ? 0 : 1);
  }
}

class ServerManager implements Runnable {
  private ExecutorService exec;
  private WebClientLine webClients;
  private PriorityQueue<Server> workingServers =
    new PriorityQueue<Server>();
  private Queue<Server> serversDoingOtherThings =
    new LinkedList<Server>();
  private int adjustmentPeriod;
  private int maxWeight;
  private static Random rand = new Random(47);
  public ServerManager(ExecutorService e,
    WebClientLine webClients, int adjustmentPeriod, int maxWeight) {
    exec = e;
    this.maxWeight = maxWeight;
    this.webClients = webClients;
    this.adjustmentPeriod = adjustmentPeriod;
    // Start with a single teller:
    Server server = new Server(webClients, maxWeight);
    exec.execute(server);
    workingServers.add(server);
  }
  public void adjustServerNumber() {
    // This is actually a control system. By adjusting
    // the numbers, you can reveal stability issues in
    // the control mechanism.
    // If line is too long, add another teller:
    if(webClients.size() / workingServers.size() > 2) {
        // If tellers are on break or doing
        // another job, bring one back:
        if(serversDoingOtherThings.size() > 0) {
          Server server = serversDoingOtherThings.remove();
          server.serveWebClientsLine();
          workingServers.offer(server);
          return;
        }
      // Else create (hire) a new teller
      Server server = new Server(webClients, maxWeight);
      exec.execute(server);
      workingServers.add(server);
      return;
    }
    // If line is short enough, remove a teller:
    if(workingServers.size() > 1 &&
      webClients.size() / workingServers.size() < 2)
        reassignOneServer();
    // If there is no line, we only need one teller:
    if(webClients.size() == 0)
      while(workingServers.size() > 1)
        reassignOneServer();
  }
  // Give a teller a different job or a break:
  private void reassignOneServer() {
    Server server = workingServers.poll();
    server.doSomethingElse();
    serversDoingOtherThings.offer(server);
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
        adjustServerNumber();
        System.out.print(webClients + " { ");
        for(Server server : workingServers)
          System.out.print(server.shortString() + " ");
        System.out.println("}");
      }
    } catch(InterruptedException e) {
      System.out.println(this + "interrupted");
    }
    System.out.println(this + "terminating");
  }
  public String toString() { return "TellerManager "; }
}

public class BankTellerSimulation {
  static final int MAX_LINE_SIZE = 50;
  static final int ADJUSTMENT_PERIOD = 1000;
  public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newCachedThreadPool();
    // If line is too long, customers will leave:
    WebClientLine webClients =
      new WebClientLine(MAX_LINE_SIZE);
    exec.execute(new WebClientGenerator(webClients));
    // Manager will add and remove tellers as necessary:
    exec.execute(new ServerManager(
      exec, webClients, ADJUSTMENT_PERIOD, 10));
    if(args.length > 0) // Optional argument
      TimeUnit.SECONDS.sleep(new Integer(args[0]));
    else {
      System.out.println("Press 'Enter' to quit");
      System.in.read();
    }
    exec.shutdownNow();
  }
} /* Output: (Sample)
[429][200][207] { T0 T1 }
[861][258][140][322] { T0 T1 }
[575][342][804][826][896][984] { T0 T1 T2 }
[984][810][141][12][689][992][976][368][395][354] { T0 T1 T2 T3 }
Teller 2 interrupted
Teller 2 terminating
Teller 1 interrupted
Teller 1 terminating
TellerManager interrupted
TellerManager terminating
Teller 3 interrupted
Teller 3 terminating
Teller 0 interrupted
Teller 0 terminating
CustomerGenerator interrupted
CustomerGenerator terminating
*///:~
