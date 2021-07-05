package core;

import Entities.concretes.Member;
import GoogleAccountManager.GoogleAccountManager;

public class GoogleAccountManagerAdapter implements OutsourceRegistrationService{

	@Override
	public void add(Member member) {
		GoogleAccountManager manager = new GoogleAccountManager();
		manager.add(member);		
	}

}
