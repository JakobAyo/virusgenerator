import java.io.*;
import java.util.*;

public class InfectionTimeStorage{
    public static void writeInfectionTime(ArrayList<InfectionTime> validViruses) throws IOException{
        try{
        FileOutputStream writeData = new FileOutputStream("Viruses");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(validViruses);
        writeStream.flush();
        writeStream.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static ArrayList<InfectionTime> readInfectionTime(){
        try{
            FileInputStream readData = new FileInputStream("Viruses");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<InfectionTime> VirusFile = (ArrayList<InfectionTime>) readStream.readObject();
            readStream.close();
            return VirusFile;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}