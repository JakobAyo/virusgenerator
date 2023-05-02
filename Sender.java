import java.security.SecureRandom;
import java.util.ArrayList;

public class Sender implements Runnable{

private static final SecureRandom generator = new SecureRandom();
private final Buffer sharedLocation;
private ArrayList<InfectionTime> infectionsToSend;


public Sender(Buffer sharedLocation, ArrayList<InfectionTime> infectionsToSend){
    this.sharedLocation = sharedLocation;
    this.infectionsToSend = infectionsToSend;
}

public void run()
{
   for (int i = 0; i < 5; i++){
       try
       {
           Thread.sleep(generator.nextInt(3000));
           sharedLocation.send(infectionsToSend.get(i));
       }
       catch (InterruptedException exception)
       {
           Thread.currentThread().interrupt();
       }
   }
   System.out.printf("Sender done Sending%nTerminating Sender%n%n");
}
}