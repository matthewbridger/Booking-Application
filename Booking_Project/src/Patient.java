
public class Patient {
	private String userId;
	private String password;
	private String uniqueId;
	private String doctorName;
	private boolean isLoggedIn;
	
	public Patient(String uID, String pass, String id) {
		this.userId = uID;
		this.password = pass;
		this.uniqueId = id;
	}
	
	public Patient(String uID, String pass, String uId, String doc) {
		this.userId = uID;
		this.password = pass;
		this.uniqueId = uId;
		this.doctorName = doc;
	}
	
	public String getUniqueId() {
	    return uniqueId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String name) {
		this.doctorName = name;
	}
	
	public boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedInd(boolean b) {
		this.isLoggedIn = b;
	}
	

}
