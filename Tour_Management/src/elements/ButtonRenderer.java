package elements;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {
    /**
    * 
    */
    private static final long serialVersionUID = 2393773574424077724L;

    public ButtonRenderer() {
	setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
	    int row, int column) {
	setText((value == null) ? "" : value.toString());
	return this;
    }
}
