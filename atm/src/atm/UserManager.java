package atm;

import java.util.ArrayList;

public class UserManager {
//Design Patter 설계 패턴
//싱글 인스턴스를 만드는
//Singleton Pattern을 사용해보자

	private AccountManager accManager = AccountManager.getInstance();
	private ArrayList<User> list = new ArrayList<User>(); // User객체를 담는 배열

	// 1)생성자를 숨긴다 private
	private UserManager() {

	}

	// 2)클래스 내부에서 단일 인스턴스를 생성해준다
	private static UserManager instance = new UserManager();
	// static으로

	// 3)외부에서 단일 인스턴스를 참조할 수 있도록->getter를 제공한다
	public static UserManager getInstance() {// getter로 불러옴
		return instance;
	}

	public ArrayList<User> getList() {
		return (ArrayList<User>) this.list.clone();
	}

	// 메소드
	// 1)회원가입
	public void joinUser() {

		int userCode = generateRandomClde();// 1-1 사용자코드 생성
		System.out.print("id:");
		String id = Atm.scanner.next();
		System.out.print("password:");
		String password = Atm.scanner.next();
		System.out.print("name:");
		String name = Atm.scanner.next();

		if (!duplId(id)) {// 1-2 아이디 중복체크
			User user = new User(userCode, name, id, password);
			this.list.add(user);
			accManager.createAccount(user);

			System.out.println("☆회원가입 완료");
		} else {
			System.err.println("★중복되는 아이디 입니다.");
		}

	}

	// 1-1 사용자 코드 생성
	private int generateRandomClde() {
		int code = 0;

		while (true) {
			code = (int) (Math.random() * 9000) + 1000;

			boolean dupl = false;
			for (User user : this.list) {// 향상된 for문
				if (user.getUsercode() == code) {
					dupl = true;
				}
			}

			if (!dupl) {
				break;
			}

		}

		return code;
	}

	// 유저 코드가 로그인겨~
	public User getUserByUserCode(int log) { // log:userCode
		for (User user : this.list) {
			if (user.getUsercode() == log) {
				return user;
			}
		}
		return null;
	}

	// 1-2 아이디 중복 체크
	private boolean duplId(String id) {
		boolean dupl = false;
		for (User user : this.list) {
			if (user.getId().equals(id)) {
				dupl = true;
			}

		}
		return dupl;
	}

	public void leaveUser() {
		// 로그인 상태
		// 아이디를 입력하면 탈퇴
		// if(isLogin())
		System.out.print("id:");
		String id = Atm.scanner.next();

		for (User user : this.list) {
			if (user.getId().equals(id)) {

			}
		}

	}

	// #3로그인
	public int loginUser(int log) {
		if(log!=0) {//이미 로그인 상태는 안됨
			System.out.println("★이미 로그인된 상태!!");
		}else {
		System.out.print("id: ");
		String id = Atm.scanner.next();
		System.out.print("password: ");
		String pwd = Atm.scanner.next();
		
		// 회원가입 정보와 일치하면!
				for (User user : this.list) {
					if (user.getId().equals(id) && user.getPassword().equals(pwd)) {
						log = user.getUsercode();
						System.out.println("☆로그인 완!");
					}else {
						System.out.println("★아이디와 비밀번호가 일치하지 않는겨~");
					}
				}
		}
		
	    return log;

	}

	// #로그아웃
	public int logoutUser(int log) {
		for (User user : this.list) {
			if (log == user.getUsercode()) {
				log =-1;
				System.out.println("로그아웃 완!");
			}
		}
		return log;
	}

}// class끝
