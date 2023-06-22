package atm;

import java.util.ArrayList;

public class User {

	// #1.필드
	private int userCode; // R
	private String name; // R
	private String id; // R
	private String password;// R 수정 가능
	private int age; // 수정가능
	private ArrayList<Account> accs;// 수정가능

	// #.2생성자
	public User(int userCode, String name, String id, String password) {
		this.accs=new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;

	}

	public User(int userCode, String name, String id, String password, int age) {
		this.accs=new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;

	}

	public User(int userCode, String name, String id, String password, int age, ArrayList<Account> accs) {
		this.accs=new ArrayList<Account>();
		
		this.userCode = userCode;
		this.name = name;
		this.id = id;
		this.password = password;
		this.age = age;
		this.accs = accs;

	}

	// getter
	public int getUsercode() {
		return this.userCode;
	}

	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Account> getAccs() {
		return (ArrayList<Account>) this.accs.clone();// 복제본 제공
	}

	public void setAccs(ArrayList<Account> accs) {
		this.accs = accs;// 복제본 제공
	}
	
	@Override
	public String toString() {
		String str=String.format("%s(%d) : %s/%s\n", this.name,this.userCode,this.id,this.password);
		
		
		for(int i=0; i<this.accs.size(); i++) {
			str+="\n"+this.accs.get(i);
				
		}
		return str;
		
	}

	/*
	 *  name(userCode) : id/password
	 * ㄴaccNumber1(pasword): balance1
	 * ㄴaccNumber2(pasword): balance2
	 * ㄴaccNumber3(pasword): balance3
	 * ㄴaccNumber4(pasword): balance4
	 */
	
	
	
	
	
}//class끝