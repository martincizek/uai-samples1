package cz.jcu.prf.praktikum.test.example1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileMessageSink implements MessageSink{
	
	private String filename = "";
	private BufferedWriter out;
	
	public FileMessageSink(String filename)
	{
		try {
		  this.filename = filename;
		  FileWriter fstream = new FileWriter(filename);
		  out = new BufferedWriter(fstream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void writeMessage(String message) {
		 try{ 
			  out.write(message);
			  out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
