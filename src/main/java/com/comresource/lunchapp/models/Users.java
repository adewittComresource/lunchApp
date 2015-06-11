package com.comresource.lunchapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users implements Serializable {
    @Id
    @Column(name = "USER_ID")
    private String userID;
    @Column(name = "USER_NAME")
    private String userName;

    //userID
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    //userName
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void update(String userId, String name) {
        this.userID = userId;
        this.userName = name;
        
    }
}
