package ui;

import handle.Handlecourse;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import table.Course;

public class Courseui extends JInternalFrame implements ActionListener {
	JScrollPane jScrollPane=null;
	JButton b1,b2,b3,b4;//����  ɾ��  �޸�   ��ѯ
	Box box,box0,box1,box2,box3,box4 ;
	JTextField teachertext,coursenametext,coursenumtext,timetext;  //�����ı���
	JLabel j1,j2,j3,j4,j5;     //ÿ����ǩ
		
		

	Handlecourse handlecourse=new Handlecourse();
	JTable table = new JTable();
	public Courseui() {
		 super("�γ̹���", true, true, true, true);
		     DefaultTableModel dtm = handlecourse.showTable();
		     table.setModel(dtm);
			 jScrollPane=new JScrollPane(table);
			 add(new JScrollPane(jScrollPane),BorderLayout.CENTER);	
			    box0=Box.createVerticalBox();
			    //��ʾ��ǩ������һ��������
			    j1=new JLabel("�γ̱��");
			    j2=new JLabel("�γ�����");
			    j3=new JLabel("�ڿν�ʦ");
			    j4=new JLabel("ѧʱ");
			    box0.add(j1);
			    box0.add(Box.createVerticalStrut(5));
			    box0.add(j2);
			    box0.add(Box.createVerticalStrut(5));
			    box0.add(j3);
			    box0.add(Box.createVerticalStrut(5));
			    box0.add(j4);
			    //�����ı��򣬷�����һ�������У�
			    coursenumtext=new JTextField(1);
			    coursenametext=new JTextField(1);
			    teachertext=new JTextField(1);
			    timetext=new JTextField(1);
				   
			    box2=Box.createVerticalBox();
			    box2.add(coursenumtext);
			    box2.add(Box.createVerticalStrut(1));
			    box2.add(coursenametext);
			    box2.add(Box.createVerticalStrut(1));
				box2.add(teachertext);
				box2.add(Box.createVerticalStrut(1));
				box2.add(timetext);
			     box3=Box.createHorizontalBox();
			   box3.add(box0);
			   box3.add(Box.createHorizontalStrut(15));
			   box3.add(box2);
			    box = Box.createVerticalBox();
			    box.add(Box.createVerticalStrut(30));
			    box.add(box3);
			    box.add(Box.createVerticalStrut(30));
	  //�������������ť
			    
			    b1 = new JButton("��ѯ");
	    b1.addActionListener(this);
	    b2 = new JButton("ɾ��");
	    b2.addActionListener(this);
	    b3 = new JButton("����");
	    b3.addActionListener(this);
	    b4 = new JButton("�޸�");
	    b4.addActionListener(this);
	    //����ť�������
	   box1 =  Box.createHorizontalBox();
	    box1.add(b1);
	    box1.add(Box.createHorizontalStrut(15));
	    box1.add(b2);
	    box1.add(Box.createHorizontalStrut(15));
	    box1.add(b3);
	    box1.add(Box.createHorizontalStrut(15));
	    box1.add(b4);
	    box.add(box1);
	   //���������ӷŵ����jpanel��
	  JPanel jPanel=new JPanel();
	  jPanel.add(box,BorderLayout.CENTER);
	   this.add(jPanel,BorderLayout.SOUTH);
	   setVisible(true);
		setSize(500,500);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   }
	@Override
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== b1){//��ѯ
		 String nameString=coursenametext.getText();//�����д�Ŀγ̣���ʦ���γ̱��
		 String teacherString=teachertext.getText();
		 String numberstring=coursenumtext.getText();
		 if(nameString.equals("")&&teacherString.equals("")) {   //��δ��д�γ̣���ʦ����ʾ��������
				DefaultTableModel dtm = handlecourse.showTable();
				table.setModel(dtm);
				}
		 else if(nameString.equals("")){//���γ���Ϊ�գ����ս�ʦ����
			 Course xPresent=handlecourse.findbyteacher(teacherString);
				if(xPresent!=null)
				{   
					DefaultTableModel dtm = handlecourse.findresultbyteacher(teacherString);
					table.setModel(dtm);
				}
				else JOptionPane.showMessageDialog(null, "���޴˿γ�", "��ѯ", 1);
				 
		 }
		 else if(teacherString.equals(""))            //��ѧ�����գ����հ༰����
		 {
			 Course xPresent=handlecourse.findbyname(nameString);
				if(xPresent!=null)
				{   
					DefaultTableModel dtm = handlecourse.findresultbyname(nameString);
					table.setModel(dtm);
				}
				else JOptionPane.showMessageDialog(null, "���޴˿γ�", "��ѯ", 1);
			
		 }
		 else{             //������д����������Ϣ����
			 Course p=new Course( numberstring, nameString,teacherString, 0);
			 Course xPresent=handlecourse.findzonghe(p);
				if(xPresent!=null)
				{   
					DefaultTableModel dtm = handlecourse.findresultbyzonghe(xPresent);
					table.setModel(dtm);
				}
				else JOptionPane.showMessageDialog(null, "���޴˿γ�", "��ѯ", 1);
				
		 }
	      }
			if(e.getSource()== b2){//ɾ��
			       String nameString=coursenametext.getText();
		  		    String coursenum=coursenumtext.getText();
					String teacher=teachertext.getText();
					  
					  Course a=new Course(coursenum, nameString, teacher, 0);
					 	 
					 if(nameString.equals("")||teacher.equals("")||coursenum.equals(""))
						  JOptionPane.showMessageDialog(null, "����������", "ɾ��ʧ��", 1);    //����δ��д�ĵط�����ʾ
						
					  else if(handlecourse.findzonghe(a)!=null)            //����ɾ��
				    {
				    int x= JOptionPane.showInternalConfirmDialog(this,"ȷ��ɾ����","ȡ��" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				    if(x==0){
					 handlecourse.deletezonghe(a);
					 JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "ɾ���ɹ�", 1);
					 DefaultTableModel dtm = handlecourse.showTable();
				     table.setModel(dtm);
				     }
					 }
					  else JOptionPane.showMessageDialog(null, "���޴˿γ�", "ɾ��ʧ��", 1);
			}
			
		if(e.getSource() == b3){//����
			//������γ�������Ϣ�������п�
			if((coursenametext.getText().equals(""))||(coursenumtext.getText().equals(""))||(teachertext.getText().equals(""))||(timetext.getText().equals("")))
			{ 
			JOptionPane.showMessageDialog(table, "�γ���Ϣ������", "���ʧ��", 1);
			}
			else {//��������Ƿ��ظ����ظ�����������ʾ
			Course p=new Course(coursenumtext.getText(), coursenametext.getText(),
			teachertext.getText(), Integer.parseInt(timetext.getText()));
				if(handlecourse.findzonghe(p)==null)
				{
				if(handlecourse.add(p)==true)
			       JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ӳɹ�", 1);
				DefaultTableModel dtm = handlecourse.showTable();
			    table.setModel(dtm);
				}
			else {JOptionPane.showMessageDialog(null, "���д˿γ�", "���ʧ��", 1);
				}
			}
		}
		if(e.getSource()==b4){         //�ڱ�����޸����ݣ�����޸İ�ť���޸�
			  	int row=table.getSelectedRow();   //��øĶ���ǰ����
				    String coursenum = (String) table.getValueAt(row,0);
					String coursename = (String) table.getValueAt(row,1);
					String teacher = (String) table.getValueAt(row,2);
					int time = Integer.parseInt( table.getValueAt(row,3).toString());
					Course beforec=new Course(coursenum, coursename, teacher, time);
					int a = table.getEditingRow();
					 int c = table.getEditingColumn();//��øĶ��������
					 table.getCellEditor(a,c).stopCellEditing();
					 coursenum = (String) table.getValueAt(row,0);
					 coursename = (String) table.getValueAt(row,1);
					 teacher = (String) table.getValueAt(row,2);
					 time = Integer.parseInt((String) table.getValueAt(row,3));
					 Course nowc=new Course(coursenum, coursename, teacher, time);
				     int x= JOptionPane.showInternalConfirmDialog(table,"ȷ���޸ģ�","ȡ��" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				    if(x==0){
			    		handlecourse.deletezonghe(beforec);//ɾ��֮ǰ�����ݣ�����޸ĺ������
						handlecourse.add(nowc);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "�ɹ�", 1);
			   }
			    	 else  JOptionPane.showMessageDialog(null, "�޸�ʧ��", "ʧ��", 1);
				}
		
	}

}
