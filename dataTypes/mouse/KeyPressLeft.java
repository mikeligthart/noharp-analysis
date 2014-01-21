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
		KeyPressLeft other = (KeyPressLeft) obj;
		if (frame != other.frame)
			return false;
		return true;
	}

}