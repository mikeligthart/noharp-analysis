package general;

import util.GenericDataType;


public class StartDragBlock extends GenericDataType {

	private int id;

	public StartDragBlock(int frame, int id) {
		super(frame, DataTypes.START_DRAG_BLOCK);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "StartDragBlock " + id;
	}

}
