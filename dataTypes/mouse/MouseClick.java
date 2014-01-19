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

}
