package com.wissensalt.rnd.simplealarm.model.data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = "schedules")
public class Schedule implements Serializable {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 5283940997955851903L;

    private Integer id;
    private String name;
    private String time;
    private Integer repeat;
    private Integer enabled;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    @Column(name = "is_repeat")
    public Integer getRepeat() {
        return repeat;
    }
   
    @Column(name = "schedule_time")    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    @Column(name = "enabled")
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Schedule{" + "id=" + id + ", name=" + name + ", time=" + time + ", repeat=" + repeat + ", enabled=" + enabled + '}';
    }
    
    
}
