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

}
