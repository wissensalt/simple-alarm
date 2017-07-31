package com.wissensalt.rnd.simplealarm.service;

import com.wissensalt.rnd.simplealarm.model.data.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IScheduleService {

    @Transactional
    void insert(Schedule schedule);
    
    Schedule findById(Integer p_Id);
    
    List<Schedule> findByEnabled(Integer p_Enabled);
    
    List<Schedule> findAll();
    
    @Transactional
    void delete(Integer p_Id);
    
    @Modifying
    @Transactional
    void update(Schedule schedule);
}
