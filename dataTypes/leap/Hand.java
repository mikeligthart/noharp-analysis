package leap;

import util.GenericDataType;

public class Hand extends GenericDataType {

	private int id;
	private boolean isLeft;

	public Hand(int frame, int id, boolean isLeft) {
		super(frame, DataTypes.HAND);
		this.id = id;
		this.isLeft = isLeft;
	}

	public int getId() {
		return id;
	}
	
	public boolean isLeft(){
		return isLeft;
	}

	@Override
	public String toString() {
		return "Hand " + id + " " + isLeft;

	}

}
