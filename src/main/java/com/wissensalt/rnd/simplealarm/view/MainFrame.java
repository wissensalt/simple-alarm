package com.wissensalt.rnd.simplealarm.view;

import com.wissensalt.rnd.simplealarm.component.ICentralizePositionComponent;
import com.wissensalt.rnd.simplealarm.component.IComponentAction;
import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.view.panel.PanelMain;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 30, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MainFrame extends JFrame implements IComponentInitializer, IComponentAction {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 4914768996770307407L;

    @Autowired
    PanelMain panelMain;
    
    @Autowired
    ICentralizePositionComponent centralizePositionComponent;
            
    @PostConstruct
    @Override
    public void initComponents() {
        final int HEIGHT = 400;
        final int WIDTH = 600;
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Simple Alarm Application");
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH, HEIGHT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        
        centralizePositionComponent.setJFrameToCenter(this);
        
        this.add(panelMain, BorderLayout.CENTER);
        
        initAction();
    }

    @Override
    public void initAction() {
    }
    
    

}
