package cz.jcu.prf.praktikum.test.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WebMessageSource implements MessageSource {

	
	public String readMessage(){
		try{
			
			URL url = new URL("http://www.prf.jcu.cz");		
			BufferedReader bfr = new BufferedReader(new InputStreamReader(url.openStream()));
			return bfr.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
