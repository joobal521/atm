package atm;

import java.util.Scanner;

public class Atm {

	final int JOIN = 1;
	final int LEAVE = 2;
	final int LOGIN = 3;
	final int LOGOUT = 4;
	final int CREATE_ACC = 5;
	final int DELETE_ACC = 6;
	final int VIEW_BALANCE = 7;
	final int INPUT_MONEY = 8;
	final int OUT_MONEY = 9;
	final int MOVE_MONEY = 10;
	final int SAVE_FILE = 11;
	final int LOAD_FILE = 12;
	final int QUIT = 13;

	public static final Scanner scanner = new Scanner(System.in);// 다른 클래스에서도 공유
	private String brandName;

	private UserManager userManager;
	private AccountManager accManager;
	private FileManager fileManager;

	private int log = 0;

	public Atm(String brandName) {
		this.brandName = brandName;

		this.userManager = UserManager.getInstance();
		this.accManager = AccountManager.getInstance();
		this.fileManager = FileManager.getInstance();
	}

	private void printMenu() {
		System.out.printf("---%s BANK ---\n", this.brandName);
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.로그인");
		System.out.println("4.로그아웃");
		System.out.println("5.계좌개설");
		System.out.println("6.계좌철회");
		System.out.println("7.계좌조회");
		System.out.println("8.입금");
		System.out.println("9.출금");
		System.out.println("10.이체");
		System.out.println("11.파일저장");
		System.out.println("12.파일로드");
		System.out.println("13.종료");

	}

	public static int inputNumber(String msg) {
		System.out.print(msg + ":");
		String input = Atm.scanner.next();

		int number = -1;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자 입력만 가능합ㄴ디ㅏ.");
		}
		return number;
	}

	private void printAlldata() {
		System.out.println("검증용");
		for (User user : userManager.getList()) {
			System.out.println(user);
		}
		// 확인용
		System.out.println("로그인 된 회원" + this.log);
	}

	
	public void run() {
        //UserManager um1=UserManager.getInstance();//해당 객체에 접근할 수 있게
		
       while(true) {
    	   
    	   printAlldata();//검토용
    	   printMenu();
    	   int select=inputNumber("메뉴");
    	  if(log==0) {
    	   if(select==JOIN) {
    		   userManager.joinUser();
    	   } else if(select==LOGIN) {
    	   		  this.log=userManager.loginUser(this.log);
    	   }
    	   
  	        }else {
    	  if(select==LEAVE) {
  	      
  	        
 		    this.log=userManager.leaveUser(this.log);
  		   
   	
   	   }else if(select==LOGOUT) {
   		  this.log=userManager.logoutUser(this.log);    	  
   	   }else if(select==CREATE_ACC) { 
   		   if(log!=0) {
    	accManager.createAccount(userManager.getUserByUserCode(this.log));    	   
    	 }else {
    		 System.out.println("★계좌생성 불가");
    	 }
    	}else if(select==DELETE_ACC){
 	   accManager.deleteAcc(userManager.getUserByUserCode(this.log));
  	       }else if(select==VIEW_BALANCE){
  	    	   accManager.viewBalance(userManager.getUserByUserCode(this.log)); 
  	   }else if(select==INPUT_MONEY){
  		   accManager.inputMoney(userManager.getUserByUserCode(this.log));
    	   }else if(select==OUT_MONEY){       
    		   accManager.outMoney(userManager.getUserByUserCode(this.log));
  	   }else if(select==MOVE_MONEY){
    		   accManager.moveMoney(userManager.getUserByUserCode(this.log));
//    	   }else if(select==SAVE_FILE){
//    		   fileManager.saveFile()
//   	      }else if(select==LOAD_FILE){
//    		   fileManager.loadFile();
   	   }else if(select==QUIT){
    		   break;
    	   }
    	   }
       }//while끝
    	   
       
       

       }//run끝

}
// class끝
