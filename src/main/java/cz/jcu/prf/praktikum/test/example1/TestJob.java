package cz.jcu.prf.praktikum.test.example1;

import java.util.ArrayList;
import java.util.List;

public class TestJob {

	private List<String> results = new ArrayList<String>();
	private Thread jobThread;
	private volatile boolean stopped;
	private JobUpdatedHandler handler;
	
	public void start() {
		jobThread = new Thread(new JobWorker());
		stopped = false;
		jobThread.start();
	}
	
	public void stop() {
		stopped = true;
		jobThread.interrupt();
		try {
			jobThread.join();
		} catch (InterruptedException e) {
			// Ignored
		}
	}
	
	public void setHandler(JobUpdatedHandler handler) {
		this.handler = handler;
	}
	
	public List<String> getResults() {
		synchronized (results) {
			return new ArrayList<String>(results);
		}
	}
	
	private class JobWorker implements Runnable {
		public void run() {
			for (int i = 0; i < 50 && !stopped; i++) {
				String message = "Ted je " + System.currentTimeMillis();
				
				if (handler != null) {
					handler.jobUpdated(message);
				}
				
				synchronized (results) {
					results.add(message);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//  ignored
				}
			}
		}
	}
	
}

