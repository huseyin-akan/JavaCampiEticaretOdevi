package Business.concretes;

import Business.abstracts.MailService;
import Entities.concretes.Member;

public class EmailManager implements MailService {

	@Override
	public void sendActivationLink(String mail) {
		System.out.println(mail + " adresine aktivasyon kodu gönderildi.");
		
	}

	@Override
	public Boolean activateRegistration(String token, Member member) {

		// aktivasyon şart kodları sağlandıysa		
		return true;
	}

}
