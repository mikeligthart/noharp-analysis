package leap;

import util.GenericDataType;

public class Finger extends GenericDataType {

	private int id;

	public Finger(int frame, int id) {
		super(frame, DataTypes.FINGER);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Finger " + id;

	}

}
