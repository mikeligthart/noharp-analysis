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

}
