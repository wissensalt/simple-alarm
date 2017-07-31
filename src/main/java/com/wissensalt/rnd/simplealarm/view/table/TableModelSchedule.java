package com.wissensalt.rnd.simplealarm.view.table;

import com.wissensalt.rnd.simplealarm.model.data.Schedule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.springframework.stereotype.Component;

/**
 * Created on Jul 31, 2017
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class TableModelSchedule extends AbstractTableModel implements ITableModelListener<Schedule>{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = 6841147774050002101L;
    private List<Schedule> schedules = new ArrayList<>();
    private static final String [] COLUMN_NAME = new String[]{"Id", "Name", "Time", "Repeat", "Enabled"};

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
        fireTableDataChanged();
    }
    

    @Override
    public boolean add(Schedule p_Object) {
        try{
            return schedules.add(p_Object);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    @Override
    public Schedule get(int p_Index) {
        return schedules.get(p_Index);
    }

    @Override
    public Schedule set(int p_Index, Schedule p_Element) {
        try{
            return schedules.set(p_Index, p_Element);
        }finally{
            fireTableRowsUpdated(p_Index, p_Index);
        }
    }

    @Override
    public Schedule remove(int p_Index) {
        try{
            return schedules.remove(p_Index);
        }finally{
            fireTableRowsDeleted(p_Index, p_Index);
        }
    }

    @Override
    public boolean removeAll(Collection<Schedule> p_CollectionObjects) {
        try{
            return schedules.removeAll(p_CollectionObjects);
        }finally{
            fireTableDataChanged();
        }
    }  
       
    
    @Override
    public int getRowCount() {
        return schedules.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return schedules.get(rowIndex).getId();
            case 1 : return schedules.get(rowIndex).getName();
            case 2 : return schedules.get(rowIndex).getTime();
            case 3 : 
                if (schedules.get(rowIndex).getRepeat()==1){
                    return "Yes";
                }else {
                    return "No";
                }
                
            case 4 : 
                if (schedules.get(rowIndex).getEnabled() == 1){
                    return "Yes";
                }else {
                    return "No";
                }
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAME[column];
    }     

}
