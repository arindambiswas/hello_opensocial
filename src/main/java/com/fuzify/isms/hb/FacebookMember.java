package com.fuzify.isms.hb;
// Generated Jun 24, 2009 4:49:04 PM by Hibernate Tools 3.1.0.beta5



import javax.xml.bind.annotation.XmlRootElement;
/**
 * FacebookMember generated by hbm2java
 */
@XmlRootElement
public class FacebookMember  implements java.io.Serializable {

    // Fields    

     private int facebookMemberId;
     private Long memberId;
     private Long facebookId;

     // Constructors

    /** default constructor */
    public FacebookMember() {
    }

    /** full constructor */
    public FacebookMember(Long memberId, Long facebookId) {
       this.memberId = memberId;
       this.facebookId = facebookId;
    }
    
   
    // Property accessors
    public int getFacebookMemberId() {
        return this.facebookMemberId;
    }
    
    public void setFacebookMemberId(int facebookMemberId) {
        this.facebookMemberId = facebookMemberId;
    }
    public Long getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Long getFacebookId() {
        return this.facebookId;
    }
    
    public void setFacebookId(Long facebookId) {
        this.facebookId = facebookId;
    }




}


