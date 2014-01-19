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

}
