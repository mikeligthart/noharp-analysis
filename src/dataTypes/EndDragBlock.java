package dataTypes;

public class EndDragBlock extends GenericDataType {

	private int id;

	public EndDragBlock(int frame, int id) {
		super(frame);
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
