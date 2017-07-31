package com.wissensalt.rnd.simplealarm.view.label;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class LabelIconTime extends JLabel implements IComponentInitializer {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 2283943124048892285L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource("assets/time.png")));
    }

}
