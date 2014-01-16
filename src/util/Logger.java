package util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.UUID;

public class Logger {
	
	private Writer writer;
	private Boolean visable;
	
	public Logger(String logFolder){
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(logFolder + UUID.randomUUID() + ".log"), "utf-8"));
		} catch (IOException e) {
		  System.out.println("Logger error: " + e);
		} finally {
		   try {writer.close();} catch (Exception e) {}
		}
		visable = false;
	}
	
	public Logger(String logFolder, Boolean visable){
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(logFolder + UUID.randomUUID() + ".log"), "utf-8"));
		} catch (IOException e) {
		  System.out.println("Logger error: " + e);
		}
		this.visable = visable;
	}
	
	public void log(String message){
		if (visable){
			System.out.println("Log message: " + message);
		}
		try {
			writer.write(message + "\n");
		} catch (IOException e) {

		}
	}
	
	public void close(){
		try {
			writer.close();
		} catch (IOException e) {
			System.out.println("Logger error: " + e);
		}
	}

	public Boolean getVisable() {
		return visable;
	}

	public void setVisable(Boolean visable) {
		this.visable = visable;
	}
	
	

}
