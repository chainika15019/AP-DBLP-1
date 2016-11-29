import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
public class GUI  
{
	JFrame mainFrame;
	JPanel mainframe;
	JPanel panel1,panel2,panel3,panel4,panel5;
	JLabel label1,label2,label3,label4;
	JLabel l1,l2,l3,l4;
	JPanel small1,small2,small3,small4,small5,small6;
	String[] message = {"  Queries  ","  Query1  " , "  Query2  " , "  Query3  "};
	String[] Search = {"  Author  ","  Title  "};
	JComboBox<String> combo2;
	JComboBox<String> combolist;
	JTextField j1 ,j2,j3,j4;
	JRadioButton b1 , b2;
	JButton butt1,butt2,butt3;
	JPanel panel3_1,panel3_2,panel3_3;
	JLabel p3_1,p3_2;
	String[] columns = {"S_no" ,"Authors","Title","Pages","Year","Volume","Journal/Book Title","URL"};
	Object[][] datavalues={};
	JTable table ;
	ButtonGroup group;
	GUI()
	{
		mainFrame= new JFrame("Search Engine");
		mainframe = new JPanel();
		panel5= new JPanel();
		panel3= new JPanel();
		panel2= new JPanel();
		panel1= new JPanel();
		small1= new JPanel();
		small2= new JPanel();
		small3= new JPanel();
		small4= new JPanel();
		small5 = new JPanel();
		small6 = new JPanel();
		label1= new JLabel("DBLP Query Engine");
		label2= new JLabel("label2");
		label3= new JLabel("label3");
		p3_1= new JLabel("Number of results returned : ");
		p3_2= new JLabel("23");
		combolist = new JComboBox<String>(message);
		combolist.setSelectedIndex(0);
		combo2 = new JComboBox<String>(Search);
		combo2.setSelectedIndex(0);
		j1= new JTextField();
		j2= new JTextField();
		j3= new JTextField();
		j4= new JTextField();
		l1= new JLabel("Name/Title tags : ");
		l2= new JLabel("Since Year : ");
		l3 = new JLabel("Custom range : ");
		b1 = new JRadioButton("Sort by Year");
		b2 = new JRadioButton("Sort by Relevance");
		butt1 = new JButton("Search");
		butt2 = new JButton("Reset");
		butt3 = new JButton("Search");
		butt1.addActionListener(new Choice());
		butt2.addActionListener(new Choice());
		butt3.addActionListener(new Choice());
		
		panel3_1= new JPanel();
		panel3_2= new JPanel();
		panel3_3= new JPanel();
		setpanel1();
		setpanel2();
		setpanel3();
		setMainFrame();
	}
	public void setpanel1()
	{
		//System.out.println("in setpanel1");
		panel1.setLayout(new GridLayout(1,1));
		label1.setFont(new Font("Serif", Font.PLAIN, 45));
		label1.setBorder(BorderFactory.createLineBorder(Color.red));
		label1.setHorizontalAlignment(JLabel.CENTER);
	    label1.setVerticalAlignment(JLabel.CENTER);
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel1.add(label1);
	}
	public void setpanel2()
	{
		panel2.setLayout(new GridLayout(15,0));
		combolist.addActionListener(new Options());
		combolist.setSelectedIndex(0);
		panel2.setBorder(BorderFactory.createLineBorder(Color.red));
		panel2.add(combolist);
	}
	public void setpanel3()
	{
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3.add(new JLabel("hello"));
		
	}
	public void setMainPanel()
	{
		mainframe.removeAll();
		mainframe.repaint();
		GridBagConstraints c = new GridBagConstraints();
		mainframe.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weighty=0.15;
		c.fill=GridBagConstraints.BOTH;
		mainframe.add(panel1,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		c.weighty=0.85;
		c.weightx=0.10;
		c.fill=GridBagConstraints.BOTH;
		mainframe.add(panel2,c);
		c.gridx=1;
		c.gridy=1;
		c.weightx=0.90;
		c.weighty=0.85;
		c.fill=GridBagConstraints.BOTH;
		mainframe.add(panel3,c);
		mainframe.revalidate();
	}
	public void setMainFrame()
	{
		mainFrame.setSize(600,600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setMainPanel();

		mainFrame.add(mainframe);
		mainFrame.setVisible(true);
		
	}
	public void query1Change1Panel3()
	{
		JPanel panel3_0= new JPanel();
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS));
		panel3_0.setBorder(BorderFactory.createLineBorder(Color.blue));
		panel3_0.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		panel3_1.removeAll();
		panel3_1.repaint();
		panel3_1.setLayout(new BoxLayout(panel3_1,BoxLayout.X_AXIS));
		panel3_1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3_1.add(p3_1);
		panel3_1.add(p3_2);
		panel3_1.revalidate();
		panel3_2.removeAll();
		panel3_2.repaint();
		panel3_2.setLayout(new BoxLayout(panel3_2,BoxLayout.Y_AXIS));
		panel3_2.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3_2.add(new JLabel("hellooo"));
		panel3_2.revalidate();
		panel3_3.removeAll();
		panel3_3.repaint();
		panel3_3.setLayout(new BorderLayout());
		panel3_3.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton b4 = new JButton("NEXT");
		//b4.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		panel3_3.add(b4,BorderLayout.EAST);
		panel3_3.revalidate();
		c1.gridx =0;
		c1.gridy =0;
		c1.weighty=0.10;
		c1.weightx=1;
		c1.fill= GridBagConstraints.BOTH;
		panel3_0.add(panel3_1,c1);
		c1.gridx =0;
		c1.gridy =1;
		c1.weighty=0.80;
		panel3_0.add(panel3_2,c1);
		c1.gridx =0;
		c1.gridy =2;
		c1.weighty=0.10;
		panel3_0.add(panel3_3,c1);
		panel3.add(panel3_0);
	}
	public void query1Change1Panel2()
	{
		panel2.setLayout(new GridLayout(2,0,1,1));
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		small1.removeAll();
		small1.repaint();
		small1.setLayout(new GridLayout(0,2,1,1));
		l1.setText("Name/title tags");
		small1.add(l1);
		small1.add(j1);
		small1.revalidate();
		
		small2.removeAll();
		small2.repaint();
		small2.setLayout(new GridLayout(0,2,2,2));
		l2.setText("Since Year");
		small2.add(l2);
		small2.add(j2);
		small2.revalidate();
		
		small3.removeAll();
		small3.repaint();
		small3.setLayout(new GridLayout(0,3,2,2));
		l3.setText("Custom Range");
		small3.add(l3);
		small3.add(j3);
		small3.add(j4);
		small3.revalidate();
		
		small4.removeAll();
		small4.repaint();
		small4.setLayout(new GridLayout(2,0,2,2));
		group = new ButtonGroup();
		 group.add(b1);
		 group.add(b2);
		small4.add(b1);
		small4.add(b2);
		b1.setSelected(true	);
		small4.revalidate();
		
		small5.removeAll();
		small5.repaint();
		small5.setLayout(new BoxLayout(small5,BoxLayout.X_AXIS));
		small5.add(Box.createRigidArea(new Dimension(35, 10)));
		 
		small5.add(butt1);
		small5.add(Box.createRigidArea(new Dimension(35, 10)));
		small5.add(butt2);
		small5.revalidate();
		
		
		small6.removeAll();
		small6.repaint();
		small6.setLayout(new BoxLayout(small6,BoxLayout.Y_AXIS));
		small6.add(combolist);
		small6.add(Box.createRigidArea(new Dimension(0, 10)));
		small6.add(combo2);
		small6.revalidate(); 
		
		panel5.setLayout( new GridBagLayout());
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx=0;
		c1.gridy=0;
		c1.fill = GridBagConstraints.HORIZONTAL;
		combolist.setSelectedIndex(1);
		c1.insets= new Insets(10,5,3,20);//top left bottom right
		panel5.add(small6,c1);
		
		
		c1.gridx=0;
		c1.gridy=1;
		c1.insets= new Insets(5,5,3,20);
		panel5.add(small1, c1);
		
		
		c1.gridx=0;
		c1.gridy=2;
		c1.insets= new Insets(5,5,3,20);
		panel5.add(small2, c1);
		
		
		c1.gridx=0;
		c1.gridy=3;
		c1.insets= new Insets(5,5,3,5);
		panel5.add(small3, c1);
		
		
		c1.gridx=0;
		c1.gridy=4;
		c1.insets= new Insets(5,15,3,10);
		panel5.add(small4, c1);
		
		
		c1.gridx=0;
		c1.gridy=5;
		c1.insets= new Insets(3,5,10,20);
		panel5.add(small5,c1);
		
		panel2.add(panel5);
	}
	public void Reset()
	{
		panel1.removeAll();
		panel1.repaint();
		setpanel1();
		panel1.revalidate();
		
		
	}
	public void query1Change2()
	{
		panel2.setLayout(new GridLayout(3,0));
		panel5.removeAll();
		panel5.repaint();
		l1.setText("No.of Publications");
		small1.removeAll();
		small1.repaint();
		small1.setLayout(new BoxLayout(small1,BoxLayout.X_AXIS));
		//small1.setBorder(BorderFactory.createLineBorder(Color.black));
		small1.add(l1);
		small1.add(Box.createRigidArea(new Dimension(50, 0)));
		small1.add(j1);
		small1.revalidate();
		
		small5.removeAll();
		small5.repaint();
		small5.setLayout(new BoxLayout(small5,BoxLayout.X_AXIS));
		small5.add(butt1);
		small5.add(Box.createRigidArea(new Dimension(35, 10)));
		small5.add(butt2);
		small5.revalidate();
		
		panel5.setLayout(new GridBagLayout());
		combolist.setSelectedIndex(2);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.gridx=0;
		c1.gridy=0;
		c1.insets = new Insets(3,5,10,20);
		c1.fill= GridBagConstraints.HORIZONTAL;
		panel5.add(combolist,c1);
		
		
		c1.gridx=0;
		c1.gridy=1;
		panel5.add(small1, c1);
		
		c1.gridx=0;
		c1.gridy=2;
		c1.insets = new Insets(3,0,10,30);
		panel5.add(small5, c1);
		panel5.revalidate();
		panel2.add(panel5);
	}
	private class Options implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
		
			JComboBox<String> c = (JComboBox<String>)e.getSource();
			String msg = (String)c.getSelectedItem();
			if(msg.compareTo("  Query1  ")==0)
			{
				panel2.removeAll();
				panel2.repaint();
				query1Change1Panel2();
				panel2.revalidate();
				
				panel3.removeAll();
				panel3.repaint();
				query1Change1Panel3();
				panel3.revalidate();
			
				Reset();
				
				mainframe.removeAll();
				mainframe.repaint();
				setMainPanel();
				mainframe.revalidate();
			}
			else if(msg.compareTo("  Query2  ")==0)
			{
				panel2.removeAll();
				panel2.repaint();
				query1Change2();
				panel2.revalidate();
				
				Reset(); 
				
				//mainframe.removeAll();
				//mainframe.repaint();
				setMainPanel();
				//mainframe.revalidate();
			}
		}
		
	}
	private class Choice implements ActionListener
	{

		public void actionPerformed(ActionEvent evt) {
			if(evt.getSource() == butt1)
			{
				System.out.println("search in query1");
			}
			else if(evt.getSource() == butt2)
			{
				panel2.removeAll();
				panel2.repaint();
				setpanel2();
				panel2.revalidate();
				
				Reset();
				
				//mainframe.removeAll();
				//mainframe.repaint();
				setMainPanel();
				//mainframe.revalidate();
				
			
			}
			else if(evt.getSource() == butt3)
			{
				System.out.println("search in query2");
			}
			
		}
		
	}
	public static void main(String[] args) //throws IOException, SAXException
	{
		new GUI();
	}
}

