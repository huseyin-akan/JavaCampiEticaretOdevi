package Business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Business.abstracts.MailService;
import Business.abstracts.MemberService;
import DataAccess.abstracts.MemberDao;
import Entities.concretes.Member;

public class MemberManager implements MemberService{
	private MemberDao memberDao;
	private MailService emailService;

	public MemberManager(MemberDao memberDao, MailService emailService) {
		super();
		this.memberDao = memberDao;
		this.emailService = emailService;
	}

	@Override
	public void add(Member member) {
		
		//Şifre en az 6 haneden oluşuyor mu?
		if(member.getPassword().length()<6) {
			System.out.println("Şifre 6 karakterden az olamaz.");
			return;
		}
		
		//Mail Formatı Uyuyor mu?
		String regex = "^(.+)@(.+)$";		 
		Pattern pattern = Pattern.compile(regex);		 
		
		Matcher matcher = pattern.matcher(member.getEmail());
		if(! matcher.matches() ) {
			System.out.println("Hatalı email kullanımı.");
			return;
		}
		
		//email daha önce kullanıldı mı?
		if(!memberDao.emailMevcutMu(member.getEmail())) {
			System.out.println("Email sistemde mevcut");
		}
		
		//ad soyad en az 2 karakter olmalı.
		if(member.getFirstName().length()<2 && member.getLastName().length()<2) {
			System.out.println("Ad Soyad 2 karakterden az olamaz.");
		}
		
		//bütün alanlar dolduruldu mu?		
		if(member.getEmail() != null && member.getFirstName() != null && member.getLastName() != null && member.getPassword()!= null) {
			memberDao.add(member);
			this.emailService.sendActivationLink(member.getEmail());
		}else {
			System.out.println("Üye ekleme işlemi yapılırken eksik veri girişi yapıldı.");
		}
		
	}
}
