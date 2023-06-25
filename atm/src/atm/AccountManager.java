package atm;

import java.util.ArrayList;

public class AccountManager {
    
	private UserManager userManager = UserManager.getInstance();//이거 추가
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
	
//#6. 계좌 철회	
public void deleteAcc(User user) {
	System.out.println("(띵동~) 고객님! 철회할 계좌를 골라주세요~");
	System.out.println(user.getAccs());
	int accNumber=Atm.inputNumber("계좌번호");
	int accPassword=Atm.inputNumber("계좌 비밀번호");
	//계좌번호 입력한 계좌를 삭제
	for(Account acc: this.list) {
		if(acc.getAccNumber()==accNumber &&acc.getAccPassword()==accPassword) {
			ArrayList<Account>accs= user.getAccs();
			accs.remove(acc);
			user.setAccs(accs);
		}
	}
    
	
}

//#7.계좌 조회
public void viewBalance(User user) {
	System.out.println("고객님의 현재 계좌는?");
	System.out.println(user.getAccs());
	
}

//#8.입금
public void inputMoney(User user) {
	System.out.println("고객님! 입금할겨~?");
	//여러개 계좌중에 하나선택
	//보여주기 용 계좌를 보여주기!
	System.out.println(user.getAccs());
	int accNumber=Atm.inputNumber("계좌 번호");//계좌번호 입력하고 돈을 입력하면 그 계좌번호의 돈이 증가! 그거를 setAccs 배열에 적용?
    int accPassword=Atm.inputNumber("계좌 비밀번호");
	
	
	
    for(Account acc: this.list) {
    if(acc.getAccNumber()==accNumber &&acc.getAccPassword()==accPassword) {	
    	System.out.print("금액을 입력:");
    	int money=Atm.scanner.nextInt(); //금액을 입력했어!
    	acc.setMoney(acc.getMoney()+money);	
    }
    }
    
    
	
	}

//#9출금
public void outMoney(User user) {
	System.out.println("고객님! 돈 뽑을겨~?");
	System.out.println(user.getAccs());
	int accNumber=Atm.inputNumber("계좌번호");
	int accPassword=Atm.inputNumber("계좌 비밀번호");

    for(Account acc: this.list) {
    if(acc.getAccNumber()==accNumber &&acc.getAccPassword()==accPassword) {	
    	System.out.print("금액을 입력:");
    	int money=Atm.scanner.nextInt(); //금액을 입력했어!
    	//예외 처리
    	if(acc.getMoney()<money) {
    		System.out.println("잔액 부족~");
    	}else {
    	acc.setMoney(acc.getMoney()-money);	
    	}
    }
    }
	
}

//#10이체
public void moveMoney(User user) {
	//현재 로그인된 유저가 이체할 상대 유저코드 입력해서 그 유저 계좌에서 또 계좌 번호 선택!
	int userCode=Atm.inputNumber("상대방 usercode");
	//상대방 계좌 보여주기!
//	for(User user: userManager.getList()) {
	if(user.getUserCode()==userCode) {
		System.out.println(user.getAccs());
	}
	
	
	
	
}







}//class끝
