package cz.jcu.prf.praktikum.test.example1;

public class ConsoleMessageSink implements MessageSink{

	public void writeMessage(String message) {

		System.out.println(message);
		
	}

}
