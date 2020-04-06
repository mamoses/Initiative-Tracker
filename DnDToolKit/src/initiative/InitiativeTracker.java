package initiative;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import TableModel.MyTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InitiativeTracker{
	
	JFrame screen;
	JTextField player_name;
	JTextField player_init;
	JButton add_button;
	JButton remove_button;
	JTable init_table;
	int x;
	
	String column[]={"PLAYER","INITIATIVE"};
	MyTableModel model = new MyTableModel();
	Object[] table_row = new Object[2];
	 
	
	InitiativeTracker(){
		x = 10;
		screen = new JFrame("Initiative Tracker");
		screen.setSize(750,650);
		screen.setLayout(new GridBagLayout());
		
		JLabel intro = new JLabel ("This is a demo of an initiative tracker for Dungeons and Dragons!");
		
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image dice = tool.getImage("images/dice.jpg");
		screen.setIconImage(dice);
		
		JPanel form_panel = new JPanel();
		form_panel.setLayout(new GridBagLayout());
		GridBagConstraints form_c = new GridBagConstraints();
		
		
		//Declaring components
		JLabel player_label = new JLabel("Player's Name:");
		player_name = new JTextField();
		JLabel init_label = new JLabel("Initiative:");
		player_init = new JTextField();
		
		add_button = new JButton("Add Player");
		add_button.setActionCommand("add");
		add_button.addActionListener(new MyActionListener());
		
		remove_button = new JButton("Remove Player");
		remove_button.setActionCommand("remove");
		remove_button.addActionListener(new MyActionListener());
		
		
		//Setting components sizes and locations
		form_c.fill = GridBagConstraints.NONE;
		form_c.gridx = 0;
		form_c.ipadx = 0;
		form_c.insets = new Insets(0,20,0,0);
		form_panel.add(player_label, form_c);
		form_c.gridx = 1;
		form_c.ipadx = 100;
		form_panel.add(player_name, form_c);
		form_c.gridx = 2;
		form_c.ipadx = 0;
		form_panel.add(init_label, form_c);
		form_c.gridx = 3;
		form_c.ipadx = 100;
		form_panel.add(player_init, form_c);
		form_c.gridx = 4;
		form_c.ipadx = 20;
		form_panel.add(add_button, form_c);
		form_c.gridx = 5;
		form_c.ipadx = 0;
		form_panel.add(remove_button, form_c);
		
		
		init_table = new JTable();
		
		model.setColumnIdentifiers(column);
		init_table.setModel(model);
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(init_table.getModel());
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
		sorter.setSortable(0, false);
		sorter.setSortKeys(sortKeys);
		init_table.setRowSorter(sorter);
		
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		init_table.getColumnModel().getColumn(1).setCellRenderer(leftRenderer);
		
		
		JScrollPane table_panel = new JScrollPane(init_table);
		
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.VERTICAL;
		c.weighty = 20.5;
		c.insets = new Insets(20,0,0,0);  
		c.gridx = 0;
		c.gridy = 0;
		screen.add(intro,c );
		
		c.fill = GridBagConstraints.VERTICAL;
		c.weighty = 20.5;
		c.insets = new Insets(0,0,0,0);  
		c.gridx = 0;
		c.gridy = 2;
		screen.add(form_panel,c);
		c.fill = GridBagConstraints.VERTICAL;
		c.weighty = 20.5;
		c.insets = new Insets(10,0,30,0);  //bottom padding
		c.gridx = 0;
		c.gridy = 3;
		screen.add(table_panel, c);
		
		screen.setVisible(true);
		
	}
	
	public void grabX() {
		System.out.println(this.x);
	}
	
	
	
	private class MyActionListener implements ActionListener{
	      public void actionPerformed(ActionEvent evt){
	    	  if (evt.getSource() == add_button) {
		           
		           if(player_init.getText().isEmpty() || player_name.getText().isEmpty()) {
		        	   System.out.println("WAIT");
		           }
		           
		           else {
			           table_row[0] = player_name.getText();
			           
			           try {
			        	   table_row[1] = Integer.parseInt(player_init.getText());
			           }
			           catch(NumberFormatException ex) {
			        	   System.out.println("ERROR2");
			        	   return;
			           }
			          
			           model.addRow(table_row);
		           }
		       }
	    	  else if (evt.getSource() == remove_button) {
	    		  int selected_row = init_table.getSelectedRow();
	    		  
	    		  if(selected_row >= 0) {
	    			  model.removeRow(selected_row);
	    		  }
	    		  else {
	    			  System.out.println("ERROR");
	    		  }
	    	  }
	       }
	}

	
	
	public static void main(String[] args) {
		
		InitiativeTracker it = new InitiativeTracker();
		
		

	}


}
