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
		CreateBlock other = (CreateBlock) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
