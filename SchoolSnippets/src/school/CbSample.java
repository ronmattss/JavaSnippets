package school;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class CbSample implements ItemListener{
	JRadioButton cbCnC = new JRadioButton("Cookies and Cream");
	JRadioButton cbCho = new JRadioButton("Chocolate");
	JRadioButton cbMan = new JRadioButton("Mango");
	JRadioButton cbRoR = new JRadioButton("Rocky Road");
	JRadioButton cbVan = new JRadioButton("Vanilla");
	JLabel lblIn = new JLabel("Choose your favorite flavor/s: ");
	JFrame Ppnl = new JFrame("CbSample");
	
	static JTextArea taDis = new JTextArea(15, 20);
	public static void main(String[] args) {
		CbSample m = new CbSample();
		m.init();
		m.Ppnl.setLayout(new GridLayout(3,3));
		m.Ppnl.setSize(500,500);
		m.Ppnl.setVisible(true);


	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String fl = "";
		taDis.setText("");
		if (cbCnC.isSelected() == true)
			fl += cbCnC.getText() + "\n";
		if (cbCho.isSelected() == true)
			fl += cbCho.getText() + "\n";
		if (cbMan.isSelected() == true)
			fl += cbMan.getText() + "\n";
		if (cbRoR.isSelected() == true)
			fl += cbRoR.getText() + "\n";
		if (cbVan.isSelected() == true)
			fl += cbVan.getText() + "\n";
		display(fl);
	}
	
	public void init() {
		Ppnl.add(lblIn);
		Ppnl.add(cbCnC);
		Ppnl.add(cbCho);
		Ppnl.add(cbMan);
		Ppnl.add(cbRoR);
		Ppnl.add(cbVan);
		Ppnl.add(taDis);
		cbCnC.addItemListener(this);
		cbCho.addItemListener(this);
		cbMan.addItemListener(this);
		cbRoR.addItemListener(this);
		cbVan.addItemListener(this);
		cbCnC.setVisible(true);
		cbVan.setVisible(true);
		cbCho.setVisible(true);
		cbMan.setVisible(true);
		cbRoR.setVisible(true);
	}



	public static void display(String f) {
		taDis.append(f);
	}

}




