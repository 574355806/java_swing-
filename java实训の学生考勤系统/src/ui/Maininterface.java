package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Maininterface extends JFrame implements ActionListener{
	JMenuBar caidan = new JMenuBar();
	JMenu j1, j2, j3, j4,j5;
	JMenuItem ji[] = new JMenuItem[100];
	JDesktopPane desk = new JDesktopPane();
	JTable j = new JTable();
	JScrollPane jP = new JScrollPane(j);

	public Maininterface() {

		super("ѧ�����ڹ���ϵͳ");
		// Dimension d = getToolkit().getScreenSize();//�õ���Ļ�ĳߴ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		super.setSize(1000, 600);
		j1 = new JMenu("�༶����");
		ji[1]=new JMenuItem("�༶����");
		j1.add(ji[1]);
		ji[1].addActionListener(this);
		ji[2]=new JMenuItem("�γ̹���");
		j2 = new JMenu("�γ̹���");
		
		j2.add(ji[2]);
        ji[2].addActionListener(this);
		ji[5]=new JMenuItem("���ڹ���");
	    
		j3 = new JMenu("���ڹ���");
		j3.add(ji[5]);
		
		ji[0]=new JMenuItem("����ͳ��");
		j4 = new JMenu("����ͳ��");
		j4.add(ji[0]);
		ji[0].addActionListener(this);
		j5 =new JMenu("�ҵ���Ϣ");
		ji[3]=new JMenuItem("�鿴�ҵ���Ϣ");
		ji[4]=new JMenuItem("�޸�����");
		j5.add(ji[3]);
		j5.add(ji[4]);
		caidan.add(j1);
		caidan.add(j2);
		caidan.add(j3);
		caidan.add(j4);
		caidan.add(j5);
		setJMenuBar(caidan);
		this.setContentPane(desk);
		ImageIcon bg=new ImageIcon("image/-c9fefffc9a219dd_����.jpg");
	    JLabel label=new JLabel(bg);
	    label.setBounds(0,0,1000,600);
	    this.add(label);
	   	ji[4].addActionListener(this) ;	
	   ji[5].addActionListener(this);
	   }
			
	  

	@Override
	public void actionPerformed(ActionEvent e) {
		/*Presentmannger prescent = null;
		if(e.getSource()==ji[5])
			{
			desk.removeAll();
			
			prescent=new Presentmannger("���ڹ���", true, true, true, true);
		    prescent.validate();
		    desk.add(prescent,BorderLayout.CENTER);
		    ImageIcon bg=new ImageIcon("image/-c9fefffc9a219dd_����.jpg");
		    JLabel label=new JLabel(bg);
		    label.setBounds(0,0,1000,600);
		    this.add(label);
		  
		     }
	
		 if(e.getSource()==ji[4])
		   {  desk.removeAll();
		   
			   Changepassword x=new Changepassword();
			   x.validate();
			   desk.add(x,BorderLayout.CENTER);
			   ImageIcon bg=new ImageIcon("image/-c9fefffc9a219dd_����.jpg");
			    JLabel label=new JLabel(bg);
			    label.setBounds(0,0,1000,600);
			    this.add(label);
			  
				
		  
		   }
		 if(e.getSource()==ji[0]){
			 desk.removeAll();
			   			   KQcount x=new KQcount();
			   x.validate();
			   desk.add(x,BorderLayout.CENTER);
			   ImageIcon bg=new ImageIcon("image/-c9fefffc9a219dd_����.jpg");
			    JLabel label=new JLabel(bg);
			    label.setBounds(0,0,1000,600);
			    this.add(label);
			 
		 }
		 if(e.getSource()==ji[1]){
			 desk.removeAll();
 			   Classmannager x=new Classmannager();
       x.validate();
    desk.add(x,BorderLayout.CENTER);
   ImageIcon bg=new ImageIcon("image/-c9fefffc9a219dd_����.jpg");
  JLabel label=new JLabel(bg);
  label.setBounds(0,0,1000,600);
  this.add(label);
			
		 }
		 if(e.getSource()==ji[2]){
			 desk.removeAll();
 			   Courseui x=new Courseui();
       x.validate();
    desk.add(x,BorderLayout.CENTER);
   ImageIcon bg=new ImageIcon("image/-c9fefffc9a219dd_����.jpg");
  JLabel label=new JLabel(bg);
  label.setBounds(0,0,1000,600);
  this.add(label);
			 
		 }*/
		 
		   
		
	}
}
