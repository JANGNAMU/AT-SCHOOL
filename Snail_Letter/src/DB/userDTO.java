package DB;

public class userDTO {
	private String userID;
	private String userPW;
	private String userEmail;
	private String userGender;
	private String userBirth;
	private String userLoc;
	private String userName;
	private String userEmailHash;
	private boolean userEmailChecked;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserLoc() {
		return userLoc;
	}
	public void setUserLoc(String userLoc) {
		this.userLoc = userLoc;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailHash() {
		return userEmailHash;
	}
	public void setUserEmailHash(String userEmailHash) {
		this.userEmailHash = userEmailHash;
	}
	public boolean isUserEmailChecked() {
		return userEmailChecked;
	}
	public void setUserEmailChecked(boolean userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}
	
	public userDTO() {
		
	}
	
	public userDTO(String userID, String userPW, String userEmail, String userGender, String userBirth, String userLoc,
			String userName, String userEmailHash, boolean userEmailChecked) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userBirth = userBirth;
		this.userLoc = userLoc;
		this.userName = userName;
		this.userEmailHash = userEmailHash;
		this.userEmailChecked = userEmailChecked;
	}
	
	
}
