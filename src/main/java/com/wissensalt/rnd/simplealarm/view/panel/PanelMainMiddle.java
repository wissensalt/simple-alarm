package com.wissensalt.rnd.simplealarm.view.panel;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.view.button.ButtonAdd;
import com.wissensalt.rnd.simplealarm.view.button.ButtonDelete;
import com.wissensalt.rnd.simplealarm.view.button.ButtonEdit;
import com.wissensalt.rnd.simplealarm.view.button.ButtonRefresh;
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
public class PanelMainMiddle extends JPanel implements IComponentInitializer {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 7743556283390527543L;

    @Autowired
    ButtonAdd buttonAdd;
    
    @Autowired
    ButtonEdit buttonEdit;
    
    @Autowired
    ButtonDelete buttonDelete;
    
    @Autowired
    ButtonRefresh buttonRefresh;
    
    @PostConstruct
    @Override
    public void initComponents() {
        JPanel panelContainer = new JPanel();
        panelContainer.add(buttonRefresh);
        panelContainer.add(buttonAdd);
        panelContainer.add(buttonEdit);
        panelContainer.add(buttonDelete);
        
        this.setLayout(new BorderLayout());
        this.add(panelContainer, BorderLayout.LINE_END);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public ButtonAdd getButtonAdd() {
        return buttonAdd;
    }

    public ButtonEdit getButtonEdit() {
        return buttonEdit;
    }

    public ButtonDelete getButtonDelete() {
        return buttonDelete;
    }

    public ButtonRefresh getButtonRefresh() {
        return buttonRefresh;
    }
    
    

}
