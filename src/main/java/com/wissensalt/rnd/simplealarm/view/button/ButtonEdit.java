package com.wissensalt.rnd.simplealarm.view.button;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonEdit extends FancyButton implements IComponentInitializer{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 3435411458055945369L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText("Edit");
        super.initComponents();
    }

}
