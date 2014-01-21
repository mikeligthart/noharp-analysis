package leap;

import util.GenericDataType;

public class SwipedVertical extends GenericDataType {

	public SwipedVertical(int frame) {
		super(frame, DataTypes.SWIPEDVERTICAL);

	}

	@Override
	public String toString() {
		return "SwipedVertical";

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
		SwipedVertical other = (SwipedVertical) obj;
		if (frame != other.frame)
			return false;
		return true;
	}
}
