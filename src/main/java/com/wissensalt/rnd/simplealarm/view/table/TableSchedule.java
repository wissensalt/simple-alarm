package com.wissensalt.rnd.simplealarm.view.table;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.service.IScheduleService;
import javax.annotation.PostConstruct;
import javax.swing.JTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableSchedule extends JTable implements IComponentInitializer {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -5113509592542587530L;

    @Autowired
    TableModelSchedule modelSchedule;
    
    @Autowired
    IScheduleService scheduleService;
    
    @PostConstruct
    @Override
    public void initComponents() {
        modelSchedule.setSchedules(scheduleService.findAll());        
        this.setModel(modelSchedule);        
    }

    public void refreshTable(){
        modelSchedule.setSchedules(scheduleService.findAll());
    }
}
