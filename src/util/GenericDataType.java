package util;

public abstract class GenericDataType {
	
	private int frame;
	
	public GenericDataType(int frame){
		this.frame = frame;
	}
	
	public int getFrame(){
		return frame;
	}
	
	@Override
	public abstract String toString();
}
