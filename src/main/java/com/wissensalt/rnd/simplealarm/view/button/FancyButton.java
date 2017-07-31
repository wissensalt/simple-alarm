package com.wissensalt.rnd.simplealarm.view.button;

import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FancyButton extends JButton implements IComponentInitializer{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -836262586574109983L;

    @Override
    public void initComponents() {
        this.setBackground(new Color(59, 89, 182));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        this.setFont(new Font("Tahoma", Font.BOLD, 12));
    }
       
}
