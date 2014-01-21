package util;

import util.Trial.InteractionDevice;

public class Participant {
	
	private int id;
	private Trial leap, keyboard;
	
	public Participant(int id){
		this.id = id;
	}
	
	public void add(Trial trial){
		if (trial.getDevice() == InteractionDevice.LEAP){
			leap = trial;
		}
		else{
			keyboard = trial;
		}
	}
	
	public int getID(){
		return id;
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append(id).append(",");
		output.append(keyboard).append(",");;
		output.append(leap);
		return output.toString();
	}
	

}
