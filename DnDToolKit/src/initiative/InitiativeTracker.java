package initiative;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitiativeTracker{
	
	JFrame screen;
	JTextField player_name;
	JTextField player_init;
	JButton add_button;
	JTable init_table;
	int x;
	
	String data[][] = new String[17][17];    
	String column[]={"PLAYER","INITIATIVE"};
	
	DefaultTableModel model = new DefaultTableModel();
	Object[] table_row = new Object[2];
	 
	
	InitiativeTracker(){
		x = 10;
		screen = new JFrame("Initiative Tracker");
		
		JLabel intro = new JLabel ("This is a demo of an initiative tracker for Dungeons and Dragons!");
		intro.setBounds(110, 0, 500, 100);
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Image dice = t.getImage("images/dice.jpg");
		screen.setIconImage(dice);
		
		JPanel form_panel = new JPanel();
		form_panel.setBounds(20,90,540,100);
		form_panel.setLayout(new GridBagLayout());
		GridBagConstraints form_c = new GridBagConstraints();
		
		
		//Declaring components
		JLabel player_label = new JLabel("Player's Name:");
		player_name = new JTextField();
		JLabel init_label = new JLabel("Initiative:");
		player_init = new JTextField();
		add_button = new JButton("Add Player");
		add_button.setActionCommand("add");
		
		//Setting components sizes and locations
		player_label.setBounds(10, 40, 100, 20);
		player_name.setSize(100, 100);
		player_name.setBounds(100, 40, 100, 25);
		init_label.setBounds(220, 40, 100, 20);
		player_init.setBounds(275, 40, 100, 25);
		add_button.setBounds(400, 40, 100, 25);
		add_button.addActionListener(new MyActionListener());
		
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
		form_c.ipadx = 0;
		form_panel.add(add_button, form_c);
		
		
		init_table = new JTable();    
		init_table.setBounds(30,40,200,295);
		
		model.setColumnIdentifiers(column);
		init_table.setModel(model);
		init_table.setBackground(Color.LIGHT_GRAY);
		
		
		JScrollPane table_panel = new JScrollPane(init_table);
		table_panel.setBounds(20,200,540,295);
		
		
		screen.setSize(650,650);
		screen.setLayout(new GridBagLayout());
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
		//screen.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		screen.setVisible(true);
		
	}
	
	public void grabX() {
		System.out.println(this.x);
	}
	
	

	public static void main(String[] args) {
		
		InitiativeTracker it = new InitiativeTracker();
		
		

	}
	
	private class MyActionListener implements ActionListener{
	      public void actionPerformed(ActionEvent evt){
	    	  if (evt.getSource() == add_button) {
		           System.out.println(player_name.getText());
		           System.out.println(player_init.getText());
		           
		           table_row[0] = player_name.getText();
		           table_row[1] = player_init.getText();
		           
		           model.addRow(table_row);
		           
		       }
	       }
	}


}
