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
	
	public double getDistanceTraveled(Hand previousHand){
		double deltaX = Math.abs(x - previousHand.getX());
		double deltaY = Math.abs(y - previousHand.getY());
		double deltaZ = Math.abs(z - previousHand.getZ());
		
		return Math.sqrt((deltaX*deltaX) + (deltaY*deltaY) + (deltaZ*deltaZ));
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getZ(){
		return z;
	}

	@Override
	public String toString() {
		return "Hand " + id + " " + isLeft;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (isLeft ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (id != other.id)
			return false;
		if (isLeft != other.isLeft)
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

}
