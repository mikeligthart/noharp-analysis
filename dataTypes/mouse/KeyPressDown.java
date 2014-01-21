package mouse;

import util.GenericDataType;

public class KeyPressDown extends GenericDataType {

	public KeyPressDown(int frame) {
		super(frame, DataTypes.KEY_PRESS_DOWN);
	}

	@Override
	public String toString() {
		return "KeyPressDown";
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
		KeyPressDown other = (KeyPressDown) obj;
		if (frame != other.frame)
			return false;
		return true;
	}

}