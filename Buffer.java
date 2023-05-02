public interface Buffer {
    public void send(InfectionTime infection) throws InterruptedException;

    public InfectionTime read() throws InterruptedException;
}
