package ui;


import handle.Handlepresent;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import table.Present;

public class Presentmannger extends JInternalFrame implements ActionListener{
	
		private static final long serialVersionUID = 1L; 
	    
		JScrollPane jScrollPane=null;
		JButton b1,b2,b3,b4;//����  ɾ��  �޸�   ��ѯ
		Box box,box0,box1,box2,box3,box4 ;
		JTextField classtext,studenttext,coursetext,timetext;  //�����ı���
		JLabel j1,j2,j3,j4,j5;     //ÿ����ǩ
			
		JComboBox comboBox;    //�������͵�������
			
	
		Handlepresent handlepresent=new Handlepresent();
		JTable table = new JTable();
		public Presentmannger(String title, boolean resizable, boolean closable,
				boolean maximizable,boolean iconificial) {
			 super(title, resizable, closable, maximizable, iconificial);
			//�����������������˵�
			 String name[]=new String[5];
				name[0]=new String("����");
				name[1]=new String("����");
				name[2]=new String("�¼�");
				name[3]=new String("�ٵ�");
				name[4]=new String("����");
				comboBox=new JComboBox(name);
				comboBox.setEnabled(true);
				//�������ģ�ͣ������񣬽������봰��
                 DefaultTableModel dtm = handlepresent.showTable();
			     table.setModel(dtm);
				 jScrollPane=new JScrollPane(table);
				 add(new JScrollPane(jScrollPane),BorderLayout.CENTER);	
				    box0=Box.createVerticalBox();
				    //��ʾ��ǩ������һ��������
				    j1=new JLabel("�༶");
				    j2=new JLabel("ѧ��");
				    j3=new JLabel("�γ�");
				    j4=new JLabel("ʱ��");
				    j5=new JLabel("��������");
				    box0.add(j1);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j2);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j3);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j4);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j5);
				    //�����ı��򣬷�����һ�������У�
				    coursetext=new JTextField(1);
				    timetext=new JTextField(1);
				    studenttext=new JTextField(1);
				    classtext=new JTextField(1);
					   
				    box2=Box.createVerticalBox();
				    box2.add(classtext);
				    box2.add(Box.createVerticalStrut(1));
				    box2.add(studenttext);
				    box2.add(Box.createVerticalStrut(1));
					box2.add(coursetext);
					box2.add(Box.createVerticalStrut(1));
					box2.add(timetext);
				    box2.add(Box.createVerticalStrut(1));
					box2.add(comboBox);
				    //���ı���ǩ���ı������ͬһ������
				   box3=Box.createHorizontalBox();
				   box3.add(box0);
				   box3.add(Box.createHorizontalStrut(15));
				   box3.add(box2);
				   box3.setSize(10, 20);
				   //�����������һ���������
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
			 String nameString=studenttext.getText();//�����д��ѧ�ţ��༶
			 String classString=classtext.getText();
			 if(nameString.equals("")&&classString.equals("")) {   //��δ��дѧ�ţ��༶����ʾ��������
					DefaultTableModel dtm = handlepresent.showTable();
					table.setModel(dtm);
					}
			 else if(classString.equals("")){//���༶��Ϊ�գ�����ѧ�Ų���
				 Present xPresent=handlepresent.findbyname(nameString);
					if(xPresent!=null)
					{   
						DefaultTableModel dtm = handlepresent.findresult(nameString);
						table.setModel(dtm);
					}
					else JOptionPane.showMessageDialog(null, "���޴���", "��ѯ", 1);
					 
			 }
			 else if(nameString.equals(""))            //��ѧ�����գ����հ༰����
			 {
				 Present xPresent=handlepresent.findbyclass(classString);
					if(xPresent!=null)
					{   
						DefaultTableModel dtm = handlepresent.findresultbyclass(classString);
						table.setModel(dtm);
					}
					else JOptionPane.showMessageDialog(null, "���޴���", "��ѯ", 1);
				
			 }
			 else{             //������д����������Ϣ����
				 Present p=new Present(classString, nameString, null, null, null);
				 Present xPresent=handlepresent.findzonghe(p);
					if(xPresent!=null)
					{   
						DefaultTableModel dtm = handlepresent.findresultbyzonghe(xPresent);
						table.setModel(dtm);
					}
					else JOptionPane.showMessageDialog(null, "���޴���", "��ѯ", 1);
					
			 }
		      }
			
				if(e.getSource()== b2){//ɾ��
				//������Ҫɾ����Ա������������ɾ��
			  String nameString=studenttext.getText();
			  	
						  nameString=studenttext.getText();     //�����д��ѧ����Ϣ
						  String classnum=classtext.getText();
						  String timeString=timetext.getText();
						  String typeString=(String)comboBox.getSelectedItem();
						  String courString=coursetext.getText();
						  
						  Present a=new Present(classnum, nameString, courString, typeString, timeString);
						  if(nameString.equals("")||classnum.equals("")||courString.equals("")||timeString.equals(""))
							  JOptionPane.showMessageDialog(null, "����������", "ɾ��ʧ��", 1);    //����δ��д�ĵط�����ʾ
							
						  else if(handlepresent.findzonghedelete(a)!=null)            //����ɾ��
					    {
					    int x= JOptionPane.showInternalConfirmDialog(this,"ȷ��ɾ����","ȡ��" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
					    if(x==0){
						 handlepresent.deletep(a);
						 JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "ɾ���ɹ�", 1);
						 DefaultTableModel dtm = handlepresent.showTable();
					     table.setModel(dtm);
					     }
						 }
						  else JOptionPane.showMessageDialog(null, "���޴���", "ɾ��ʧ��", 1);
				}
			if(e.getSource() == b3){//����
				//������ѧ��������Ϣ�������п�
				if((classtext.getText().equals(""))||(studenttext.getText().equals(""))||(coursetext.getText().equals(""))||(timetext.getText().equals("")))
				{ 
				JOptionPane.showMessageDialog(table, "ѧ����Ϣ������", "���ʧ��", 1);
				}
				else {//��������Ƿ��ظ����ظ�����������ʾ
				Present p=new Present(classtext.getText(), studenttext.getText(),
				coursetext.getText(),(String)comboBox.getSelectedItem(), timetext.getText());
					if(handlepresent.findbyzonghe(p))
					{JOptionPane.showMessageDialog(null, "���д�ѧ��", "���ʧ��", 1);
					}
					
				else 
				{
					if(handlepresent.add(p)==true)
				       JOptionPane.showMessageDialog(null, "��ӳɹ�", "��ӳɹ�", 1);
					DefaultTableModel dtm = handlepresent.showTable();
				    table.setModel(dtm);
					}
				}
			}
			if(e.getSource()==b4){         //�ڱ�����޸����ݣ�����޸İ�ť���޸�
				  	int row=table.getSelectedRow();   //��øĶ���ǰ����
					    String classnum = (String) table.getValueAt(row,0);
						String number = (String) table.getValueAt(row,1);
						String course = (String) table.getValueAt(row,2);
						String type = (String) table.getValueAt(row,4);
						String time = (String) table.getValueAt(row,3);
						Present beforePresent=new Present(classnum, number, course, type, time);
						int a = table.getEditingRow();
						 int c = table.getEditingColumn();//��øĶ��������
						 table.getCellEditor(a,c).stopCellEditing();
						 classnum = (String) table.getValueAt(row,0);
						 number = (String) table.getValueAt(row,1);
						 course = (String) table.getValueAt(row,2);
						 type = (String) table.getValueAt(row,4);
						 time = (String) table.getValueAt(row,3);
						 Present nowPresent=new Present(classnum, number, course, type, time);
					   int x= JOptionPane.showInternalConfirmDialog(table,"ȷ���޸ģ�","ȡ��" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
					    	  if(x==0){
				    		handlepresent.deletep(beforePresent);//ɾ��֮ǰ�����ݣ�����޸ĺ������
							handlepresent.add(nowPresent);
								
					JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "�ɹ�", 1);
				   }
				    	 else  JOptionPane.showMessageDialog(null, "�޸�ʧ��", "ʧ��", 1);
					}
			
		}
		   
}




