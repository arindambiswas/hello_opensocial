package com.fuzify.isms.hb;
// Generated Jun 24, 2009 4:49:04 PM by Hibernate Tools 3.1.0.beta5


import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Member generated by hbm2java
 */
@XmlRootElement
public class Member  implements java.io.Serializable {

    // Fields    

     private int memberId;
     private MemberStatus memberstatus;
     private String email;
     private int mobile;
     private String password;
     private Set membercontacts = new HashSet(0);

     // Constructors

    /** default constructor */
    public Member() {
    }

	/** minimal constructor */
    public Member(MemberStatus memberstatus, int mobile) {
        this.memberstatus = memberstatus;
        this.mobile = mobile;
    }
    /** full constructor */
    public Member(MemberStatus memberstatus, String email, int mobile, String password, Set membercontacts) {
       this.memberstatus = memberstatus;
       this.email = email;
       this.mobile = mobile;
       this.password = password;
       this.membercontacts = membercontacts;
    }
    
   
    // Property accessors
    public int getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public MemberStatus getMemberstatus() {
        return this.memberstatus;
    }
    
    public void setMemberstatus(MemberStatus memberstatus) {
        this.memberstatus = memberstatus;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getMobile() {
        return this.mobile;
    }
    
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getMembercontacts() {
        return this.membercontacts;
    }
    
    public void setMembercontacts(Set membercontacts) {
        this.membercontacts = membercontacts;
    }




}


