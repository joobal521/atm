package atm;

public class Account {
	
private int userCode;	//R
private int accNumber; //R
private int accPassword;//R 수정
private int money;//수정
	



//#2생성자
public Account (int userCode, int accNumber, int accPasswrod) {
	this.userCode=userCode;
	this.accNumber=accNumber;
	this.accPassword=accPassword;
}


public Account (int userCode, int accNumber, int accPasswrod, int money) {
	this.userCode=userCode;
	this.accNumber=accNumber;
	this.accPassword=accPassword;
	this.money=money;
}


//getter
public int getUserCode() {
	return this.userCode;
}

public int getAccNumber() {
	return this.accNumber;
}


public int getAccPassword() {
	return this.accPassword;
}

public void setAccPassword(int accPassword) {
	this.accPassword=accPassword;
}

public int getMoney() {
	return this.money;
}
public void setMoney(int money) {
	this.money=money;
}

@Override
public String toString() {
	return String.format("%d(%d) : %d", this.accNumber,this.accPassword);
	

	
}



	
}//class끝
