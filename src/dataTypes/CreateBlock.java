package dataTypes;

public class CreateBlock extends GenericDataType {

	private int id;

	public CreateBlock(int frame, int id) {
		super(frame);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CreateBlock " + id;

	}

}
