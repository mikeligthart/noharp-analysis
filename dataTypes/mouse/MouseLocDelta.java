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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
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
		MouseLocDelta other = (MouseLocDelta) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (frame != other.frame)
			return false;
		return true;
	}

}