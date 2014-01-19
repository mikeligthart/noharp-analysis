package mouse;

import util.GenericDataType;

public class KeyPressLeft extends GenericDataType {

	public KeyPressLeft(int frame) {
		super(frame, DataTypes.KEY_PRESS_LEFT);
	}

	@Override
	public String toString() {
		return "KeyPressLeft";
	}

}