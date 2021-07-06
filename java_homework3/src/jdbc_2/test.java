package jdbc_2;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc_1.myj;
import javax.swing.BoxLayout;

@SuppressWarnings({ "serial", "unused" })
public class test extends JFrame {
    private static double ji;
	private jc panel;
	private jc panel_1;
	private jc panel_2;
	private jc panel_3;
	
	private jc bujian;

	/**
	 * Launch the application.
	 * 
	 */
	
	
	public static void main(String[] args) {
		
		
	     long maxtime=500000000;
		test frame = new test();
		frame.setVisible(true);
		
		frame.panel.get(frame.panel_1,0);
		frame.panel.get(frame.panel_2,1);
		frame.panel.get(frame.panel_3,2);
		
		frame.panel_1.get(frame.panel,0);
		frame.panel_1.get(frame.panel_2,1);
		frame.panel_1.get(frame.panel_3,2);
		
		frame.panel_2.get(frame.panel_1,0);
		frame.panel_2.get(frame.panel,1);
		frame.panel_2.get(frame.panel_3,2);
		
		frame.panel_3.get(frame.panel_1,0);
		frame.panel_3.get(frame.panel_2,1);
		frame.panel_3.get(frame.panel,2);
       
       
		
				
		
		
	
	
		
	}

	/**
	 * Create the frame.
	 */
	
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 330, 458);
		getContentPane().setLayout(null);
		ji=0;

		panel  =new jc();
		panel.setBounds(0, 10, 142, 200);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_1 = new jc();
		panel_1.setBounds(0, 217, 150, 192);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new jc();
		panel_2.setBounds(150, 10, 142, 200);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		panel_3 = new jc();
		panel_3.setBounds(150, 217, 142, 192);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		
		
		
		
		
	}

}
