package cz.jcu.prf.praktikum.test.example1;

public class ThreadExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new TaskWorker(), "taskWorker1");
		Thread t2 = new Thread(new TaskWorker(), "taskWorker2");
		
		t1.start();
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// ignored
		}
		
		// kontrola stavu aplikace
		System.out.println("All was OK");
		System.exit(0);
		
	}
	
	private static class TaskWorker implements Runnable {
		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					Thread.sleep(500);
					System.out.println(System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				// ignored
			}
		}
	}
}
