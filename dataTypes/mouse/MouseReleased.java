package mouse;

import util.GenericDataType;

public class MouseReleased extends GenericDataType {

	public MouseReleased(int frame) {
		super(frame);
	}

	@Override
	public String toString() {
		return "MouseReleased";
	}

}
