package com.wissensalt.rnd.simplealarm.view.button;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class ButtonRefresh extends FancyButton implements IComponentInitializer{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -4110738749849804191L;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setText("Refresh");
        super.initComponents();
    }
    
    

}
