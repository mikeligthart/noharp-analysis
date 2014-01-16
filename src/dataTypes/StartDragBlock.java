package dataTypes;

public class StartDragBlock extends GenericDataType {

	private int id;

	public StartDragBlock(int frame, int id) {
		super(frame);
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
