package util;

import java.util.ArrayList;

import aggregation.Accuracy;
import aggregation.DeviceDistance;
import aggregation.Speed;

public class Trial {
		
	public enum InteractionDevice{
		KEYBOARD, LEAP;
	}
	
	
	private InteractionDevice device;
	private ArrayList<GenericDataType> dataPoints;
	private int id;
	private boolean processed;
	private Accuracy accuracy;
	private Speed speed;
	private DeviceDistance distance;
	
	
	public Trial(int id, InteractionDevice device){
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
		speed = new Speed(this);
		distance = new DeviceDistance(this);
		processed = true;
	}
	
	public int getID(){
		return id;
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		if(processed){
			output.append(accuracy.getAccuracy()).append(",");
			output.append(speed.getAverageSpeedEasy()).append(",");
			output.append(speed.getAverageSpeedNormal()).append(",");
			output.append(distance.getDistance());
		}
		else{
			output.append("Not processed yes");
		}
		return output.toString();
	}
	
	public static String getHeader(){
		StringBuilder output = new StringBuilder();
		output.append("id").append(",");
		output.append("keyboard_accuracy").append(",");
		output.append("keyboard_avarage_speed_easy").append(",");
		output.append("keyboard_avarage_speed_normal").append(",");
		output.append("keyboard_distance").append(",");
		output.append("leap_accuracy").append(",");
		output.append("leap_avarage_speed_easy").append(",");
		output.append("leap_avarage_speed_normal").append(",");
		output.append("leap_distance");
		return output.toString();
	}
}
