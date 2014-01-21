package util;



public abstract class GenericDataType {
	
	public static final String FRAME = "Frame";
	
	public enum DataTypes {
	    CREATE_BLOCK("CreateBlock"),
	    DELETE_BLOCK("DeleteBlock"),
	    END_DRAG_BLOCK("EndDragBlock"),
	    MOVE_BLOCK("MoveBlock"),
	    NEW_TASK("NewTask"),
	    START_DRAG_BLOCK("StartDragBlock"),
	    KEY_PRESS_LEFT("keyPressLeft"),
	    KEY_PRESS_RIGHT("KeyPressRight"),
	    KEY_PRESS_UP("KeyPressUp"),
	    KEY_PRESS_DOWN("KeyPressDown"),
	    MOUSE_CLICK("MouseClick"),
	    MOUSE_LOC_DELTA("MouseLocDelta"),
	    MOUSE_RELEASED("MouseReleased"),
	    FINGER("Finger"),
	    GRABBED("Grabbed"),
	    HAND("Hand"),
	    SWIPEDVERTICAL("SwipedVertical"),
	    SWIPEDHORIZONTAL("SwipedHorizontal")
	    ;
	    /**
	     * @param text
	     */
	    private DataTypes(final String text) {
	        this.text = text;
	    }

	    private final String text;
	    
	    public static DataTypes getRightDataType(String name){
	    	for (DataTypes dt: DataTypes.values()){
	    		if (name.contentEquals(dt.toString())){
	    			return dt;
	    		}
	    	}
	    	return null;
	    }
	    @Override
	    public String toString() {
	        return text;
	    }
	}	
	
	protected int frame;
	private DataTypes name;
	
	public GenericDataType(int frame, DataTypes name){
		this.frame = frame;
		this.name = name;
	}
	
	public int getFrame(){
		return frame;
	}
	
	public DataTypes getName(){
		return name;
	}
		
	@Override
	public abstract String toString();
	
	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object object);
	
	
}
