import java.util.ArrayList;

public class Fax implements Buffer {

    private InfectionTime buffer;
    private boolean occupied = false;

    private ArrayList<InfectionTime> infections;

    public synchronized void send(InfectionTime buffer) throws InterruptedException{

        while (occupied){
            System.out.println("Sender tires to write.");
            displayState("Buffer full. Sender waits.");
            wait();
        }
        this.buffer = buffer;
        occupied = true;
        displayState("Sender writes   " + buffer);
        notifyAll();
    }
    public synchronized InfectionTime read() throws InterruptedException{
        while (!occupied){
            System.out.println("Reciever tries to read");
            displayState("Buffer empty. Reciever waits");
            wait();
        }

        occupied = false;
        displayState("Reciever reads  " + buffer);
        notifyAll();
        return buffer;
    }

    private synchronized void displayState(String operation){
        System.out.printf("%-50s%-35s%b%n%n", operation, buffer, occupied);
    }
}