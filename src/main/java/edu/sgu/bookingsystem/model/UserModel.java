package edu.sgu.bookingsystem.model;



public class UserModel {
	private long idUser;
	private String  userName;
	private String  passWord;
	private String fullNameUser;
	private String addressUser;
	private String phoneUser;
	private boolean statusUser;
	private RoleModel roleModel;
	public UserModel(long idUser, String userName, String passWord, String fullNameUser, String addressUser,
			String phoneUser, boolean statusUser, RoleModel roleModel) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.fullNameUser = fullNameUser;
		this.addressUser = addressUser;
		this.phoneUser = phoneUser;
		this.statusUser = statusUser;
		this.roleModel = roleModel;
	}
	public RoleModel getRoleModel() {
		return roleModel;
	}
	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	public UserModel() {
		super();
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getFullNameUser() {
		return fullNameUser;
	}

	public void setFullNameUser(String fullNameUser) {
		this.fullNameUser = fullNameUser;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public String getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}

	public boolean isStatusUser() {
		return statusUser;
	}

	public void setStatusUser(boolean statusUser) {
		this.statusUser = statusUser;
	}


}