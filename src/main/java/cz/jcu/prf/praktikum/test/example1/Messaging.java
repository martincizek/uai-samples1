package cz.jcu.prf.praktikum.test.example1;

import java.io.IOException;

public class Messaging {

	private static int DEFAULT_ITERATIONS = 2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		// Prepare sources
		MessageSource source1 = new WebMessageSource();
		MessageSource source2 = new ConsoleMessageSource();
		
		// Prepare sinks
		MessageSink sink1 = new ConsoleMessageSink();
		MessageSink sink2 = new FileMessageSink(System.getProperty("user.home")+"/messages.txt");
		
		// configure server
		MessageServer server = new MessageServer();
		server.addMessageSource(source1);
		server.addMessageSource(source2);
		server.addMessageSink(sink1);
		server.addMessageSink(sink2);

		// run
		for (int i = 0; i < DEFAULT_ITERATIONS; i ++) {
			server.dispatch();
		}
	}

}
