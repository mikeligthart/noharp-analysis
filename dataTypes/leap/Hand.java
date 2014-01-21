package leap;

import util.GenericDataType;

public class Hand extends GenericDataType {

	private int id;
	private boolean isLeft;
	private double x, y, z;

	public Hand(int frame, int id, double x, double y, double z, boolean isLeft) {
		super(frame, DataTypes.HAND);
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
		this.isLeft = isLeft;
	}

	public int getId() {
		return id;
	}
	
	public boolean isLeft(){
		return isLeft;
	}
	
	public double getDistanceTraveled(){
		return Math.sqrt((x*x) + (y*y) + (z*z));
	}

	@Override
	public String toString() {
		return "Hand " + id + " " + isLeft;

	}

}
