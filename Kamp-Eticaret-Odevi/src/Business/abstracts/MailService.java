package Business.abstracts;

import Entities.concretes.Member;

public interface MailService {
	void sendActivationLink(String mail);
	
	Boolean activateRegistration(String token, Member member);
}
