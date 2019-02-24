package ui;

import handle.Handcount;
import handle.Handlepresent;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class KQcount extends JInternalFrame implements ActionListener,
		ItemListener {

	JScrollPane jScrollPane = null;
	JPanel j1, j2, j3;
	JLabel ji1, ji2;
	JComboBox comboBox;
	JLabel numberJLabel;// = new JLabel("ѧ��");
	JLabel kqjLabel;// = new JLabel("��������");
	JLabel classjLabel;// = new JLabel("�༶");
	JTextField textField;// = new JTextField(5);
	JComboBox comboBox1 ;
	JButton button = new JButton("��ʼͳ��");

	Handcount handcount = new Handcount();
	Handlepresent handlepresent=new Handlepresent();
	JTable table = new JTable();
	
	String name1[]=new String[5] ;
	

	public KQcount() {
		super("����ͳ��", true, true, true, true);
		setSize(600, 400);
		String name[] = new String[3];
		name[0] = new String("�༶");
		name[1] = new String("ѧ��");
		name[2] = new String("��������");

		comboBox = new JComboBox(name);
		comboBox.setEnabled(true);
		comboBox.addItemListener(this);
		
		name1[0] = new String("����");
		name1[1] = new String("����");
		name1[2] = new String("�¼�");
		name1[3] = new String("����");
		name1[4] = new String("����");
		
	    comboBox1 = new JComboBox(name1);
	    comboBox1.setEnabled(true);
		
		classjLabel = new JLabel("����༶");
		textField = new JTextField(10);
		j1 = new JPanel();
		ji1 = new JLabel("ͳ�Ʒ�ʽ:");
		
		
		j1.add(classjLabel);
		j1.add(textField);
		j2 = new JPanel();
		j2.add(ji1);
		j2.add(comboBox);
        j3=new JPanel();
        j3.add(j2);
        j3.add(j1);
        JPanel j5=new JPanel();
		j3.add(button,BorderLayout.CENTER);
		j5.add(j3,BorderLayout.NORTH);
		j5.add(j1);
		this.add(j5, BorderLayout.NORTH);
		jScrollPane=new JScrollPane(table);
		 add(new JScrollPane(jScrollPane),BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		button.addActionListener(this);
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{   int c,k,chi,shi,bing;
			String styleString=(String)comboBox.getSelectedItem();
			String textString=(String)textField.getText();
		    if(styleString.equals("ѧ��"))
		   	{
		     DefaultTableModel dtmxu = handlepresent.findresult(textString);
		     DefaultTableModel dtm = handcount.findresultname(textString);
	    	 int shirow=dtm.getRowCount()-1;
			 int row=dtmxu.getRowCount()-1;
	 			for(int x=0;x<=shirow;x++)
				{
					 c=0;k=0;chi=0;shi=0;bing=0;
				 	for(int i=0;i<=row;i++)
				{
				 		if((dtm.getValueAt(x,0).equals
				(dtmxu.getValueAt(i,0))/*&&(dtm.getValueAt(x,2).equals
						(dtmxu.getValueAt(i,2)))*/)){
						String typeString=dtmxu.getValueAt(i,4).toString();
					   // System.out.print(typeString);
					
					if(typeString.equals("����                "))
							c++;
					else if(typeString.equals("����                "))
						  k++;
					
					else if(typeString.equals("�ٵ�                "))
						chi++;
					else if(typeString.equals("����                "))
						bing++;
					if(typeString.equals("�¼�                "))
						shi++;
						}
				}
				dtm.setValueAt(c, x, 2);
				dtm.setValueAt(k, x, 3);
				dtm.setValueAt(chi, x,4);
				dtm.setValueAt(shi, x, 5);
				dtm.setValueAt(bing, x, 6);
				
				}
	    	 
		     table.setModel(dtm);
			 }
		    
		    if(styleString.equals("�༶"))
		   	{
		     DefaultTableModel dtmxu = handlepresent.findresultbyclass(textString);
		     DefaultTableModel dtm = handcount.findresultbyclass(textString);
	    	 int shirow=dtm.getRowCount()-1;
			 int row=dtmxu.getRowCount()-1;
	 			for(int x=0;x<=shirow;x++)
				{
					 c=0;k=0;chi=0;shi=0;bing=0;
						for(int i=0;i<=row;i++)
						{
						 		if((dtm.getValueAt(x,1).equals
						(dtmxu.getValueAt(i,1))/*&&(dtm.getValueAt(x,2).equals
								(dtmxu.getValueAt(i,2)))*/)){
								String typeString=dtmxu.getValueAt(i,4).toString();
							   // System.out.print(typeString);
							
							if(typeString.equals("����                "))
									c++;
							else if(typeString.equals("����                "))
								  k++;
							
							else if(typeString.equals("�ٵ�                "))
								chi++;
							else if(typeString.equals("����                "))
								bing++;
							if(typeString.equals("�¼�                "))
								shi++;
								}
						}
						dtm.setValueAt(c, x, 2);
						dtm.setValueAt(k, x, 3);
						dtm.setValueAt(chi, x,4);
						dtm.setValueAt(shi, x, 5);
						dtm.setValueAt(bing, x, 6);
						}
	    	 
		     table.setModel(dtm);
			 }
		    if(styleString.equals("��������"))
		   	{
		     textString=comboBox1.getSelectedItem().toString();
		     DefaultTableModel dtmxu = handlepresent.findresultbykq(textString);
		     DefaultTableModel dtm = handcount.findresultbykq(textString);
	    	 int shirow=dtm.getRowCount()-1;
			 int row=dtmxu.getRowCount()-1;
					for(int x=0;x<=shirow;x++)
				{
					 c=0;k=0;chi=0;shi=0;bing=0;
					 for(int i=0;i<=row;i++)
						{
						 
						 if((dtm.getValueAt(x,1).equals(dtmxu.getValueAt(i,1))&&
					     	(dtm.getValueAt(x,0).equals(dtmxu.getValueAt(i,0))))
					     	){
								 c++;
						 }			
						}
						dtm.setValueAt(c, x, 2);
						}
	    	 
		     table.setModel(dtm);
			 }
		   	}
			
		

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange()==ItemEvent.SELECTED) 
		{
						if ((comboBox.getSelectedItem()).equals("ѧ��")) {
				j1.removeAll();
				numberJLabel = new JLabel("����ѧ�ţ�");
				j1.add(numberJLabel);
				j1.add(textField);
				    JLabel label=new JLabel();
				    label.setBounds(0,0,1000,600);
				    this.add(label);
				  
				validate();
			}

			if ((comboBox.getSelectedItem()).equals("��������")) {
				j1.removeAll();
					JLabel kqjLabel = new JLabel("��������");
					j1.add(kqjLabel);
					
					//String name1[]=new String[5] ;
					
					
					
				    j1.add(comboBox1);
				     JLabel label=new JLabel();
				    label.setBounds(0,0,1000,600);
				    this.add(label);
				  	validate();
			}

			if ((comboBox.getSelectedItem()).equals("�༶")) {
				j1.removeAll();
				classjLabel=new JLabel("����༶��");
				j1.add(classjLabel);
				j1.add(textField);
		    JLabel label=new JLabel();
				    label.setBounds(0,0,1000,600);
				    this.add(label);
				  
				validate();

			}

	}
	}
	

}
