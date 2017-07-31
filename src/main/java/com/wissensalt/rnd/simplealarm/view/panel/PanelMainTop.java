package com.wissensalt.rnd.simplealarm.view.panel;

import com.wissensalt.rnd.simplealarm.component.IComponentAction;
import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.view.label.LabelIconTime;
import com.wissensalt.rnd.simplealarm.view.label.LabelTime;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelMainTop extends JPanel implements IComponentInitializer, IComponentAction {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 3962412701183206987L;

    @Autowired
    LabelIconTime labelIconTime;
    
    @Autowired
    LabelTime labelTime;
    
    
    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout(100, 0));
        this.add(labelIconTime, BorderLayout.LINE_START);
        this.add(labelTime, BorderLayout.CENTER);
        
        initAction();
    }

    @Override
    public void initAction() {
        Timer SimpleTimer = new Timer(1000, new ActionListener() {
            SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm");            
            @Override
            public void actionPerformed(ActionEvent e) {
                labelTime.setText(formatDate.format(new Date()));
            }
        });
        SimpleTimer.start();
    }

    
}
