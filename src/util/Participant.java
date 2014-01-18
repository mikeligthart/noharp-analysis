package util;

import java.util.ArrayList;
import java.util.Iterator;

public class Participant {
		
	public enum InteractionDevice{
		KEYBOARD, LEAP;
	}
	
	private InteractionDevice interaction;
	private ArrayList<GenericDataType> dataPoints;
	private int id;
	
	public Participant(int id, InteractionDevice interaction){
		this.id = id;
		this.interaction = interaction;
		dataPoints = new ArrayList<>();
	}

	public InteractionDevice getInteraction() {
		return interaction;
	}

	public ArrayList<GenericDataType> getDataPoints() {
		return dataPoints;
	}

	public void add(GenericDataType dataPoint) {
		dataPoints.add(dataPoint);	
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append("== PARSED DATA FOR PARTICIPANT #" + id + " ==");
		for(Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			output.append(it.next().toString() + "\n");
		}
		output.append("== END #" + id + " ==\n\n");
		return output.toString();
	}
	
}
