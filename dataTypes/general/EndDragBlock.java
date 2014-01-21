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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EndDragBlock other = (EndDragBlock) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
