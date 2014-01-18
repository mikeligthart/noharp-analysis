package main;

import java.util.ArrayList;

import parser.ParserIn;
import util.Participant;

public class Main {

	private final static String LOCATION_RAWDATA = "rawdata";
	
	public static void main(String[] args) {
		ParserIn parserIn = new ParserIn(LOCATION_RAWDATA);
		@SuppressWarnings("unused")
		ArrayList<Participant> participants = parserIn.getParsedData();
	}

}
