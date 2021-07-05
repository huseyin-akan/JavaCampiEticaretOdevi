package Business.concretes;

import Business.abstracts.LoginService;
import Entities.concretes.Member;

public class LoginManager implements LoginService {

	@Override
	public Boolean login(Member member) {
		if(member.getEmail()!=null && member.getPassword() != null) {
			return true;
		}
		return false;
	}

}
