package parser;

import java.io.File;
import java.util.ArrayList;

import util.*;


public class ParserIn {

	private final String LOCATION_RAWDATA = "rawdata";
	private ArrayList<ArrayList<GenericDataType>> parsedData;
	
	private File folderRawLogFiles;
	private File[] listOfLogs;
	private Logger logger;
	
	public ParserIn(){
		folderRawLogFiles = new File(LOCATION_RAWDATA);
		listOfLogs = folderRawLogFiles.listFiles();
		logger = new Logger("log/", true);
		logger.log("Started Parsing raw log files");
		logger.log("Number of files: " + listOfLogs.length);
		
		for (File f: listOfLogs){
			logger.log("Opened " + f.getName());
			parsedData.add(parse(f));
		}
		
		logger.log("Finished Parsing raw log files");
		logger.close();
	}
	
	public ArrayList<GenericDataType> parse(File rawLogFile){
		//parse one file
		return new ArrayList<GenericDataType>();
	}
	
	public static void main(String[] args) {
		new ParserIn();
	}

}
