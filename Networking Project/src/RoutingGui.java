import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class RoutingGui {
	
	int TABLE_LENGTH = 3;
	String[][] table;
	String ip_out = "";
	
	JFrame frame, frame2;
	JPanel panel1, panel2, panel3;
	JScrollPane scrollpane2;
	
	ArrayList<JTextField[]> ip = new ArrayList<JTextField[]>();
	JTextField[] router;
	JTextField ip_in, size_in;
	
	JLabel label;
	JButton button1, button2;
	
	public RoutingGui() {
		
		//make new frame
		frame = new JFrame();
		
		
		//make each panel
		panel1();
		panel2(TABLE_LENGTH);
		scrollpane2 = new JScrollPane(panel2);
		panel3();
		
		
		//frame attributes
		frame.setSize(550,300);
		frame.setTitle("Routing GUI");
		frame.setVisible(true);
		frame.setResizable(false);
		
		//add panels to frame
		frame.add(panel1, BorderLayout.PAGE_START);
		frame.add(scrollpane2, BorderLayout.CENTER);
		frame.add(panel3, BorderLayout.PAGE_END);
		
	}
	
	//sets up panel 1 (inputs)
	public void panel1() {
		
		//clear and initialize panel
		panel1 = new JPanel();
		
		//setup buttons
		button1 = new JButton("Run");
		button1.addActionListener(new ButtonListener());
		ip_in = new JTextField(15);
		
		button2 = new JButton("Set");
		button2.addActionListener(new ButtonListener());
		size_in = new JTextField(5);
		
		//add elements
		panel1.add(new JLabel("Enter Routing IP"));
		panel1.add(ip_in);
		panel1.add(button1);
		panel1.add(new JLabel("Set Size"));
		panel1.add(size_in);
		panel1.add(button2);
		
	}
	
	//sets up panel 2 (routing table)
	public void panel2(int e)  {
		
		//clear and initialize panel, table and router
		panel2 = new JPanel();
		table = new String[e][2];
		router = new JTextField[table.length];
		
		//set panel 2 to a grid layout
		//arr is an array which has many other panels to place in each grid element of panel 2
		panel2.setLayout(new GridLayout(table.length, 1));
		JPanel[] arr = new JPanel[table.length];
	
		//loops # of times as routing table entries and creates each line and add it to the grid
		for (int i = 0; i < table.length; i++) {
			arr[i] = new JPanel();
			ip.add(new JTextField[5]);
			arr[i].add(new JLabel("Entry " + (i + 1) + " :"));
			
			//adds text fields which make up ip entry
			for (int j = 0; j < 5; j++) {
				ip.get(i)[j] = new JTextField(5);
				arr[i].add(ip.get(i)[j]);
				if (j == 4) break;
				if (j < 3) arr[i].add(new JLabel("."));
				else arr[i].add(new JLabel("/"));
			}
			
			//add router text field and places arr index into panel 2 grid
			router[i] = new JTextField("Router " + (i + 1), 5);
			arr[i].add(router[i]);
			panel2.add(arr[i]);
		}
		
	}
	
	//sets up table to be passed to program.java
	public void ipsetup() {
		for (int i = 0; i < table.length; i++) {
			String str = "";
			JTextField[] temp = ip.get(i);
			
			for (int j = 0; j < 5; j++) {
				str += temp[j].getText() + ".";
			}
			
			table[i][0] = str;
			table[i][1] = router[i].getText();
		}
	}
	
	//sets up panel 3 (direct answer)
	public void panel3() { 
		panel3 = new JPanel();
		label = new JLabel();
		label.setText("IP Routed to: " + ip_out);
		panel3.add(label);
	}
	
	//sets up panel 4 (visual panel)
	public void	panel4() {
		
	}
	
	public static void main(String args[]) {
		
		new RoutingGui();
		
	}

	
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == button1) {
				ipsetup();
				ip_out = Program.blah(table,ip_in.getText());
				label.setText("IP Routed to: " + ip_out);
				panel3.revalidate();
			} else if (e.getSource() == button2) {
			 
				
				panel2(Integer.parseInt(size_in.getText()));
				panel2.revalidate();
				
				frame.remove(scrollpane2);
				scrollpane2 = new JScrollPane(panel2);
				frame.add(scrollpane2, BorderLayout.CENTER);
				frame.revalidate();
				
				
			}
			
		}
	}

}
