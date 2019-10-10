package school;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class chSample implements ItemListener
{	JFrame frame = new JFrame("App");
	Choice chShoe = new Choice();
	JTextField txtOut = new JTextField("",20);
	JLabel lblMes = new JLabel("Chose your favorite brand: ");
	JLabel lblOut = new JLabel("You chose: ");

	public void init()
	{	frame.add(lblMes);
		frame.setLayout(new GridLayout(2,2));
		frame.setSize(500,500);
		chShoe.add("Adidas");
		chShoe.add("Nike");
		chShoe.add("Converse");
		chShoe.add("Puma");
		chShoe.add("Vans");
		frame.add(chShoe); chShoe.addItemListener(this);
		frame.add(lblOut); frame.add(txtOut); txtOut.setVisible(true);
		frame.setVisible(true);
		txtOut.setLocation(300,100);
	}
	public void itemStateChanged(ItemEvent ie)
	{	String ch = "";
		if(chShoe.getSelectedIndex() == 0)
			ch = chShoe.getSelectedItem();
		else if(chShoe.getSelectedItem() == "Nike")
			ch = chShoe.getSelectedItem();
		else if(chShoe.getSelectedIndex() == 2)
			ch = chShoe.getSelectedItem();
		else if(chShoe.getSelectedItem() == "Puma")
			ch = chShoe.getSelectedItem();
		else //if(chShoe.getSElectedItem() == "Nike")
			ch = chShoe.getSelectedItem();
		txtOut.setFont(new Font("Comic Sans MS",Font.PLAIN,24));
		txtOut.setText(ch);
	}
	
	public static void main(String [] args)
	{
		chSample c = new chSample();
		c.init();
	}
	
}
