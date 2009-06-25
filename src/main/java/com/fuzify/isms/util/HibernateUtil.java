package com.fuzify.isms.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fuzify.isms.hb.*;


public class HibernateUtil 
{

    private static Log log = LogFactory.getLog(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
    		Configuration cfg = new Configuration();
        	cfg.addClass(Captcha.class);
        	cfg.addClass(FacebookMember.class);
        	cfg.addClass(Member.class);
        	cfg.addClass(MemberContact.class);
        	cfg.addClass(MemberMessage.class);
        	cfg.addClass(MemberStatus.class);
        	cfg.addClass(OrkutMember.class);
            sessionFactory = cfg.buildSessionFactory(); 
        } catch (Throwable ex) {         
        	log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);           
        } 
        
    } 

    @SuppressWarnings("unchecked")
	public static final ThreadLocal threadSession = new ThreadLocal();
    @SuppressWarnings("unchecked")
	public static final ThreadLocal threadTransaction = new ThreadLocal();

    @SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException {       
        Session s = (Session) threadSession.get();
        
        // Open a new Session, if this Thread has none yet
        if (s == null || s.isOpen() == false) {
            s = sessionFactory.openSession();
            threadSession.set(s);
        }
        return s;
    }

    @SuppressWarnings("unchecked")
	public static void exitSession() throws HibernateException {
        Session s = (Session) threadSession.get();
        threadSession.set(null);
        if (s != null && s.isOpen())
            s.close();
    } 

    public static void closeSession() throws HibernateException {
    	/* deprecated... shouldn't be called anymore */
    } 

    @SuppressWarnings("unchecked")
	public static void beginTransaction() {
        Transaction tx = (Transaction) threadTransaction.get();
        if (tx == null) {
            tx = currentSession().beginTransaction();
            threadTransaction.set(tx);
        }            
    }
    
    @SuppressWarnings("unchecked")
	public static void commitTransaction() {
        Transaction tx = (Transaction) threadTransaction.get();
        if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
            tx.commit();
        threadTransaction.set(null);
    }
    
    @SuppressWarnings("unchecked")
	public static void rollbackTransaction() {
        Transaction tx = (Transaction) threadTransaction.get();
        threadTransaction.set(null);
        if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()) 
            tx.rollback();
        closeSession();
    }
    
} 
