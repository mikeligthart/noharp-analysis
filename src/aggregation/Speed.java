package aggregation;

import java.util.ArrayList;

import util.GenericDataType;
import util.Trial;

public class Speed {
	
	private ArrayList<GenericDataType> dataPoints;
	private double averageSpeedEasy, averageSpeedNormal, averageSpeedHard;
	private final int TOTALPERCATEGORY = 2;
	
	public Speed (Trial trial){
		dataPoints = trial.getDataPoints();
	}
	
	public void calculate(){
		
	}

}
