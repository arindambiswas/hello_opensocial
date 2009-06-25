package com.fuzify.isms.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuzify.isms.hb.Captcha;
import com.fuzify.isms.hb.FacebookMember;
import com.fuzify.isms.util.HibernateUtil;

public class FacebookMemberDAO
{
	Session session;
	public FacebookMemberDAO()
	{
		session = HibernateUtil.currentSession();
	}
	public FacebookMember create(FacebookMember facebookMember)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(facebookMember);
			tx.commit();
			return facebookMember;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in FacebookMemberDAO.create() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public FacebookMember read(FacebookMember facebookMember)
	{
		try
		{
			String sql = "from FacebookMember where facebookMemberId = " + facebookMember.getFacebookMemberId();
			Query query = session.createQuery(sql);
			session.flush();
			session.clear();
			return (FacebookMember) query.uniqueResult();
		} 
		catch (HibernateException e)
		{
			System.out.println("Exception in FacebookMemberDAO.read() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public FacebookMember update(FacebookMember facebookMember)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.update(facebookMember);
			tx.commit();
			session.flush();
			session.clear();
			return facebookMember;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in FacebookMemberDAO.update() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	public FacebookMember delete(FacebookMember facebookMember)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.delete(facebookMember);
			tx.commit();
			session.flush();
			session.clear();
			return facebookMember;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in FacebookMemberDAO.delete() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
}
