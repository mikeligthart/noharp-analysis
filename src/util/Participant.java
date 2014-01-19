package util;

import java.util.ArrayList;

import aggregation.Accuracy;

public class Participant {
		
	public enum InteractionDevice{
		KEYBOARD, LEAP;
	}
	
	
	private InteractionDevice device;
	private ArrayList<GenericDataType> dataPoints;
	private int id;
	private boolean processed;
	private Accuracy accuracy;
	
	
	public Participant(int id, InteractionDevice device){
		this.id = id;
		this.device = device;
		processed = false;
		dataPoints = new ArrayList<>();
	}

	public InteractionDevice getDevice() {
		return device;
	}

	public ArrayList<GenericDataType> getDataPoints() {
		return dataPoints;
	}

	public void add(GenericDataType dataPoint) {
		dataPoints.add(dataPoint);	
	}
	
	public void aggregateData(){
		accuracy = new Accuracy(this);
		processed = true;
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append(id).append(", ");
		output.append(device).append(", ");
		
		if(processed){
			output.append(accuracy.getAccuracy());
		}
		else{
			output.append("Not processed yes");
		}
		return output.toString();
	}
	
	public static String getHeader(){
		StringBuilder output = new StringBuilder();
		output.append("id").append(", ");
		output.append("device").append(", ");
		output.append("accuracy");
		return output.toString();
	}
	
}
