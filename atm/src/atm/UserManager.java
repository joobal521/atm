package atm;

import java.util.ArrayList;


public class UserManager {
//Design Patter 설계 패턴
//싱글 인스턴스를 만드는
//Singleton Pattern을 사용해보자
	
	private ArrayList<User>list=new ArrayList<User>();
	
	//1)생성자를 숨긴다 private
	private UserManager() {
		
	}
	
	//2)클래스 내부에서 단일 인스턴스를 생성해준다
	private static UserManager instance=new UserManager();
	//static으로 
	
	//3)외부에서 단일 인스턴스를 참조할 수 있도록->getter를 제공한다
	public static UserManager getInstance() {//getter로 불러옴
		return instance;
	}

	public ArrayList<User>getList(){
		return (ArrayList<User>) this.list.clone();
	}
	
	//메소드
	//1)회원가입
	public void joinUser(){
		
		int userCode=generateRandomClde();//1-1 사용자코드 생성
		System.out.print("id:");
		String id=Atm.scanner.next();
		System.out.print("password:");
		String password=Atm.scanner.next();
		System.out.print("name:");
		String name= Atm.scanner.next();
		
		if(!duplId(id)){//1-2 아이디 중복체크
		User user= new User(userCode, name, id, password);
		this.list.add(user);
		System.out.println("회원가입 완료");
		}else {
		System.err.println("중복되는 아이디 입니다.");
		}
		
	}
	
	
	
	
	//1-1 사용자 코드 생성
	private int generateRandomClde() {
		int code=0;
		
		while(true) {
		code=(int)(Math.random()*9000)+1000;
		
		boolean dupl=false;
		for(User user: this.list) {
			if(user.getUsercode()==code) {
				dupl=true;
			}
		}
		
		if(!dupl) {
			break;
		}
		
		}
		
		return code;
	}
	
	//1-2 아이디 중복 체크
		private boolean duplId(String id) {
			boolean dupl=false;
			for(User user: this.list) {
				if(user.getId().equals(id)) {
					dupl=true;
				}
				
			}
			return dupl;
		}
		
	private void leaveUser() {
		//아이디를 입력하면 탈퇴
		System.out.print("id:");
		String id=Atm.scanner.next();
		
		for(int i=0; i<this.list.length; i++) {
			    if()
		}
		
		
	}
	
	
	
	
	
}//class끝
