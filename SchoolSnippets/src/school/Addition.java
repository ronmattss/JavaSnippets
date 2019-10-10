package school;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Addition {

	public static void main(String args[]) {
		JFrame f = new JFrame("Addition");
		f.setLayout(new GridLayout(3,1));
		f.setSize(200, 100);
		TextField tf1 = new TextField();
		tf1.setBounds(100, 20, 50, 10);
		TextField tf2 = new TextField();
		tf2.setBounds(100, 100, 50, 10);
		TextField tf3 = new TextField();
		tf3.setText("Where Am I");
		tf3.setBounds(20, 200, 50, 50);
		
		Label l1 = new Label("addend1");
		l1.setBounds(10, 20, 20, 10);
		Label l2 = new Label("addend2");
		l2.setBounds(10, 50, 20, 10);
		Button l3 = new Button("sum");
		l3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText() == null || tf2.getText() == null)
					tf3.setText("Please enter valid numbers");
				else
				{
					int a = Integer.parseInt(tf1.getText());
					int b = Integer.parseInt(tf2.getText());
					tf3.setText(Integer.toString(a + b));
				}
				
			}
		});
		l3.setSize(20, 10);


		f.add(l1);
		f.add(tf1);
		f.add(l2);
		f.add(tf2);
		f.add(l3);
		f.add(tf3);




	//	f.add(panel2);
	//	f.add(panel1);
		f.setVisible(true);
		
	}
}