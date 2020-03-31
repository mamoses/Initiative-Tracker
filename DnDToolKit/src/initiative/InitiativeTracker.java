package initiative;
import javax.swing.*;
import java.awt.*;

public class InitiativeTracker {
	
	JFrame screen;
	int x;
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
		form_panel.setLayout(null);
		
		//Declaring components
		JLabel player_label = new JLabel("Player's Name:");
		JTextField player_name = new JTextField();
		JLabel init_label = new JLabel("Initiative:");
		JTextField player_init = new JTextField();
		JButton add_button = new JButton("Add Player");
		
		//Setting components sizes and locations
		player_label.setBounds(10, 40, 100, 20);
		player_name.setBounds(100, 40, 100, 25);
		init_label.setBounds(220, 40, 100, 20);
		player_init.setBounds(275, 40, 100, 25);
		add_button.setBounds(400, 40, 100, 25);
		
		form_panel.add(player_label);
		form_panel.add(player_name);
		form_panel.add(init_label);
		form_panel.add(player_init);
		form_panel.add(add_button);
		
		
		JPanel table_panel = new JPanel();
		table_panel.setBackground(Color.green);
		table_panel.setBounds(20,200,540,300);
		
		
		
		
		
		
		
		
		
		screen.add(intro);
		screen.add(form_panel);
		screen.add(table_panel);
		screen.setSize(600,600);
		screen.setLayout(null);
		screen.setVisible(true);
		
	}
	
	public void grabX() {
		System.out.println(this.x);
	}

	public static void main(String[] args) {
		
		InitiativeTracker it = new InitiativeTracker();
		
		
		it.grabX();
		

	}

}
