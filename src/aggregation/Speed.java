package aggregation;

import java.util.ArrayList;
import java.util.Iterator;

import util.GenericDataType;
import util.GenericDataType.DataTypes;
import util.Trial;

public class Speed {
		
	private ArrayList<GenericDataType> dataPoints;
	private ArrayList<Integer> speed;
	
	public Speed (Trial trial){
		dataPoints = trial.getDataPoints();
		speed = new ArrayList<>();
		calculate();
	}
	
	public void calculate(){
		int task = 0, firstFrame = 0;
		for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			GenericDataType currentDataPoint = it.next();
			if (currentDataPoint.getName() == DataTypes.NEW_TASK){
					if (task != 0){
						speed.add(currentDataPoint.getFrame() - firstFrame);
					}
					firstFrame = currentDataPoint.getFrame();
					task++;
			}
		}
		speed.add(dataPoints.get(dataPoints.size() - 1).getFrame() - firstFrame);
	}
	
/*
 * 
 * switch(task){
				case 0:
					firstFrame = currentDataPoint.getFrame();
					break;
				case 1:
					averageSpeedEasy = (currentDataPoint.getFrame() - firstFrame);
					firstFrame = currentDataPoint.getFrame();
					break;
				case 2:
					averageSpeedEasy += (currentDataPoint.getFrame() - firstFrame);
					averageSpeedEasy = averageSpeedEasy/2.0;
					firstFrame = currentDataPoint.getFrame();
					break;
				case 3:
					averageSpeedNormal = (currentDataPoint.getFrame() - firstFrame);
					firstFrame = currentDataPoint.getFrame();
					averageSpeedNormal += (dataPoints.get(dataPoints.size() - 1).getFrame() - firstFrame);
					averageSpeedNormal = averageSpeedNormal/2;
					break;		
 */
	public int numberOftasks(){
		return speed.size();
	}
	
	public ArrayList<Integer> getSpeed(){
		return speed;
	}
	
	

}
