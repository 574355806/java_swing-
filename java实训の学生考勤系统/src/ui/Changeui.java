package ui;

import handle.Handlepresent;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Changeui extends JInternalFrame implements ActionListener {

	JScrollPane jScrollPane=null;
	JButton b1,b2,b3,b4;//增加  删除  修改   查询
	JLabel j1,j2,j3,j4,j5;
	Box box,box0,box1,box2,box3,box4 ;
	JTextField classtext,studenttext,typetext,coursetext,timetext;
	JTextArea jj;
	Handlepresent handlepresent=new Handlepresent();
	JTable table = new JTable();
			
	public Changeui(String title, boolean resizable, boolean closable,
			boolean maximizable,boolean iconificial) {
		
		 super(title, resizable, closable, maximizable, iconificial);

			DefaultTableModel dtm = handlepresent.showTable();
			
			table.setModel(dtm);
			 jScrollPane=new JScrollPane(table);
			this.add(new JScrollPane(jScrollPane),BorderLayout.CENTER);
			b1=new JButton("修改");
			this.add(b1,BorderLayout.SOUTH);
			setSize(500,500);
			
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
				  
	   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
