/*
 * Author:Jason
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
@Table(name = "IS_OPEN")
public class Is_Open implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "OPEN_ID")
    private String openId;
    @Column(name = "RESTAURANT_ID")
    private String restaurantId;
    @Column(name = "MONDAY")
    private Integer monday;
    @Column(name = "TUESDAY")
    private Integer tuesday;
    @Column(name = "WEDNESDAY")
    private Integer wednesday;
    @Column(name = "THURSDAY")
    private Integer thursday;
    @Column(name = "FRIDAY")
    private Integer friday;
    @Column(name = "SATURDAY")
    private Integer saturday;
    @Column(name = "SUNDAY")
    private Integer sunday;

<<<<<<< HEAD
    
       public void update( Integer monday, Integer tuesday, Integer wednesday, Integer thursday, Integer friday, Integer saturday, Integer sunday) {
           
           this.setMonday(monday);
           this.setTuesday(tuesday);
           this.setWednesday(wednesday);
           this.setThursday(thursday);
           this.setFriday(friday);
           this.setSaturday(saturday);
           this.setSunday(sunday);
=======
    public void update(String openId, String restaurantId, Integer monday, Integer tuesday, Integer wednesday, Integer thursday, Integer friday, Integer saturday, Integer sunday) {
        this.setOpenId(openId);
        this.setRestaurantId(restaurantId);
        this.setMonday(monday);
        this.setTuesday(tuesday);
        this.setWednesday(wednesday);
        this.setThursday(thursday);
        this.setFriday(friday);
        this.setSaturday(saturday);
        this.setSunday(sunday);
>>>>>>> origin/master
    }

    /**
     * @return the openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId the openId to set
     */
    public void setOpenId(String openId) {
        this.openId = openId;
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
     * @return the monday
     */
    public Integer getMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(Integer monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesday
     */
    public Integer getTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday the tuesday to set
     */
    public void setTuesday(Integer tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return the wednesday
     */
    public Integer getWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday the wednesday to set
     */
    public void setWednesday(Integer wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return the thursday
     */
    public Integer getThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(Integer thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public Integer getFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(Integer friday) {
        this.friday = friday;
    }

    /**
     * @return the saturday
     */
    public Integer getSaturday() {
        return saturday;
    }

    /**
     * @param saturday the saturday to set
     */
    public void setSaturday(Integer saturday) {
        this.saturday = saturday;
    }

    /**
     * @return the sunday
     */
    public Integer getSunday() {
        return sunday;
    }

    /**
     * @param sunday the sunday to set
     */
    public void setSunday(Integer sunday) {
        this.sunday = sunday;
    }
<<<<<<< HEAD

   
   
=======
>>>>>>> origin/master

}
