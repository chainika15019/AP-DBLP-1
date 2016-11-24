import java.awt.*;
import javax.swing.*;
public class DBLP extends JFrame{	// The GUI class
	private static final long serialVersionUID = 1L;
	JFrame mainframe;
	JPanel panel1,panel2,panel3; // panels
	JLabel label1,label2,label3; // labels
	GridBagConstraints c = new GridBagConstraints();
	DBLP()
	{
		mainframe= new JFrame("Search Engine");
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setLayout(new GridBagLayout());
		panel1= new JPanel();
		label1= new JLabel("label1");
		label1.setFont(new Font("Serif", Font.PLAIN, 20));
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel1.add(label1);
		panel2= new JPanel();
		label2= new JLabel("label2");
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.add(label2);
		panel3= new JPanel();
		label3= new JLabel("label3");
		label3.setFont(new Font("Serif", Font.PLAIN, 20));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3.add(label3);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx =0.72;

		mainframe.add(panel1,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1; 
	
		mainframe.add(panel2,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=1;

		mainframe.add(panel3,c);
		mainframe.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DBLP();
	}
}
