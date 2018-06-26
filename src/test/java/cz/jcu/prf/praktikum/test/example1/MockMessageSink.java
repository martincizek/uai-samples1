/**
 * 
 */
package cz.jcu.prf.praktikum.test.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UAI
 *
 */
public class MockMessageSink implements MessageSink {

	private List<String> messages = new ArrayList<String>();
	
	public void writeMessage(String message) {
		messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}
}
