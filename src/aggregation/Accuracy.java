package aggregation;

import java.util.ArrayList;
import java.util.Iterator;

import util.GenericDataType;
import util.Participant;
import util.GenericDataType.DataTypes;

public class Accuracy {
	
	private ArrayList<GenericDataType> dataPoints;
	private double total, effective;
	
	public Accuracy(Participant participant){
		dataPoints = participant.getDataPoints();
		calculate();
	}
	
	public void newParticipant(Participant participant){
		this.dataPoints = participant.getDataPoints();
		calculate();
	}
	
	private void calculate(){
		int index = -1;
		total = 0;
		effective = 0;
		
			for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
				GenericDataType currentPoint = it.next();
				index++;
				if (currentPoint.getName() == DataTypes.MOUSE_CLICK || currentPoint.getName() == DataTypes.GRABBED){
					total++;
					if (lookBackAndForward(index, currentPoint.getFrame())){
						effective++;
					}
				}
					
			}
	}

	private boolean lookBackAndForward(int index, int frame) {
		for (int i = (index - 10); i < index + 10; i++){
			if (i < dataPoints.size() && i >= 0){
				GenericDataType testPoint = dataPoints.get(i);
				if (testPoint.getFrame() == frame){
					if(testPoint.getName() == DataTypes.CREATE_BLOCK || testPoint.getName() == DataTypes.START_DRAG_BLOCK){
						return true;
					}
				}
			}
		}
		return false;
	}

	public Double getAccuracy(){
		return effective/total;
	}
	
}
