public class Infection {
    private String viursName;
    private Object infectionTime;

    public Infection(String  viursName, Object  infectionTime){
        this.viursName = viursName;
        this.infectionTime = infectionTime;
    }

    @Override
    public String toString() {
        return "0 " + viursName + "\n" + infectionTime;
    }
}
