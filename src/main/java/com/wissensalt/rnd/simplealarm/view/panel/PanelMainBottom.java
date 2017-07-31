package com.wissensalt.rnd.simplealarm.view.panel;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.view.scrollview.ScrollViewSchedule;
import java.awt.BorderLayout;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelMainBottom extends JPanel implements IComponentInitializer {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 6291950998084396081L;

    @Autowired
    ScrollViewSchedule scrollViewSchedule;
    
    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(scrollViewSchedule, BorderLayout.CENTER);
    }

    public ScrollViewSchedule getScrollViewSchedule() {
        return scrollViewSchedule;
    }
    
    

}
