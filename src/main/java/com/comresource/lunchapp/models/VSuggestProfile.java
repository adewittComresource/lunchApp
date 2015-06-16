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

@Entity
@Table(name = "V_SUGGEST_PROFILE")
public class VSuggestProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;    
    @Column(name = "SUGGEST_ID")
    private String suggestId;
    @Column(name = "RESTAURANT_ID")
    private String restaurantId;
    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;
    @Column(name = "SUGGEST_DATE")
    private String suggestDate;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "ZIP")
    private String zip;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "USER_ID")
    private String userId;
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
    @Column(name = "AVG_TIME_FACTOR")
    private float avgTimeFactor;
    @Column(name = "AVG_COST_FACTOR")
    private float avgCostFactor;
    @Column(name = "AVG_POST_LUNCH_FULLNESS_FACTOR")
    private float avgPostLunchFullnessFactor;
    @Column(name = "AVG_DELICIOUSNESS_FACTOR")
    private float avgDeliciousnessFactor;
    @Column(name = "AVG_POST_LUNCH_DISCOMFORT_FACTOR")
    private float avgPostLunchDiscomfortFactor;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * @return the suggestId
     */
    public String getSuggestId() {
        return suggestId;
    }
    /**
     * @param suggestId the suggestId to set
     */
    public void setSuggestId(String suggestId) {
        this.suggestId = suggestId;
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
     * @return the suggestDate
     */
    public String getSuggestDate() {
        return suggestDate;
    }
    /**
     * @param suggestDate the suggestDate to set
     */
    public void setSuggestDate(String suggestDate) {
        this.suggestDate = suggestDate;
    }
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }
    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    /**
     * @return the website
     */
    public String getWebsite() {
        return website;
    }
    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        this.website = website;
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

    /**
     * @return the avgTimeFactor
     */
    public float getAvgTimeFactor() {
        return avgTimeFactor;
    }

    /**
     * @param avgTimeFactor the avgTimeFactor to set
     */
    public void setAvgTimeFactor(float avgTimeFactor) {
        this.avgTimeFactor = avgTimeFactor;
    }

    /**
     * @return the avgCostFactor
     */
    public float getAvgCostFactor() {
        return avgCostFactor;
    }

    /**
     * @param avgCostFactor the avgCostFactor to set
     */
    public void setAvgCostFactor(float avgCostFactor) {
        this.avgCostFactor = avgCostFactor;
    }

    /**
     * @return the avgPostLunchFullnessFactor
     */
    public float getAvgPostLunchFullnessFactor() {
        return avgPostLunchFullnessFactor;
    }

    /**
     * @param avgPostLunchFullnessFactor the avgPostLunchFullnessFactor to set
     */
    public void setAvgPostLunchFullnessFactor(float avgPostLunchFullnessFactor) {
        this.avgPostLunchFullnessFactor = avgPostLunchFullnessFactor;
    }

    /**
     * @return the deliciousnessFactor
     */
    public float getAvgDeliciousnessFactor() {
        return avgDeliciousnessFactor;
    }
    /**
     * @param avgDeliciousnessFactor the avgDeliciousnessFactor to set
     */
    public void setAvgDeliciousnessFactor(float avgDeliciousnessFactor) {
        this.avgDeliciousnessFactor = deliciousnessFactor;
    }

    /**
     * @return the postLunchDiscomfortFactor
     */
    public float getAvgPostLunchDiscomfortFactor() {
        return avgPostLunchDiscomfortFactor;
    }

    /**
     * @param avgPostLunchDiscomfortFactor the avgPostLunchDiscomfortFactor to set
     */
    public void setAvgPostLunchDiscomfortFactor(float avgPostLunchDiscomfortFactor) {
        this.avgPostLunchDiscomfortFactor = avgPostLunchDiscomfortFactor;
    }
}
