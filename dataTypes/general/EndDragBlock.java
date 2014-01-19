package general;

import util.GenericDataType;


public class EndDragBlock extends GenericDataType {

	private int id;

	public EndDragBlock(int frame, int id) {
		super(frame, DataTypes.END_DRAG_BLOCK);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "EndDragBlock " + id;
	}

}
