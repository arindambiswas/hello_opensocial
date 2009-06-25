package com.fuzify.isms.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuzify.isms.hb.Captcha;
import com.fuzify.isms.hb.FacebookMember;
import com.fuzify.isms.hb.Member;
import com.fuzify.isms.util.HibernateUtil;

public class MemberDAO
{
	Session session;
	public MemberDAO()
	{
		session = HibernateUtil.currentSession();
	}
	public Member create(Member member)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(member);
			tx.commit();
			return member;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberDAO.create() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public Member read(Member member)
	{
		try
		{
			String sql = "from Member where memberId = " + member.getMemberId();
			Query query = session.createQuery(sql);
			session.flush();
			session.clear();
			return (Member) query.uniqueResult();
		} 
		catch (HibernateException e)
		{
			System.out.println("Exception in MemberDAO.read() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public Member update(Member member)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.update(member);
			tx.commit();
			session.flush();
			session.clear();
			return member;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberDAO.update() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	public Member delete(Member member)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.delete(member);
			tx.commit();
			session.flush();
			session.clear();
			return member;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberDAO.delete() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
}
