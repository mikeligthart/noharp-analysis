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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Finger other = (Finger) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
