package school;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
public class ExperimentGui implements ActionListener {

	JFrame frame = new JFrame("Nigga");
	JLabel label1 = new JLabel("soME");
	JLabel label2 = new JLabel("nigga");
	JRadioButton b1 = new JRadioButton("White");
	JRadioButton b2 = new JRadioButton("Red");
	JRadioButton b3 = new JRadioButton("Blue");
	ButtonGroup bg = new ButtonGroup();
	
	
	ExperimentGui()
	{
		frame.add(label1);
		frame.add(label2);
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.setLayout(new GridLayout(5,1));
		frame.setSize(500,500);
		frame.setVisible(true);
		b1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1)
					frame.setTitle("Tite");
				else
					frame.setTitle("nigga");
				
				
			}
		});
	}

	public static void main(String[] args)
	{
		ExperimentGui g = new ExperimentGui();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
