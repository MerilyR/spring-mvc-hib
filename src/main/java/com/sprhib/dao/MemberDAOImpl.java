package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addMember(Member member) {
		getCurrentSession().save(member);
	}

	public void updateMember(Member member) {
		Member memberToUpdate = getMember(member.getId());
		memberToUpdate.setName(member.getName());
		//System.out.println(member.getTeams());
		memberToUpdate.setTeams(member.getTeams());
		getCurrentSession().update(memberToUpdate);
	}

	public Member getMember(int id) {
		Member member = (Member) getCurrentSession().get(Member.class, id);
		return member;
	}

	public void deleteMember(int id) {
		Member member = getMember(id);
		if (member != null)
			getCurrentSession().delete(member);
	}

	@SuppressWarnings("unchecked")
	public List<Member> getMembers() {
		return getCurrentSession().createQuery("from Member").list();
	}
	
}
