package cz.jcu.prf.praktikum.test.example1;

public class MockMessageSource implements MessageSource {

	private String message;
	
	public MockMessageSource(String message) {
		this.message = message;
	}
	
	public String readMessage() {
		return message;
	}

}
