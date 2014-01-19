package parser;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import util.Logger;
import util.Participant;

public class ParserOut {

	private Logger logger;
	private Writer writer;
	
	public ParserOut(String locationProcessedData, ArrayList<Participant> participants) {
		logger = new Logger("log/", true);		
		logger.log("Started writing .csv file with processed participants");
		
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(locationProcessedData + UUID.randomUUID() + ".csv"), "utf-8"));
		    writer.write(Participant.getHeader() + "\n");
			for (Iterator<Participant> it = participants.iterator(); it.hasNext();){
				writer.write(it.next().toString() + "\n");
				logger.log("Participant writen to file");
			}
		} catch (IOException e) {
			logger.log("IOException in parseOut with the following message: " + e.getMessage());
		}
		finally{
			if (writer != null) { try { writer.close(); } catch(Throwable t) { /* ensure close happens */ } }
		}	
		
	}
	
	
	
}
