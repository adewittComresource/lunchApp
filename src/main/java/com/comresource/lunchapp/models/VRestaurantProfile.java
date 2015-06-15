/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comresource.lunchapp.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author LabUser1
 */
@Entity
@Table(name = "V_RESTAURANT_PROFILE")
public class VRestaurantProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "RESTAURANT_PROFILE_ID")
    private String restaurantProfileId;
    @Column(name = "RESTAURANT_ID")
    private String restaurantId;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "TIME_FACTOR")
    private float timeFactor;
    @Column(name = "COST_FACTOR")
    private float costFactor;
    @Column(name = "POST_LUNCH_FULLNESS_FACTOR")
    private float postLunchFullnessFactor;
    @Column(name = "DELICIOUSNESS_FACTOR")
    private float deliciousnessFactor;
    @Column(name = "POST_LUNCH_DISCOMFORT_FACTOR")
    private float postLunchDiscomfortFactor;
    @Column(name = "OPT_IN")
    private Integer optIn;

    /**
     * @return the restaurantProfileId
     */
    public String getRestaurantProfileId() {
        return restaurantProfileId;
    }

    /**
     * @param restaurantProfileId the restaurantProfileId to set
     */
    public void setRestaurantProfileId(String restaurantProfileId) {
        this.restaurantProfileId = restaurantProfileId;
    }

    /**
     * @return the restaurantId
     */
    public String getRestaurantId() {
        return restaurantId;
    }

    /**
     * @param restaurantId the restaurantId to set
     */
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the restaurantName
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     * @param restaurantName the restaurantName to set
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the timeFactor
     */
    public float getTimeFactor() {
        return timeFactor;
    }

    /**
     * @param timeFactor the timeFactor to set
     */
    public void setTimeFactor(float timeFactor) {
        this.timeFactor = timeFactor;
    }

    /**
     * @return the costFactor
     */
    public float getCostFactor() {
        return costFactor;
    }

    /**
     * @param costFactor the costFactor to set
     */
    public void setCostFactor(float costFactor) {
        this.costFactor = costFactor;
    }

    /**
     * @return the postLunchFullnessFactor
     */
    public float getPostLunchFullnessFactor() {
        return postLunchFullnessFactor;
    }

    /**
     * @param postLunchFullnessFactor the postLunchFullnessFactor to set
     */
    public void setPostLunchFullnessFactor(float postLunchFullnessFactor) {
        this.postLunchFullnessFactor = postLunchFullnessFactor;
    }

    /**
     * @return the deliciousnessFactor
     */
    public float getDeliciousnessFactor() {
        return deliciousnessFactor;
    }

    /**
     * @param deliciousnessFactor the deliciousnessFactor to set
     */
    public void setDeliciousnessFactor(float deliciousnessFactor) {
        this.deliciousnessFactor = deliciousnessFactor;
    }

    /**
     * @return the postLunchDiscomfortFactor
     */
    public float getPostLunchDiscomfortFactor() {
        return postLunchDiscomfortFactor;
    }

    /**
     * @param postLunchDiscomfortFactor the postLunchDiscomfortFactor to set
     */
    public void setPostLunchDiscomfortFactor(float postLunchDiscomfortFactor) {
        this.postLunchDiscomfortFactor = postLunchDiscomfortFactor;
    }

    /**
     * @return the optIn
     */
    public Integer getOptIn() {
        return optIn;
    }

    /**
     * @param optIn the optIn to set
     */
    public void setOptIn(Integer optIn) {
        this.optIn = optIn;
    }

}