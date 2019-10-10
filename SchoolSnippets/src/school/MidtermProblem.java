// Midterm code solution
/* Author: Rivera, Ron Matthew R.
 * one of many solutions
 * uses Swing/AWT Library
 * Includes:
 * exception handling
 * and a message box
 *   grid layout format
 * */
package school;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MidtermProblem {

	public static void main(String[] args) {
		//Uses Jframe with Applet as name
		JFrame F = new JFrame("Applet");
		Label title = new Label("Midterm");
		Label title2 = new Label("Problem");
		
		Label P = new Label("Prelims");
		Label M = new Label("Midterms");
		Label Fi = new Label("Finals");
		Label R = new Label("Status");
		Label S = new Label("Results");
		
		TextField PT = new TextField();
		TextField MT = new TextField();
		TextField FiT = new TextField();
		TextField RT = new TextField();
		TextField ST = new TextField();
		
		Button C  = new Button("Compute");
		Button Cl = new Button("Clear");
		
		//disables the textfield for user inputs
		RT.setEnabled(false);
		ST.setEnabled(false);
		
		
		// add Action Listener shorthand
		// no need to implement ActionListener, uses the button class interface
		C.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double a, b, c, r;
				a =0;
				b =0;
				c =0;
				//try block if the input is not numeric throw NumberFormatException
				try {
					
					a = Double.parseDouble(PT.getText());
					b = Double.parseDouble(MT.getText());
					c = Double.parseDouble(FiT.getText());
					
					if((a < 0 || a > 100)||(b < 0 || b > 100)||(c < 0 || c > 100))
					{
						JOptionPane.showMessageDialog(null,"Invalid Input!");
					}
					else
					{
						a *= 0.30 *100;
						b *= 0.30 *100;
						c *= 0.40 *100;
						r = (a + b + c)/100;
						
						if(r >= 75)
						{
							RT.setText("Passed");
							
						}
						else
							RT.setText("Failed");
						ST.setText(Double.toString(r));
					}
				}
				
				// catches  the exception from the try block
				catch(NumberFormatException exception)
				{
					//Show message dialogue for invalid input
					//ST.setText(exception.toString());
					JOptionPane.showMessageDialog(null,"Invalid Input!");
					
				}
				
			}});
		
		//clears all the input
		Cl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PT.setText("");
				MT.setText("");
				FiT.setText("");
				RT.setText("");
				ST.setText("");
			}});
		
		// this will align the content in a 7 by 2 grid
		F.add(title); 
		F.add(title2); 
		F.add(P);
		F.add(PT);
		F.add(M);
		F.add(MT);
		F.add(Fi);
		F.add(FiT);
		F.add(R);
		F.add(RT);
		F.add(S);
		F.add(ST);
		F.add(C);
		F.add(Cl);
		
		F.setSize(500,500);
		//set layout in grid
		F.setLayout(new GridLayout(7,2));
		// set visibility
		F.setVisible(true);
		// TODO Auto-generated method stub

	}

}
