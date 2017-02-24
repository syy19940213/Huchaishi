package com.huchaishi.hibernate.user;



/**
 * AbstractUser entity provides the base persistence definition of the User entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUser  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String userName;
     private String userPassword;
     private String userQq;
     private String realName;
     private String cardId;
     private String email;
     private String phoneNum;
     private String recommendUser;
     private Double gold;
     private Double taskGold;
     private Integer blackUser;
     private Integer userLevel;


    // Constructors

    /** default constructor */
    public AbstractUser() {
    }

    
    /** full constructor */
    public AbstractUser(String userName, String userPassword, String userQq, String realName, String cardId, String email, String phoneNum, String recommendUser, Double gold, Double taskGold, Integer blackUser, Integer userLevel) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userQq = userQq;
        this.realName = realName;
        this.cardId = cardId;
        this.email = email;
        this.phoneNum = phoneNum;
        this.recommendUser = recommendUser;
        this.gold = gold;
        this.taskGold = taskGold;
        this.blackUser = blackUser;
        this.userLevel = userLevel;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserQq() {
        return this.userQq;
    }
    
    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }

    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardId() {
        return this.cardId;
    }
    
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRecommendUser() {
        return this.recommendUser;
    }
    
    public void setRecommendUser(String recommendUser) {
        this.recommendUser = recommendUser;
    }

    public Double getGold() {
        return this.gold;
    }
    
    public void setGold(Double gold) {
        this.gold = gold;
    }

    public Double getTaskGold() {
        return this.taskGold;
    }
    
    public void setTaskGold(Double taskGold) {
        this.taskGold = taskGold;
    }

    public Integer getBlackUser() {
        return this.blackUser;
    }
    
    public void setBlackUser(Integer blackUser) {
        this.blackUser = blackUser;
    }

    public Integer getUserLevel() {
        return this.userLevel;
    }
    
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
   








}