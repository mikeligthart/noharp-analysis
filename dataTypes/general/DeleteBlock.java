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
		DeleteBlock other = (DeleteBlock) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
