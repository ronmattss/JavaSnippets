package school;

import javax.swing.*;
import java.awt.event.*;

class RadioTest implements ItemListener {
	JFrame fr;
	JRadioButton cb1, cb2, cb3, cb4;
	JTextArea ta;
	ButtonGroup bg;

	RadioTest() {
		fr = new JFrame();
		fr.setLayout(null);
		fr.setSize(500, 500);

		cb1 = new JRadioButton(" Burger");
		cb1.setBounds(50, 50, 100, 30);
		fr.add(cb1);
		cb2 = new JRadioButton(" DOSA");
		cb2.setBounds(50, 110, 100, 30);
		fr.add(cb2);
		cb3 = new JRadioButton(" Burger");
		cb3.setBounds(50, 170, 100, 30);
		fr.add(cb3);
		cb4 = new JRadioButton(" Burger");
		cb4.setBounds(50, 230, 70, 30);
		fr.add(cb4);
		bg = new ButtonGroup();
		bg.add(cb1);
		bg.add(cb2);
		bg.add(cb3);
		bg.add(cb4);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		ta = new JTextArea();
		ta.setBounds(200, 50, 200, 200);
		fr.add(ta);
		fr.setVisible(true);
	}

	public static void main(String args[]) {
		new RadioTest();
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		ta.setText(" ");
		if (cb1.isSelected())
			ta.setText("i like to eat" + cb1.getText());
		if (cb2.isSelected())
			ta.setText("i like to eat" + cb2.getText());
		if (cb3.isSelected())
			ta.setText("i like to eat" + cb3.getText());
		if (cb4.isSelected())
			ta.setText("i like to eat" + cb1.getText());
		
	}

}
