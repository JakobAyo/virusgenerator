import java.io.Serializable;

public class InfectionTime implements Serializable {
    private String day;
    private String month;
    private String timezone;

    private int daydate;
    private int hour;
    private int minute;
    private int second;
    private int year;
    
    //Regex: https://regex101.com/r/REdv76/1
    final static String REGEX_MATCH = "^(Influenza|Divoc91) (?:Mon|Tue|Wed|Thu|Fri|Sat|Sun) (?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) (?:[0-2]\\d|3[01]) (?:[01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d) (\\w{3,4}) \\d{4}$";

    public InfectionTime(String virusString){
        String[] data = virusString.split(" ");
        String[] time = data[4].split(":");
        try{
            daydate = Integer.parseInt(data[3]);
            hour = Integer.parseInt(time[0]);
            minute = Integer.parseInt(time[1]);
            second = Integer.parseInt(time[2]);
            year = Integer.parseInt(data[6]);
        }catch(NumberFormatException e){

        }catch(IndexOutOfBoundsException a){

        }
        day = data[1];
        month = data[2];
        timezone = data[5];

        if(!virusString.matches(REGEX_MATCH)){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %02d %02d:%02d:%02d %s %04d", day, month, daydate, hour, minute, second, timezone, year);
    }
}