package DataAccess.abstracts;

import Entities.concretes.Member;

public interface MemberDao {
	void add(Member member);
	
	Boolean emailMevcutMu(String email);
}
