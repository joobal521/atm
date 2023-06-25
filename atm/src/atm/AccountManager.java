package atm;

import java.util.ArrayList;

public class AccountManager {
    
	
	private ArrayList<Account>list =new ArrayList<Account>();
	//list.add(Account)
	//ㄴ 주소: A(해당 유저의 주소)
	//즐겨찾기 개념
	private AccountManager(){}
	
	private static AccountManager instance =new AccountManager();
	
	public static AccountManager getInstance() {//외부에서 getter를 통해서 단일하게 존재하는 인스턴스 참조
		return instance;
	}
	
	//유저 생성 시 새로운 계좌 자동 생성(하나는 생김)
	public void createAccount(User user) {
		Account acc=null;
		
		int accNumber=generateRandomCode();
		int accPassword=Atm.inputNumber("계좌 비밀번호");
		
		acc=new Account(user.getUserCode(), accNumber, accPassword);
		this.list.add(acc);
		
		//AccountManager의 list에 추가된 객체를 생성과 동시에 반환 받음
	    //->User 객체가 가진 acc 즐겨찾기 목록에도 추가
		ArrayList<Account>accs= user.getAccs();
		accs.add(acc);  
		user.setAccs(accs);
		  
		
	}
	

	private int generateRandomCode() {// ####-####
		int code=0;
		
		while(true) {
		code=(int)(Math.random()*9000)+1000;
		
		boolean dupl=false;
		for(Account acc: this.list) {
			if(acc.getUserCode()==code) {
				dupl=true;
			}
		}
		
		if(!dupl) {
			break;
		}
		
		}
		
		return code;
	}
	
//#	
public void deleteAcc(User user) {
	System.out.println("(띵동~) 고객님! 철회할 계좌를 골라주세요~");
	System.out.println(user.getAccs());
	
}

//#7.계좌 조회
public void viewBalance(User user) {
	System.out.println("고객님의 현재 계좌는?");
	System.out.println(user.getAccs());
	
	System.out.println("확인용");
	System.out.println(this.list);
}

//#8.입금
public void inputMoney(User user, Account acc) {
	System.out.println("고객님! 입금할겨~?");
	//여러개 계좌중에 하나선택
	int num=Atm.inputNumber("계좌 번호");
    //for(int i=0; i<user.getAccs(); i++) {
    	
 //   }
	System.out.print("금액을 입력:");
	int money=Atm.scanner.nextInt(); //금액을 입력했어!
	
    acc.setMoney(money);
    
    System.out.println("확인용");
    System.out.println(this.list);
    
	
	
	
}
}//class끝
