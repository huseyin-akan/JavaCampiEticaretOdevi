package DataAccess.concretes;

import DataAccess.abstracts.MemberDao;
import Entities.concretes.Member;

public class HibernateMemberDao implements MemberDao{

	@Override
	public void add(Member member) {
		System.out.println("Hibernate ile üye kaydı gerçekleşti : " + member.getFirstName());	
	}

	@Override
	public Boolean emailMevcutMu(String email) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
