package mouse;

import util.GenericDataType;

public class MouseClick extends GenericDataType {

	public MouseClick(int frame) {
		super(frame, DataTypes.MOUSE_CLICK);
	}

	@Override
	public String toString() {
		return "MouseClick";
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
		MouseClick other = (MouseClick) obj;
		if (frame != other.frame)
			return false;
		return true;
	}

}
