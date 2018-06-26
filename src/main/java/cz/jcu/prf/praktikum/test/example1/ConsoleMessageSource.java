package cz.jcu.prf.praktikum.test.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMessageSource implements MessageSource {

	BufferedReader reader;
	
	public ConsoleMessageSource() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public String readMessage() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
