import java.security.SecureRandom;
import java.util.ArrayList;

public class Reader implements Runnable{

private static final SecureRandom generator = new SecureRandom();
private final Buffer sharedLocation;


public Reader(Buffer sharedLocation){
    this.sharedLocation = sharedLocation;
}

@Override
public void run() {
   for (int i = 0; i < 5; i++)
   {
       try
       {
           Thread.sleep(generator.nextInt(3000));
           sharedLocation.read();
       }
       catch (InterruptedException exception)
       {
           Thread.currentThread().interrupt();
       }
   }
   System.out.printf("Reader done reading%nTerminating Reader%n");
}
}
