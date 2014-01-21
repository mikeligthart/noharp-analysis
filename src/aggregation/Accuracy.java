package aggregation;

import java.util.ArrayList;
import java.util.Iterator;

import util.GenericDataType;
import util.Trial;
import util.GenericDataType.DataTypes;

public class Accuracy {
	
	private ArrayList<GenericDataType> dataPoints;
	private double total, effective;
	
	public Accuracy(Trial trial){
		dataPoints = trial.getDataPoints();
		calculate();
	}
	
	private void calculate(){
		total = 0;
		effective = 0;
		for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			GenericDataType currentPoint = it.next();
			if (currentPoint.getName() == DataTypes.MOUSE_CLICK || currentPoint.getName() == DataTypes.GRABBED){
				total++;
				if (checkIfEffective(currentPoint.getFrame())){
					effective++;
				}
			}
				
		}
	}

	private boolean checkIfEffective(int frame) {
		for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			GenericDataType currentPoint = it.next();
				if(currentPoint.getName() == DataTypes.CREATE_BLOCK || currentPoint.getName() == DataTypes.START_DRAG_BLOCK){
					if (currentPoint.getFrame() == frame){
						return true;
					}
				}
		}
		return false;
	}

	public Double getAccuracy(){
		return effective/total;
	}
	
}
