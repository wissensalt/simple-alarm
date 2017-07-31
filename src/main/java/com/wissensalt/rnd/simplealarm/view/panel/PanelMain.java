package com.wissensalt.rnd.simplealarm.view.panel;

import com.wissensalt.rnd.simplealarm.component.IComponentAction;
import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.model.data.Schedule;
import com.wissensalt.rnd.simplealarm.service.IScheduleService;
import com.wissensalt.rnd.simplealarm.view.dialog.DialogAddSchedule;
import java.awt.BorderLayout;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class PanelMain extends JPanel implements IComponentInitializer, IComponentAction {

    /**
     *
     *
     */
    private static final long serialVersionUID = 9127189063956110294L;

    @Autowired
    PanelMainTop panelMainTop;

    @Autowired
    PanelMainMiddle panelMainMiddle;

    @Autowired
    PanelMainBottom panelMainBottom;

    @Autowired
    DialogAddSchedule dialogAddSchedule;

    @Autowired
    IScheduleService scheduleService;

    @PostConstruct
    @Override
    public void initComponents() {
        this.setLayout(new BorderLayout());
        this.add(panelMainTop, BorderLayout.NORTH);

        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new BorderLayout());
        panelContainer.add(panelMainMiddle, BorderLayout.NORTH);
        panelContainer.add(panelMainBottom, BorderLayout.CENTER);

        this.add(panelContainer, BorderLayout.CENTER);
        initAction();
    }

    @Override
    public void initAction() {
        this.panelMainMiddle.getButtonRefresh().addActionListener(e -> {
            this.panelMainBottom.getScrollViewSchedule().getTableSchedule().refreshTable();
        });

        this.panelMainMiddle.getButtonAdd().addActionListener(e -> {
            dialogAddSchedule.setMode(DialogAddSchedule.Mode.ADD);
            dialogAddSchedule.resetFields();
            dialogAddSchedule.setVisible(true);
        });

        this.panelMainMiddle.getButtonEdit().addActionListener(e -> {
            if (this.panelMainBottom.getScrollViewSchedule().getTableSchedule().getSelectedRow() > -1) {
                Integer scheduleId = (Integer) this.panelMainBottom.getScrollViewSchedule().getTableSchedule().getValueAt(this.panelMainBottom.getScrollViewSchedule().getTableSchedule().getSelectedRow(), 0);
                if (scheduleId != null) {
                    dialogAddSchedule.setFieldsValue(scheduleService.findById(scheduleId));

                    dialogAddSchedule.setMode(DialogAddSchedule.Mode.EDIT);
                    dialogAddSchedule.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Please pick one schedule", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please pick one schedule", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        this.panelMainMiddle.getButtonDelete().addActionListener(e -> {
            if (this.panelMainBottom.getScrollViewSchedule().getTableSchedule().getSelectedRow() > -1) {
                int deleteOption = JOptionPane.showConfirmDialog(null, "Are u sure to delete this schedule", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (deleteOption == JOptionPane.YES_OPTION) {
                    Integer scheduleId = (Integer) this.panelMainBottom.getScrollViewSchedule().getTableSchedule().getValueAt(this.panelMainBottom.getScrollViewSchedule().getTableSchedule().getSelectedRow(), 0);
                    if (scheduleId != null) {
                        scheduleService.delete(scheduleId);
                        this.panelMainBottom.getScrollViewSchedule().getTableSchedule().refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please pick one schedule", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please pick one schedule", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        this.panelMainTop.labelTime.addPropertyChangeListener(e -> {
            List<Schedule> activeSchedules = scheduleService.findByEnabled(1);
            if (activeSchedules.size() > 0){
                for (Schedule s : activeSchedules){
                    if (s.getTime().equals(panelMainTop.labelTime.getText())){
                        JOptionPane.showMessageDialog(null, s.getName(), "Schedule Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

    }

}
