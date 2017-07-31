package com.wissensalt.rnd.simplealarm.view.dialog;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;
import com.wissensalt.rnd.simplealarm.component.ICentralizePositionComponent;
import com.wissensalt.rnd.simplealarm.component.IComponentAction;
import com.wissensalt.rnd.simplealarm.component.IComponentInitializer;
import com.wissensalt.rnd.simplealarm.model.data.Schedule;
import com.wissensalt.rnd.simplealarm.service.IScheduleService;
import com.wissensalt.rnd.simplealarm.view.table.TableSchedule;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class DialogAddSchedule extends JDialog implements IComponentInitializer, IComponentAction {

    /**
     *
     *
     */
    private static final long serialVersionUID = 9031634046015021245L;

    @Autowired
    IScheduleService scheduleService;

    @Autowired
    ICentralizePositionComponent centralizePositionComponent;
    
    @Autowired
    TableSchedule tableSchedule;

    private final JLabel lblName = new JLabel("Name");
    private final JLabel lblTime = new JLabel("Time");
    private final JLabel lblRepeat = new JLabel("Repeat");
    private final JLabel lblEnabled = new JLabel("Enabled");

    private final JTextField txtName = new JTextField();
    private TimePicker timePicker;
    private final JCheckBox chkRepeat = new JCheckBox();
    private final JCheckBox chkEnabled = new JCheckBox();

    private final JPanel panelTop = new JPanel();
    private final JPanel panelTopLeft = new JPanel();
    private final JPanel panelTopRight = new JPanel();
    private final JPanel panelBottom = new JPanel();

    private final JButton btSave = new JButton("Save");
    private final JButton btReset = new JButton("Reset");

    private static final String FORMAT_TIME = "HH:mm";

    SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_TIME);

    private int ModeCode = 0;
    
    private int scheduleId;

    public enum Mode {

        ADD,
        EDIT
    }

    public void setMode(Mode mode) {
        switch (mode) {
            case ADD:
                ModeCode = 1;break;
            case EDIT:
                ModeCode = 2;break;
        }
    }

    @PostConstruct
    @Override
    public void initComponents() {
        panelTopLeft.setLayout(new GridLayout(4, 1));
        panelTopLeft.add(lblName);
        panelTopLeft.add(lblTime);
        panelTopLeft.add(lblRepeat);
        panelTopLeft.add(lblEnabled);

        panelTopRight.setLayout(new GridLayout(4, 1));
        panelTopRight.add(txtName);

        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.setColor(TimeArea.TimePickerTextValidTime, Color.blue);
        timeSettings.initialTime = LocalTime.now();
        timeSettings.setDisplaySpinnerButtons(true);
        timeSettings.setFormatForDisplayTime(FORMAT_TIME);
        timePicker = new TimePicker(timeSettings);

        panelTopRight.add(timePicker);
        panelTopRight.add(chkRepeat);
        panelTopRight.add(chkEnabled);

        panelTop.setLayout(new GridLayout(1, 2));
        panelTop.add(panelTopLeft);
        panelTop.add(panelTopRight);

        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btReset);
        panelBottom.add(btSave);

        this.setLayout(new BorderLayout());
        this.add(panelTop, BorderLayout.CENTER);
        this.add(panelBottom, BorderLayout.PAGE_END);

        this.setSize(500, 250);
        this.setTitle("Add Schedule");
        this.setModal(true);

        centralizePositionComponent.setDialogToCenter(this);

        initAction();
    }

    @Override
    public void initAction() {
        btReset.addActionListener(e -> {
            resetFields();
        });

        btSave.addActionListener(e -> {
            switch (ModeCode) {
                case 1:
                    saveMode();
                    refreshTable();
                    break;
                case 2:
                    editMode();
                    refreshTable();
                    break;
            }
        });

    }
    
    private void refreshTable(){
        tableSchedule.refreshTable();
    }

    private void editMode() {
        if (txtName.getText() != null) {
            if (timePicker.getText() != null) {
                try {
                    if (dateFormat.parse(timePicker.getText()).after(dateFormat.parse(dateFormat.format(new Date())))) {
                        Schedule schedule = new Schedule();
                        schedule.setId(scheduleId);
                        schedule.setName(txtName.getText());
                        schedule.setTime(timePicker.getText());
                        if (chkRepeat.isSelected()) {
                            schedule.setRepeat(1);
                        } else {
                            schedule.setRepeat(0);
                        }
                        if (chkEnabled.isSelected()) {
                            schedule.setEnabled(1);
                        } else {
                            schedule.setEnabled(0);
                        }
                        scheduleService.update(schedule);
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Success Edit Schedule", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Time must be greater than current time", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(DialogAddSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Time must not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Name must not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveMode() {
        if (txtName.getText() != null) {
            if (timePicker.getText() != null) {
                try {
                    if (dateFormat.parse(timePicker.getText()).after(dateFormat.parse(dateFormat.format(new Date())))) {
                        Schedule schedule = new Schedule();
                        schedule.setName(txtName.getText());
                        schedule.setTime(timePicker.getText());
                        if (chkRepeat.isSelected()) {
                            schedule.setRepeat(1);
                        } else {
                            schedule.setRepeat(0);
                        }
                        if (chkEnabled.isSelected()) {
                            schedule.setEnabled(1);
                        } else {
                            schedule.setEnabled(0);
                        }
                        scheduleService.insert(schedule);
                        this.dispose();
                        JOptionPane.showMessageDialog(null, "Success Insert new Schedule", "Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Time must be greater than current time", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(DialogAddSchedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Time must not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Name must not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void resetFields() {
        txtName.setText("");
        timePicker.setText("");
        chkRepeat.setSelected(false);
        chkRepeat.setSelected(false);
    }
    
    public void setFieldsValue(Schedule schedule){
        scheduleId = schedule.getId();
        txtName.setText(schedule.getName());
        timePicker.setText(schedule.getTime());
        if (schedule.getRepeat() == 1){
            chkRepeat.setSelected(true);
        }
        if (schedule.getEnabled() == 1){
            chkEnabled.setSelected(true);
        }
    }

}
