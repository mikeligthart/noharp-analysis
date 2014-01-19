package general;

import util.GenericDataType;


public class CreateBlock extends GenericDataType {

	private int id;

	public CreateBlock(int frame, int id) {
		super(frame, DataTypes.CREATE_BLOCK);
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
