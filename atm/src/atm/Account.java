package atm;

public class Account {
	
private int userCode;	//R
private int accNumber; //R -계좌번호
private int accPassword;//R 수정-계좌비번 
private int money;//수정
	



//#2생성자
public Account (int userCode, int accNumber, int accPassword) {
	this.userCode=userCode;
	this.accNumber=accNumber;
	this.accPassword=accPassword;
}


public Account (int userCode, int accNumber, int accPassword, int money) {
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
	return String.format("계좌번호:%d(%d) : %d", this.accNumber,this.accPassword,this.money);
	

	
}



	
}//class끝
