import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Virus {


	public static void main(String[] args) throws InterruptedException {
		ArrayList<InfectionTime> validViruses = new ArrayList<InfectionTime>();
		for (int i = 0; i < 100; i++) {
			String virus = VirusGenerator.generateVirus(true);
			try {
				validViruses.add(new InfectionTime(virus));
			} catch (IllegalArgumentException e) {
				continue;
			}
		}

		frame fs = new frame(validViruses);
/*
		ExecutorService executorService = Executors.newCachedThreadPool();

		Buffer sharedLocation = new Fax();

		System.out.printf("%-50s%-35s%s%n%-50s%-35s%s%n%n", "Operation", "Buffer", "Occupied", "---------", "------","--------");


		executorService.execute(new Sender(sharedLocation, validViruses));
		executorService.execute(new Reader(sharedLocation));

		executorService.awaitTermination(1, TimeUnit.MINUTES);
		executorService.shutdown();
*/

	}
}