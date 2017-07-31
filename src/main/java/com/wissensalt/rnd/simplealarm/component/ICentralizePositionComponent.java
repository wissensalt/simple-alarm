package com.wissensalt.rnd.simplealarm.component;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICentralizePositionComponent {

    void setComponentToCenter(Component p_Component);

    void setDialogToCenter(JDialog p_JDialog);

    void setDialogCustomToCenter(JDialog p_JDialog, int p_XDivider, int p_YDivider);

    void setIFrameToCenter(JInternalFrame p_JInternalFrame);
    
    void setJFrameToCenter(JFrame p_JFrame);
}