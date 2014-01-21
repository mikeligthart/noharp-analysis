package mouse;

import util.GenericDataType;

public class MouseLocDelta extends GenericDataType {

	private double x,y;
	
	public MouseLocDelta(int frame, double x, double y) {
		super(frame, DataTypes.MOUSE_LOC_DELTA);
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "MouseLocDelta " + x + " " + y + " " + getDistanceTraveled();
	}
	
	public double getDistanceTraveled(){
		return Math.sqrt((x*x) + (y*y));
	}

}