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
public class Is_Open {
    @Id
    @Column(name = "OPEN_ID")
    private String openId;
    @Column(name = "RESTAURANT_ID")
    private String restaurantId;
    @Column(name = "MONDAY")
    private int monday;
    @Column(name = "TUESDAY")
    private int tuesday;
    @Column(name = "WEDNESDAY")
    private int wednesday;
    @Column(name = "THURSDAY")
    private int thursday;
    @Column(name = "FRIDAY")
    private int friday;
    @Column(name = "SATURDAY")
    private int saturday;
    @Column(name = "SUNDAY")
    private int sunday;

    
       public void update(String openId, String restaurantId, int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        this.openId = openId;
        this.restaurantId = restaurantId;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday=friday;
        this.saturday=saturday;
        this.sunday=sunday;
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
    public int getMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(int monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesday
     */
    public int getTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday the tuesday to set
     */
    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return the wednesday
     */
    public int getWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday the wednesday to set
     */
    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return the thursday
     */
    public int getThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public int getFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(int friday) {
        this.friday = friday;
    }

    /**
     * @return the saturday
     */
    public int getSaturday() {
        return saturday;
    }

    /**
     * @param saturday the saturday to set
     */
    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    /**
     * @return the sunday
     */
    public int getSunday() {
        return sunday;
    }

    /**
     * @param sunday the sunday to set
     */
    public void setSunday(int sunday) {
        this.sunday = sunday;
    }

     
}
