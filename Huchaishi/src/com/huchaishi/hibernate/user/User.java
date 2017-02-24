package com.huchaishi.hibernate.user;



/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public User() {
    }

    
    /** full constructor */
    public User(String userName, String userPassword, String userQq, String realName, String cardId, String email, String phoneNum, String recommendUser, Double gold, Double taskGold, Integer blackUser, Integer userLevel) {
        super(userName, userPassword, userQq, realName, cardId, email, phoneNum, recommendUser, gold, taskGold, blackUser, userLevel);        
    }
   
}
