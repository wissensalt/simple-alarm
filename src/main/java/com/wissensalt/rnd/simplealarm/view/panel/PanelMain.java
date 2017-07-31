package com.wissensalt.rnd.simplealarm.view.panel;

import com.wissensalt.rnd.simplealarm.component.IComponentAction;
import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.view.dialog.DialogAddSchedule;
import com.wissensalt.rnd.simplealarm.view.label.LabelTime;
import java.awt.BorderLayout;
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
public class PanelMain extends JPanel implements IComponentInitializer, IComponentAction {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 9127189063956110294L;

    @Autowired
    PanelMainTop panelMainTop;
    
    @Autowired
    PanelMainMiddle panelMainMiddle;
    
    @Autowired
    PanelMainBottom panelMainBottom;
    
    @Autowired
    DialogAddSchedule dialogAddSchedule;
    
    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(panelMainTop, BorderLayout.NORTH);
        
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new BorderLayout());
        panelContainer.add(panelMainMiddle, BorderLayout.NORTH);
        panelContainer.add(panelMainBottom, BorderLayout.CENTER);
        
        this.add(panelContainer, BorderLayout.CENTER);
        initAction();
    }

    @Override
    public void initAction() {
        this.panelMainMiddle.getButtonRefresh().addActionListener(e -> {
            this.panelMainBottom.getScrollViewSchedule().getTableSchedule().refreshTable();
        });
        
        this.panelMainMiddle.getButtonAdd().addActionListener(e -> {
            dialogAddSchedule.resetFields();
            dialogAddSchedule.setVisible(true);
        });
        
        this.panelMainMiddle.getButtonEdit().addActionListener(e -> {
            dialogAddSchedule.resetFields();
            dialogAddSchedule.setVisible(true);
        });
    }

}
