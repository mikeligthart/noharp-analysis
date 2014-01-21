package main;

import parser.ParserIn;
import parser.ParserOut;

public class Main {

	private final static String LOCATION_RAWDATA = "rawdata";
	private final static String LOCATION_PROCESSED_DATA = "processed/";
	
	public static void main(String[] args) {
		ParserIn parserIn = new ParserIn(LOCATION_RAWDATA);
		new ParserOut(LOCATION_PROCESSED_DATA, parserIn.getParticipants());		
	}

}
