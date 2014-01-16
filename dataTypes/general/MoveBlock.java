package general;

import util.GenericDataType;


public class MoveBlock extends GenericDataType {

	private int id;
	private double x, y, z;

	public MoveBlock(int frame, int id, double x, double y, double z) {
		super(frame);
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getId() {
		return id;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public String toString() {
		return "MoveBlock " + id;
	}

}
