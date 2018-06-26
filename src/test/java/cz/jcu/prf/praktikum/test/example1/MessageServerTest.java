package cz.jcu.prf.praktikum.test.example1;

import java.util.Arrays;

import junit.framework.TestCase;

public class MessageServerTest extends TestCase {

	public void testDispatch() throws Exception {
		MockMessageSource source1 = new MockMessageSource("ahoj");
		MockMessageSource source2 = new MockMessageSource("nazdar");
		MockMessageSink sink1 = new MockMessageSink();
		MockMessageSink sink2 = new MockMessageSink();
		
		MessageServer server = new MessageServer();
		
		server.addMessageSource(source1);
		server.addMessageSource(source2);
		server.addMessageSink(sink1);
		server.addMessageSink(sink2);
		
		server.dispatch();
		
		assertEquals(Arrays.asList(new String[] {"ahoj", "nazdar"}), sink1.getMessages());
		assertEquals(Arrays.asList(new String[] {"ahoj", "nazdar"}), sink2.getMessages());
	}
	
}
