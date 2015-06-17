package com.comresource.lunchapp.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_SUGGEST_PROFILE")
public class VSuggestProfile
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Column(name="ID")
  private String id;
  @Column(name="SUGGEST_ID")
  private String suggestId;
  @Column(name="RESTAURANT_ID")
  private String restaurantId;
  @Column(name="RESTAURANT_NAME")
  private String restaurantName;
  @Column(name="SUGGEST_DATE")
  private String suggestDate;
  @Column(name="CITY")
  private String city;
  @Column(name="STATE")
  private String state;
  @Column(name="ADDRESS")
  private String address;
  @Column(name="ZIP")
  private String zip;
  @Column(name="WEBSITE")
  private String website;
  @Column(name="USER_ID")
  private String userId;
  @Column(name="USER_NAME")
  private String userName;
  @Column(name="TIME_FACTOR")
  private float timeFactor;
  @Column(name="COST_FACTOR")
  private float costFactor;
  @Column(name="POST_LUNCH_FULLNESS_FACTOR")
  private float postLunchFullnessFactor;
  @Column(name="DELICIOUSNESS_FACTOR")
  private float deliciousnessFactor;
  @Column(name="POST_LUNCH_DISCOMFORT_FACTOR")
  private float postLunchDiscomfortFactor;
  @Column(name="OPT_IN")
  private Integer optIn;
  @Column(name="AVG_TIME_FACTOR")
  private float avgTimeFactor;
  @Column(name="AVG_COST_FACTOR")
  private float avgCostFactor;
  @Column(name="AVG_POST_LUNCH_FULLNESS_FACTOR")
  private float avgPostLunchFullnessFactor;
  @Column(name="AVG_DELICIOUSNESS_FACTOR")
  private float avgDeliciousnessFactor;
  @Column(name="AVG_POST_LUNCH_DISCOMFORT_FACTOR")
  private float avgPostLunchDiscomfortFactor;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getSuggestId()
  {
    return this.suggestId;
  }
  
  public void setSuggestId(String suggestId)
  {
    this.suggestId = suggestId;
  }
  
  public String getRestaurantId()
  {
    return this.restaurantId;
  }
  
  public void setRestaurantId(String restaurantId)
  {
    this.restaurantId = restaurantId;
  }
  
  public String getRestaurantName()
  {
    return this.restaurantName;
  }
  
  public void setRestaurantName(String restaurantName)
  {
    this.restaurantName = restaurantName;
  }
  
  public String getSuggestDate()
  {
    return this.suggestDate;
  }
  
  public void setSuggestDate(String suggestDate)
  {
    this.suggestDate = suggestDate;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public void setCity(String city)
  {
    this.city = city;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public String getZip()
  {
    return this.zip;
  }
  
  public void setZip(String zip)
  {
    this.zip = zip;
  }
  
  public String getWebsite()
  {
    return this.website;
  }
  
  public void setWebsite(String website)
  {
    this.website = website;
  }
  
  public String getUserId()
  {
    return this.userId;
  }
  
  public void setUserId(String userId)
  {
    this.userId = userId;
  }
  
  public float getTimeFactor()
  {
    return this.timeFactor;
  }
  
  public void setTimeFactor(float timeFactor)
  {
    this.timeFactor = timeFactor;
  }
  
  public float getCostFactor()
  {
    return this.costFactor;
  }
  
  public void setCostFactor(float costFactor)
  {
    this.costFactor = costFactor;
  }
  
  public float getPostLunchFullnessFactor()
  {
    return this.postLunchFullnessFactor;
  }
  
  public void setPostLunchFullnessFactor(float postLunchFullnessFactor)
  {
    this.postLunchFullnessFactor = postLunchFullnessFactor;
  }
  
  public float getDeliciousnessFactor()
  {
    return this.deliciousnessFactor;
  }
  
  public void setDeliciousnessFactor(float deliciousnessFactor)
  {
    this.deliciousnessFactor = deliciousnessFactor;
  }
  
  public float getPostLunchDiscomfortFactor()
  {
    return this.postLunchDiscomfortFactor;
  }
  
  public void setPostLunchDiscomfortFactor(float postLunchDiscomfortFactor)
  {
    this.postLunchDiscomfortFactor = postLunchDiscomfortFactor;
  }
  
  public Integer getOptIn()
  {
    return this.optIn;
  }
  
  public void setOptIn(Integer optIn)
  {
    this.optIn = optIn;
  }
  
  public float getAvgTimeFactor()
  {
    return this.avgTimeFactor;
  }
  
  public void setAvgTimeFactor(float avgTimeFactor)
  {
    this.avgTimeFactor = avgTimeFactor;
  }
  
  public float getAvgCostFactor()
  {
    return this.avgCostFactor;
  }
  
  public void setAvgCostFactor(float avgCostFactor)
  {
    this.avgCostFactor = avgCostFactor;
  }
  
  public float getAvgPostLunchFullnessFactor()
  {
    return this.avgPostLunchFullnessFactor;
  }
  
  public void setAvgPostLunchFullnessFactor(float avgPostLunchFullnessFactor)
  {
    this.avgPostLunchFullnessFactor = avgPostLunchFullnessFactor;
  }
  
  public float getAvgDeliciousnessFactor()
  {
    return this.avgDeliciousnessFactor;
  }
  
  public void setAvgDeliciousnessFactor(float avgDeliciousnessFactor)
  {
    this.avgDeliciousnessFactor = this.deliciousnessFactor;
  }
  
  public float getAvgPostLunchDiscomfortFactor()
  {
    return this.avgPostLunchDiscomfortFactor;
  }
  
  public void setAvgPostLunchDiscomfortFactor(float avgPostLunchDiscomfortFactor)
  {
    this.avgPostLunchDiscomfortFactor = avgPostLunchDiscomfortFactor;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}
