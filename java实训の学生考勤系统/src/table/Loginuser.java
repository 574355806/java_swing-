package table;

public class Loginuser {            //��¼���ڵ��û�
	private String name;
	private String password;
	public Loginuser(String name,String password){
		this.name=name;
		this.password=password ;
	}

	public String getUserName() {        
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
