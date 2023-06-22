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
	
	
	//메소드
	public void joinUser(){
		
		int userCode=generateRandomClde();
		System.out.print("id:");
		String id=Atm.scanner.next();
		System.out.print("password:");
		String password=Atm.scanner.next();
		System.out.print("name:");
		String name= Atm.scanner.next();
		if(!duplId(id)) {
		User user= new User(userCode, name, id, password);
		this.list.add(user);
		System.out.println("회원가입 완료");
		}else {
		System.err.println("중복되는 아이디 입니다.");
		}
	}
	
	public ArrayList<User>getList(){
		return (ArrayList<User>) this.list.clone();
	}
	
	private boolean duplId(String id) {
		boolean dupl=false;
		for(User user: this.list) {
			if(user.getId().equals(id)) {
				dupl=true;
			}
			
		}
		return dupl;
	}
	
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
	
	
	
	
	
	
}//class끝