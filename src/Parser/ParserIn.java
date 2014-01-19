package parser;

import general.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import leap.*;
import mouse.*;
import Exceptions.InteractionDeviceNotFoundException;
import Exceptions.LineProcessException;
import util.*;
import util.GenericDataType.DataTypes;
import util.Participant.InteractionDevice;


public class ParserIn {

	private Logger logger;
	private ArrayList<Participant> participants;
	
	public ParserIn(String locationRawData){
		//Setting attributes
		File folderRawLogFiles = new File(locationRawData);
		File[] listOfLogs = folderRawLogFiles.listFiles();
		participants = new ArrayList<>();
		logger = new Logger("log/", false);
		
		//Starting up logger
		logger.log("Started Parsing raw log files");
		logger.log("Number of files: " + listOfLogs.length);
	
		/* 
		 * Every raw log file is from a new participant
		 * Step through every file and parse it into a Participant format
		 */
		for (File f: listOfLogs){
			logger.log("Opened " + f.getName());
			Participant currentParticipant = parse(f); //generate a Participant from log file
			currentParticipant.aggregateData(); // aggregate information from participant;
			participants.add(currentParticipant); //add the current participant to the list of participants
		}
		
		//Close up neatly
		logger.log("Finished Parsing raw log files");
		logger.close();
	}
	
	public ArrayList<Participant> getParsedData(){
		return participants;
	}
	
	private Participant parse(File rawLogFile){
		BufferedReader br = null;
		Participant parsedResult = null;
		InteractionDevice device = null;
		int frame = 0;
		String nameOfLog = rawLogFile.getName();
		int id = Integer.parseInt(nameOfLog.substring(0, nameOfLog.indexOf('.')));
		
		try {
			device = deteriminInteractionDevice(rawLogFile);
			parsedResult = new Participant(id, device);
			br = new BufferedReader(new FileReader(rawLogFile));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains(GenericDataType.FRAME)){ //if it's a frame line
					//retrieve and save the last frame count
					frame = Integer.parseInt(line.substring(line.indexOf(' ')+1));
				}
				else{
				//process the line if it is not a frame
					GenericDataType foundType = processLine(line, frame);
					if (foundType != null){
						logger.log(foundType.toString() + " | added to participant #" + id);
						parsedResult.add(foundType);
					}
				}
			}
			br.close();
			
		//Catch & log exceptions
		} catch (FileNotFoundException e) {
			logger.log("FileNotFoundException in parse with the following message: " + e.getMessage());
		} catch (IOException e) {
			logger.log("IOException in parse with the following message: " + e.getMessage());
		} catch (InteractionDeviceNotFoundException e) {
			logger.log("InteractionDeviceNotFoundException in parse with the following message: " + e.getMessage());
		} catch (LineProcessException e) {
			logger.log("LineProcessException in parse with the following message: " + e.getMessage());
		} 
		finally{
			if (br != null) { try { br.close(); } catch(Throwable t) { /* ensure close happens */ } }
		}		
		
		return parsedResult;
	}
	
	private InteractionDevice deteriminInteractionDevice(File rawLogFile) throws InteractionDeviceNotFoundException {
		BufferedReader br = null;
		String line = null;
		
		try {
			br = new BufferedReader(new FileReader(rawLogFile));
			//step through file until it ends or one of the recognizer words are found
			do {} while((line = br.readLine()) != null && !line.contains(GenericDataType.RECOGNIZER_KEYBOARD) && !line.contains(GenericDataType.RECOGNIZER_LEAP));
			br.close();
		
		//Catch & log exceptions
		} catch (FileNotFoundException e) {
			logger.log("FileNotFoundException in deteriminInteractionDevice with the following message: " + e.getMessage());
		} catch (IOException e) {
			logger.log("IOException in deteriminInteractionDevice with the following message: " + e.getMessage());
		}
		
		//determine if and what recognizer word was found & return it.
		if(line == null){
			throw new InteractionDeviceNotFoundException("No interaction device found");
		}
		else if(line.contains(GenericDataType.RECOGNIZER_KEYBOARD)){
			return InteractionDevice.KEYBOARD;
		}
		else if(line.contains(GenericDataType.RECOGNIZER_LEAP)){
			return InteractionDevice.LEAP;
		}
		else{
			throw new InteractionDeviceNotFoundException("No interaction device found");
		}

	}

	private GenericDataType processLine(String line, int frame) throws LineProcessException{
		if (line != ""){
			int i = line.indexOf(' ');
			String logItemName = line.substring(0, i);
			String logItemAttributeValues = line.substring(i+1);
			return extractDataType(logItemName, logItemAttributeValues, frame);
		}
		else{
			throw new LineProcessException("Line cannot be empty");
		}
	}

	private GenericDataType extractDataType(String logItemName,
			String logItemAttributeValues, int frame) {
		
		DataTypes currentType = DataTypes.getRightDataType(logItemName);
		if (currentType == null){
			return null;
		}
		
		switch (currentType){
		case CREATE_BLOCK:
			return new CreateBlock(frame, Integer.parseInt(logItemAttributeValues));
		case DELETE_BLOCK:
			return new DeleteBlock(frame, Integer.parseInt(logItemAttributeValues));
		case END_DRAG_BLOCK:
			return new EndDragBlock(frame, Integer.parseInt(logItemAttributeValues));
		case KEY_PRESS_LEFT:
			return new KeyPressLeft(frame);
		case KEY_PRESS_RIGHT:
			return new KeyPressRight(frame);
		case MOUSE_CLICK:
			return new MouseClick(frame);
		case MOUSE_RELEASED:
			return new MouseReleased(frame);
		case MOVE_BLOCK:
			String stringID = logItemAttributeValues.substring(0,logItemAttributeValues.indexOf(' '));
			String coordinates =  logItemAttributeValues.substring(logItemAttributeValues.indexOf(' ')+2);
			String x = coordinates.substring(0,coordinates.indexOf(','));
			String yz = coordinates.substring(coordinates.indexOf(' ') + 1);
			String y = yz.substring(0,yz.indexOf(','));
			String z = yz.substring(yz.indexOf(' ') + 1, yz.indexOf(')'));
			return new MoveBlock(frame, Integer.parseInt(stringID),  Double.parseDouble(x),  Double.parseDouble(y),  Double.parseDouble(z));
		case NEW_TASK:
			return new NewTask(frame, Integer.parseInt(logItemAttributeValues));
		case START_DRAG_BLOCK:
			return new StartDragBlock(frame, Integer.parseInt(logItemAttributeValues));
		case FINGER:
			return new Finger(frame, Integer.parseInt(logItemAttributeValues.substring(0, logItemAttributeValues.indexOf(' '))));
		case GRABBED:
			return new Grabbed(frame);
		case HAND:
			String stringId = logItemAttributeValues.substring(0, logItemAttributeValues.indexOf(' '));
			String stringHand = logItemAttributeValues.substring(logItemAttributeValues.indexOf(')') + 2);
			boolean isLeft = false;
			if (stringHand.contentEquals("left")){
				isLeft = true;
			}
			return new Hand(frame, Integer.parseInt(stringId), isLeft);
		case SWIPEDVERTICAL:
			return new SwipedVertical(frame);
		case SWIPEDHORIZONTAL:
			return new SwipedHorizontal(frame);
		default:
			return null;
		}
	}
	
}
