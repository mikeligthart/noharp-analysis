package dataTypes;

public class DeleteBlock extends GenericDataType {

	private int id;

	public DeleteBlock(int frame, int id) {
		super(frame);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "DeleteBlock " + id;
	}
}
