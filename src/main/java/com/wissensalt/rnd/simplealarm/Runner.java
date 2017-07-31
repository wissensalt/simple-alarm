package com.wissensalt.rnd.simplealarm;

import com.wissensalt.rnd.simplealarm.view.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 30, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class Runner implements CommandLineRunner{

     /**
     * Pull in the JFrame to be displayed.
     */
    @Autowired
    private SplashScreen splashScreen;
    

    @Override
    public void run(String... args) throws Exception {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                splashScreen.startSplash();
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
