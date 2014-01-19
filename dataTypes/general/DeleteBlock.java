package general;

import util.GenericDataType;


public class DeleteBlock extends GenericDataType {

	private int id;

	public DeleteBlock(int frame, int id) {
		super(frame, DataTypes.DELETE_BLOCK);
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
