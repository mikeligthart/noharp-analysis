package aggregation;

import java.util.ArrayList;
import java.util.Iterator;

import util.GenericDataType;
import util.GenericDataType.DataTypes;
import util.Trial;

public class Speed {
	
	private ArrayList<GenericDataType> dataPoints;
	private double averageSpeedEasy, averageSpeedNormal;
	
	public Speed (Trial trial){
		dataPoints = trial.getDataPoints();
		calculate();
	}
	
	public void calculate(){
		int task = 0, firstFrame = 0;
		for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			GenericDataType currentDataPoint = it.next();
			if (currentDataPoint.getName() == DataTypes.NEW_TASK){
				switch(task){
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
				}
				task++;
			}
		}
	}
	
	public double getAverageSpeedEasy(){
		return averageSpeedEasy;
	}
	
	public double getAverageSpeedNormal(){
		return averageSpeedNormal;
	}
	
	

}
