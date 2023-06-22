package atm;

import java.util.ArrayList;

public class AccountManager {

	
	private ArrayList<Account>list =new ArrayList<Account>();
	
	private AccountManager(){}
	
	private static AccountManager instance =new AccountManager();
	
	public static AccountManager getInstance() {//외부에서 getter를 통해서 단일하게 존재하는 인스턴스 참조
		return instance;
	}
	
	
}
