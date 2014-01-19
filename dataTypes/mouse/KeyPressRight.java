package mouse;

import util.GenericDataType;

public class KeyPressRight extends GenericDataType {

	public KeyPressRight(int frame) {
		super(frame, DataTypes.KEY_PRESS_RIGHT);
	}

	@Override
	public String toString() {
		return "KeyPressRight";
	}

}