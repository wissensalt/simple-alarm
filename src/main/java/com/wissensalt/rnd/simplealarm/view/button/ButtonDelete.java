package com.wissensalt.rnd.simplealarm.view.button;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonDelete extends FancyButton implements IComponentInitializer {
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -4970400360974735235L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText("Delete");
        super.initComponents();
    }

}
