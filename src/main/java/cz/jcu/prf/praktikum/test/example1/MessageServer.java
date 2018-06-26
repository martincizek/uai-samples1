package cz.jcu.prf.praktikum.test.example1;

import java.io.IOException;
import java.util.ArrayList;

public class MessageServer{
	private ArrayList<MessageSource> sources;
	private ArrayList<MessageSink> sinks;
	
	public MessageServer(){
		sources = new ArrayList<MessageSource>();
		sinks = new ArrayList<MessageSink>();
	}
	
	public void addMessageSource(MessageSource newSource){ sources.add(newSource); }
	public void addMessageSink(MessageSink newSink){ sinks.add(newSink); }
	
	/**
	 * Push message from each configured source to all attached sinks. 
	 * @throws IOException
	 */
	public void dispatch() throws IOException {
		
		for (MessageSource source : sources) {
			String message = source.readMessage();
			for (MessageSink sink : sinks) {
				sink.writeMessage(message);
			}
		}
	}

	public ArrayList<MessageSource> getSources() {
		return sources;
	}

	public ArrayList<MessageSink> getSinks() {
		return sinks;
	}
}
