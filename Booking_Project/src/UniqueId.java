
public class UniqueId {
	private boolean flag = false;
	private String uniqueID;
	

	public void run() {
		// Creates a manager object.
		DBManager manager = new DBManager();
		// Keeps on generating the createId method until flag is true;
		while(!flag) {
		String id = createId();
		// Using the query in the database class it compares the generated ID's to existing ID's and stores a boolean result.
		boolean result = manager.CheckUniqueId(id);
		if(result) {
			// set flag to true and exits the loop.
			flag = true;
			this.uniqueID = id;
		}
		}
	}
	
	private String createId() {
		 // Using a StringBuild it randomly picks the numbers from the variable.
	    int n = 6;
	    String AlphaNumericString = "01234567899876543210" ;                    
	    StringBuilder sb = new StringBuilder(n); 
	 // It has 6 looping iterations.
	    for (int i = 0; i < n; i++) { 
	    	//Creates a random number.
	    int index = (int)(AlphaNumericString.length() * Math.random()); 
	    //Grabs the index that the number corresponds to.
	    sb.append(AlphaNumericString.charAt(index)); 
	        } 
	    return sb.toString(); 
	    
	    }
	
	public String getUniqueID() {
		return this.uniqueID;
	}

}
