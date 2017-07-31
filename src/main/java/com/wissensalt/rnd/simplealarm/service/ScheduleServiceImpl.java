package com.wissensalt.rnd.simplealarm.service;

import com.wissensalt.rnd.simplealarm.dao.ScheduleDAO;
import com.wissensalt.rnd.simplealarm.model.data.Schedule;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;
    
    @Override
    public void insert(Schedule schedule) {
        scheduleDAO.save(schedule);
    }

    @Override
    public Schedule findById(Integer p_Id) {
        return scheduleDAO.findOne(p_Id);
    }

    @Override
    public List<Schedule> findByEnabled(Integer p_Enabled) {
        return scheduleDAO.findByEnabled(p_Enabled);
    }
   
    
    @Override
    public List<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    @Override
    public void delete(Integer p_Id) {
        scheduleDAO.delete(p_Id);
    }

    @Override
    public void update(Schedule schedule) {
        scheduleDAO.save(schedule);
    }

}
