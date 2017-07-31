package com.wissensalt.rnd.simplealarm.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ScheduleDTO implements Serializable{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 1218465804937122697L;

    private String name;
    private Date time;
    private int repeat;
    private int enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    
}
