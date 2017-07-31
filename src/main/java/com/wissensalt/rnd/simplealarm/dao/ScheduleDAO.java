package com.wissensalt.rnd.simplealarm.dao;

import com.wissensalt.rnd.simplealarm.model.data.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ScheduleDAO extends JpaRepository<Schedule, Integer>{

}
