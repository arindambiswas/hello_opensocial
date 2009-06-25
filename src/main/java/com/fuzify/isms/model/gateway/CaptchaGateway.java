package com.fuzify.isms.model.gateway;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.fuzify.isms.hb.Captcha;
import com.fuzify.isms.util.HibernateUtil;

public class CaptchaGateway
{
	Session session;
	String listQuery;
	String countQuery;
	public CaptchaGateway()
	{
		session = HibernateUtil.currentSession();
	}
}
