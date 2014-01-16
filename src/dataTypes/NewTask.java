package dataTypes;

public class NewTask extends GenericDataType {

	private int id;

	public NewTask(int frame, int id) {
		super(frame);
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
