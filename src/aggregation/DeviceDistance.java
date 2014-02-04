package aggregation;

import java.util.ArrayList;
import java.util.Iterator;

import leap.Hand;
import mouse.MouseLocDelta;
import util.GenericDataType;
import util.Trial;
import util.GenericDataType.DataTypes;
import util.Trial.InteractionDevice;

public class DeviceDistance {
	
	private ArrayList<GenericDataType> dataPoints;
	private double distance;
	private InteractionDevice device;
	
	public DeviceDistance(Trial trial){
		dataPoints = trial.getDataPoints();
		device = trial.getDevice();
		calculate();
	}
	
	private void calculate(){
		distance = 0.0;
		Hand previousHand = null;
		for (Iterator<GenericDataType> it = dataPoints.iterator(); it.hasNext();){
			GenericDataType currentPoint = it.next();
			if (device == InteractionDevice.KEYBOARD){
				if (currentPoint.getName() == DataTypes.MOUSE_LOC_DELTA){
					MouseLocDelta delta = (MouseLocDelta) currentPoint;
					distance += delta.getDistanceTraveled();
				}
			}
			else {
				if (currentPoint.getName() == DataTypes.HAND){
					if (previousHand == null){
						previousHand = (Hand) currentPoint;
					}
					else {
						Hand currentHand = (Hand) currentPoint;
						distance += currentHand.getDistanceTraveled(previousHand);
						previousHand = currentHand;
					}
				}
			}				
		}
	}
	
	public double getDistance(){
		return distance;
	}

}
