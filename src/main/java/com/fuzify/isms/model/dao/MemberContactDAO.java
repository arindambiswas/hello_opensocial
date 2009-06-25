package com.fuzify.isms.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuzify.isms.hb.Captcha;
import com.fuzify.isms.hb.FacebookMember;
import com.fuzify.isms.hb.Member;
import com.fuzify.isms.hb.MemberContact;
import com.fuzify.isms.util.HibernateUtil;

public class MemberContactDAO
{
	Session session;
	public MemberContactDAO()
	{
		session = HibernateUtil.currentSession();
	}
	public MemberContact create(MemberContact memberContact)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(memberContact);
			tx.commit();
			return memberContact;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberContactDAO.create() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberContact read(MemberContact memberContact)
	{
		try
		{
			String sql = "from MemberContact where memberContactId = " + memberContact.getMemberContactId();
			Query query = session.createQuery(sql);
			session.flush();
			session.clear();
			return (MemberContact) query.uniqueResult();
		} 
		catch (HibernateException e)
		{
			System.out.println("Exception in MemberContactDAO.read() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberContact update(MemberContact memberContact)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.update(memberContact);
			tx.commit();
			session.flush();
			session.clear();
			return memberContact;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberContactDAO.update() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	public MemberContact delete(MemberContact memberContact)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.delete(memberContact);
			tx.commit();
			session.flush();
			session.clear();
			return memberContact;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberContactDAO.delete() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
}
