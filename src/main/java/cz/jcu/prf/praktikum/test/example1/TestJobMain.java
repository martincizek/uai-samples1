package cz.jcu.prf.praktikum.test.example1;

public class TestJobMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		TestJob job = new TestJob();
		
		job.start();

		job.setHandler(new JobUpdatedHandler() {
			
			public void jobUpdated(String message) {
				System.out.println("Job mi prave sdelil tuto aktualizaci: " + message);
			}
		});


		System.out.println("Na zacatku:");
		System.out.println(job.getResults());
		Thread.sleep(3000);
		System.out.println("Po 3 sekundach:");
		System.out.println(job.getResults());
		Thread.sleep(3000);
		System.out.println("Po 6 sekundach:");
		System.out.println(job.getResults());
		job.stop();
	}

}
