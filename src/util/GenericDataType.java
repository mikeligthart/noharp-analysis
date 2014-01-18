package util;



public abstract class GenericDataType {
	
	public static final String FRAME = "Frame";
	public static final String RECOGNIZER_KEYBOARD = "MouseLocDelta";
	public static final String RECOGNIZER_LEAP = "Hand";
	
	public enum DataTypes {
	    CREATE_BLOCK("CreateBlock"),
	    DELETE_BLOCK("DeleteBlock"),
	    END_DRAG_BLOCK("EndDragBlock"),
	    MOVE_BLOCK("MoveBlock"),
	    NEW_TASK("NewTask"),
	    START_DRAG_BLOCK("StartDragBlock"),
	    KEY_PRESS_LEFT("keyPressLeft"),
	    KEY_PRESS_RIGHT("KeyPressRight"),
	    MOUSE_CLICK("MouseClick"),
	    MOUSE_RELEASED("MouseReleased")
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
