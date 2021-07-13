package ProfesorOAK;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ProfesorOAK extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
		if(value instanceof JLabel) {
			JLabel lbl=(JLabel) value;
			return lbl;
		}
				
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
	
}
