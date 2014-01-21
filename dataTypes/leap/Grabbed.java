package leap;

import util.GenericDataType;

public class Grabbed extends GenericDataType {

	public Grabbed(int frame) {
		super(frame, DataTypes.GRABBED);

	}

	@Override
	public String toString() {
		return "Grabbed";

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
		Grabbed other = (Grabbed) obj;
		if (frame != other.frame)
			return false;
		return true;
	}

}
