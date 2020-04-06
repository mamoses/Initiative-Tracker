package TableModel;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	
	Class[] types = {String.class, Integer.class };
	
	public MyTableModel(){
				
		
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
		
	}
	@Override
	 public Class getColumnClass(int c) {
		return this.types[c];
	    }
}
