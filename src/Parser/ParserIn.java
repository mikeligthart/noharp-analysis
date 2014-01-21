package parser;

import general.CreateBlock;
import general.DeleteBlock;
import general.EndDragBlock;
import general.MoveBlock;
import general.NewTask;
import general.StartDragBlock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import leap.Finger;
import leap.Grabbed;
import leap.Hand;
import leap.SwipedHorizontal;
import leap.SwipedVertical;
import mouse.KeyPressLeft;
import mouse.KeyPressRight;
import mouse.MouseClick;
import mouse.MouseLocDelta;
import mouse.MouseReleased;
import util.GenericDataType;
import util.GenericDataType.DataTypes;
import util.Logger;
import util.Participant;
import util.Trial;
import util.Trial.InteractionDevice;
import Exceptions.LineProcessException;


public class ParserIn {

	private Logger logger;
	private ArrayList<Participant> participants;
	
	public ParserIn(String locationRawData){
		//Setting attributes
		File folderRawLogFiles = new File(locationRawData);
		File[] listOfLogs = folderRawLogFiles.listFiles();
		participants = new ArrayList<>();
		logger = new Logger("log/", true);
		
		//Starting up logger
		logger.log("Started Parsing raw log files");
		logger.log("Number of files: " + listOfLogs.length);
	
		/* 
		 * Every raw log file is from a new participant
		 * Step through every file and parse it into a Participant format
		 */
		for (File f: listOfLogs){
			String fileName = f.getName();
			logger.log("Opened " + fileName);
			InteractionDevice device = null;
			String deviceString = fileName.substring(0,1);
			if(deviceString.contentEquals("L")){
				device = InteractionDevice.LEAP;
			}
			else if (deviceString.contentEquals("K")){
				device = InteractionDevice.KEYBOARD;
			}
			int id = Integer.parseInt(fileName.substring(1, fileName.indexOf('.')));
			
			Trial currentTrial = parse(f, id, device); //generate a Participant from log file
			currentTrial.aggregateData(); // aggregate information from participant
			
			int participantNr = getExistingParticipant(id);
			if (participantNr >= 0){
				participants.get(participantNr).add(currentTrial); //add trial to existing participant
			}
			else{
				Participant newParticipant = new Participant(id); //create new participant
				logger.log("Created new participant with id = " + id);
				newParticipant.add(currentTrial); //add the trial to the new participant
				participants.add(newParticipant); //add the new participant to the list of participants
			}
			logger.log("Added " + device + " to participant #" + id);
			
		}
		
		//Close up neatly
		logger.log("Finished Parsing raw log files");
		logger.close();
	}
	
	private int getExistingParticipant(int id) {
		int count = -1;
		for (Iterator<Participant> it = participants.iterator(); it.hasNext();){
			count++;
			if (it.next().getID() == id){
				return count;
			}
		}
		return -1;
	}

	public ArrayList<Participant> getParticipants(){
		return participants;
	}
	
	private Trial parse(File rawLogFile, int id, InteractionDevice device){
		BufferedReader br = null;
		Trial parsedResult = null;
		int frame = 0;
	
		try {
			parsedResult = new Trial(id, device);
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
						//logger.log(foundType.toString() + " | added to participant #" + id);
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
		} catch (LineProcessException e) {
			logger.log("LineProcessException in parse with the following message: " + e.getMessage());
		} 
		finally{
			if (br != null) { try { br.close(); } catch(Throwable t) { /* ensure close happens */ } }
		}		
		
		return parsedResult;
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
		case MOUSE_LOC_DELTA:
			String locX = logItemAttributeValues.substring(0,logItemAttributeValues.indexOf(','));
			String locY = logItemAttributeValues.substring(logItemAttributeValues.indexOf(' '));
			return new MouseLocDelta(frame, Double.parseDouble(locX), Double.parseDouble(locY));
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
			String handXYZ = logItemAttributeValues.substring(logItemAttributeValues.indexOf('(')+1, logItemAttributeValues.indexOf(')'));
			String handX = handXYZ.substring(0, handXYZ.indexOf(','));
			String handYZ = handXYZ.substring(handXYZ.indexOf(' ') + 1);
			String handY = handYZ.substring(0, handYZ.indexOf(','));
			String handZ = handYZ.substring(handYZ.indexOf(' ') + 1);
			String stringHand = logItemAttributeValues.substring(logItemAttributeValues.indexOf(')') + 2);
			boolean isLeft = false;
			if (stringHand.contentEquals("left")){
				isLeft = true;
			}
			return new Hand(frame, Integer.parseInt(stringId), Double.parseDouble(handX), Double.parseDouble(handY), Double.parseDouble(handZ), isLeft);
		case SWIPEDVERTICAL:
			return new SwipedVertical(frame);
		case SWIPEDHORIZONTAL:
			return new SwipedHorizontal(frame);
		default:
			return null;
		}
	}
	
}
