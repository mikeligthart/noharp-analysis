package general;

import util.GenericDataType;


public class NewTask extends GenericDataType {

	private int id;

	public NewTask(int frame, int id) {
		super(frame, DataTypes.NEW_TASK);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "NewTask " + id;
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
		NewTask other = (NewTask) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
