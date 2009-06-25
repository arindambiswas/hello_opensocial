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
import com.fuzify.isms.hb.MemberStatus;
import com.fuzify.isms.util.HibernateUtil;

public class MemberStatusDAO
{
	Session session;
	public MemberStatusDAO()
	{
		session = HibernateUtil.currentSession();
	}
	public MemberStatus create(MemberStatus memberStatus)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(memberStatus);
			tx.commit();
			return memberStatus;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberStatusDAO.create() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberStatus read(MemberStatus memberStatus)
	{
		try
		{
			String sql = "from MemberStatus where statusId = " + memberStatus.getStatusId();
			Query query = session.createQuery(sql);
			session.flush();
			session.clear();
			return (MemberStatus) query.uniqueResult();
		} 
		catch (HibernateException e)
		{
			System.out.println("Exception in MemberStatusDAO.read() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberStatus update(MemberStatus memberStatus)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.update(memberStatus);
			tx.commit();
			session.flush();
			session.clear();
			return memberStatus;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberStatusDAO.update() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	public MemberStatus delete(MemberStatus memberStatus)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.delete(memberStatus);
			tx.commit();
			session.flush();
			session.clear();
			return memberStatus;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in MemberStatusDAO.delete() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
}
