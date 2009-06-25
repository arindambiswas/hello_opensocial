package com.fuzify.isms.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuzify.isms.hb.Captcha;
import com.fuzify.isms.util.HibernateUtil;

public class CaptchaDAO
{
	Session session;
	public CaptchaDAO()
	{
		session = HibernateUtil.currentSession();
	}
	public Captcha create(Captcha captcha)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session.save(captcha);
			tx.commit();
			return captcha;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in CaptchaDAO.create() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public Captcha read(Captcha captcha)
	{
		try
		{
			String sql = "from Captcha where captchaId = " + captcha.getCaptchaId();
			Query query = session.createQuery(sql);
			session.flush();
			session.clear();
			return (Captcha) query.uniqueResult();
		} 
		catch (HibernateException e)
		{
			System.out.println("Exception in CaptchaDAO.read() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	
	public Captcha update(Captcha captcha)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.update(captcha);
			tx.commit();
			session.flush();
			session.clear();
			return captcha;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in CaptchaDAO.update() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
	public Captcha delete(Captcha captcha)
	{
		Transaction tx = session.beginTransaction();
		try
		{
			session = HibernateUtil.currentSession();
			session.delete(captcha);
			tx.commit();
			session.flush();
			session.clear();
			return captcha;
		} 
		catch (HibernateException e)
		{
			tx.rollback();
			System.out.println("Exception in CaptchaDAO.delete() .... Error : ");
			e.printStackTrace();
			return null;
		}
	}
}
