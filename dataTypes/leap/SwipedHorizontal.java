package leap;

import util.GenericDataType;

public class SwipedHorizontal extends GenericDataType {

	public SwipedHorizontal(int frame) {
		super(frame, DataTypes.SWIPEDHORIZONTAL);

	}

	@Override
	public String toString() {
		return "SwipedHorizontal";

	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + frame;
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
		SwipedHorizontal other = (SwipedHorizontal) obj;
		if (frame != other.frame)
			return false;
		return true;
	}

}
