package com.fuzify.isms.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuzify.isms.hb.Captcha;
import com.fuzify.isms.hb.FacebookMember;
import com.fuzify.isms.hb.Member;
import com.fuzify.isms.hb.MemberContact;
import com.fuzify.isms.hb.MemberMessage;
import com.fuzify.isms.util.HibernateUtil;

public class MemberMessageDAO
{
	Session session;
	public MemberMessageDAO()
	{
		session = HibernateUtil.currentSession();
	}
	public MemberMessage create(MemberMessage memberMessage)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(memberMessage);
			tx.commit();
			return memberMessage;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberMessageDAO.create() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberMessage read(MemberMessage memberMessage)
	{
		try
		{
			String sql = "from MemberMessage where memberMessageId = " + memberMessage.getMemberMessageId();
			Query query = session.createQuery(sql);
			session.flush();
			session.clear();
			return (MemberMessage) query.uniqueResult();
		} 
		catch (HibernateException e)
		{
			System.out.println("Exception in MemberMessageDAO.read() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberMessage update(MemberMessage memberMessage)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.update(memberMessage);
			tx.commit();
			session.flush();
			session.clear();
			return memberMessage;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberMessageDAO.update() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	public MemberMessage delete(MemberMessage memberMessage)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.delete(memberMessage);
			tx.commit();
			session.flush();
			session.clear();
			return memberMessage;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberMessageDAO.delete() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
}
