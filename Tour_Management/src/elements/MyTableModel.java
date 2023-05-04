package elements;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
    /**
    * 
    */
    private static final long serialVersionUID = 1179177076042966842L;

    @Override
    public Class<?> getColumnClass(int columnIndex) {
	if (columnIndex == getColumnCount() - 1) {
	    return JButton.class;
	}
	return String.class;
    }
}