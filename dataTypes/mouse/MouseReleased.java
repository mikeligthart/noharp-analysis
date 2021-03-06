package mouse;

import util.GenericDataType;

public class MouseReleased extends GenericDataType {

	public MouseReleased(int frame) {
		super(frame, DataTypes.MOUSE_RELEASED);
	}

	@Override
	public String toString() {
		return "MouseReleased";
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
		MouseReleased other = (MouseReleased) obj;
		if (frame != other.frame)
			return false;
		return true;
	}

}
