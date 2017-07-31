package com.wissensalt.rnd.simplealarm.view.scrollview;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.view.table.TableSchedule;
import javax.annotation.PostConstruct;
import javax.swing.JScrollPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ScrollViewSchedule extends JScrollPane implements IComponentInitializer {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -3620513829019079701L;

    @Autowired
    TableSchedule tableSchedule;
    
    @PostConstruct
    @Override
    public void initComponents() {
        this.setViewportView(tableSchedule);
    }

    public TableSchedule getTableSchedule() {
        return tableSchedule;
    }
    
}
