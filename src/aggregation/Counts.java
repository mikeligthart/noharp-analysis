package aggregation;

import java.util.ArrayList;
import java.util.Iterator;

import util.GenericDataType;
import util.GenericDataType.DataTypes;
import util.Trial;

public class Counts {
	
	private ArrayList<GenericDataType> dataPoints;
	private int blockMoves, screenRotateHorizontal, screenRotateVertical;
	
	public Counts(Trial trial){
		dataPoints = trial.getDataPoints();
		blockMoves = 0;
		screenRotateHorizontal = 0;
		screenRotateVertical = 0;
		calculate();
	}
	
	private void calculate(){
		ArrayList<GenericDataType> seenBlocks = new ArrayList<>();
		for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			GenericDataType currentDataPoint = it.next();
			DataTypes currentName = currentDataPoint.getName();
			//Count blocks that have been moved more then once
			if (currentName == DataTypes.START_DRAG_BLOCK){
				if (seenBlocks.contains(currentDataPoint)){
					blockMoves++;
				}
				else{
					seenBlocks.add(currentDataPoint);
				}				
			}
			
			//Count horizontal screen rotations
			if (currentName == DataTypes.SWIPEDHORIZONTAL){
				screenRotateHorizontal++; //for leap
			}
			if (currentName == DataTypes.KEY_PRESS_LEFT || currentName == DataTypes.KEY_PRESS_RIGHT){
				screenRotateHorizontal++; //for keyboard
			}
			
			//Count vertical screen rotations
			if (currentName == DataTypes.SWIPEDVERTICAL){
				screenRotateVertical++; //for leap
			}
			if (currentName == DataTypes.KEY_PRESS_UP || currentName == DataTypes.KEY_PRESS_DOWN){
				screenRotateVertical++; //for keyboard
			}
		}
		
	}
	
	public int getBlockMoves(){
		return blockMoves;
	}

	public int getScreenRotateHorizontal() {
		return screenRotateHorizontal;
	}

	public int getScreenRotateVertical() {
		return screenRotateVertical;
	}

}
