package util;

import java.util.ArrayList;
import java.util.Iterator;

import aggregation.Accuracy;
import aggregation.Counts;
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
	private static int numberOfTasks;
	private Counts counts;
	
	
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
		numberOfTasks = speed.numberOftasks();
		distance = new DeviceDistance(this);
		counts = new Counts(this);
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
			for (Iterator<Integer> it = speed.getSpeed().iterator(); it.hasNext();){
				output.append(it.next()).append(",");	
			}
			output.append(distance.getDistance()).append(",");
			output.append(counts.getBlockMoves()).append(",");
			output.append(counts.getScreenRotateHorizontal()).append(",");
			output.append(counts.getScreenRotateVertical());
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
		for (int i = 1; i <= numberOfTasks; i++){
			output.append("keyboard_speed_task_" + i).append(",");
		}
		output.append("keyboard_distance").append(",");
		output.append("keyboard_block_moves").append(",");
		output.append("keyboard_horizontal_rotations").append(",");
		output.append("keyboard_vertical_rotations").append(",");
		output.append("leap_accuracy").append(",");
		for (int i = 1; i <= numberOfTasks; i++){
			output.append("leap_speed_task_" + i).append(",");
		}
		output.append("leap_distance").append(",");
		output.append("leap_block_moves").append(",");
		output.append("leap_horizontal_rotations").append(",");
		output.append("leap_vertical_rotations");
		return output.toString();
	}
}
