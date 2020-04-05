package TableModel;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	
	public MyTableModel(){
		
		
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
		
	}
}
