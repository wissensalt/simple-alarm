package com.wissensalt.rnd.simplealarm.view.label;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import javax.annotation.PostConstruct;
import javax.swing.JLabel;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LabelTime extends JLabel implements IComponentInitializer {

    /**
     *
     *
     */
    private static final long serialVersionUID = 4254513578903001251L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setFont(this.getFont ().deriveFont(50.0f));
    }
    
    

}
