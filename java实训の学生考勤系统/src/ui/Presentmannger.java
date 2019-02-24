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
		JButton b1,b2,b3,b4;//增加  删除  修改   查询
		Box box,box0,box1,box2,box3,box4 ;
		JTextField classtext,studenttext,coursetext,timetext;  //各个文本域
		JLabel j1,j2,j3,j4,j5;     //每个标签
			
		JComboBox comboBox;    //考查类型的下拉框
			
	
		Handlepresent handlepresent=new Handlepresent();
		JTable table = new JTable();
		public Presentmannger(String title, boolean resizable, boolean closable,
				boolean maximizable,boolean iconificial) {
			 super(title, resizable, closable, maximizable, iconificial);
			//构建考察类型下拉菜单
			 String name[]=new String[5];
				name[0]=new String("旷课");
				name[1]=new String("病假");
				name[2]=new String("事假");
				name[3]=new String("迟到");
				name[4]=new String("出勤");
				comboBox=new JComboBox(name);
				comboBox.setEnabled(true);
				//获得数据模型，插入表格，将表格放入窗口
                 DefaultTableModel dtm = handlepresent.showTable();
			     table.setModel(dtm);
				 jScrollPane=new JScrollPane(table);
				 add(new JScrollPane(jScrollPane),BorderLayout.CENTER);	
				    box0=Box.createVerticalBox();
				    //提示标签，放入一个盒子中
				    j1=new JLabel("班级");
				    j2=new JLabel("学号");
				    j3=new JLabel("课程");
				    j4=new JLabel("时间");
				    j5=new JLabel("考勤类型");
				    box0.add(j1);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j2);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j3);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j4);
				    box0.add(Box.createVerticalStrut(5));
				    box0.add(j5);
				    //各个文本域，放入另一个盒子中，
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
				    //将文本标签和文本域放入同一个盒子
				   box3=Box.createHorizontalBox();
				   box3.add(box0);
				   box3.add(Box.createHorizontalStrut(15));
				   box3.add(box2);
				   box3.setSize(10, 20);
				   //各个组件填在一个大盒子中
				    box = Box.createVerticalBox();
				    box.add(Box.createVerticalStrut(30));
				    box.add(box3);
				    box.add(Box.createVerticalStrut(30));
		  //定义各个操作按钮
				    b1 = new JButton("查询");
		    b1.addActionListener(this);
		    b2 = new JButton("删除");
		    b2.addActionListener(this);
		    b3 = new JButton("增加");
		    b3.addActionListener(this);
		    b4 = new JButton("修改");
		    b4.addActionListener(this);
		    //将按钮填入盒子
		   box1 =  Box.createHorizontalBox();
		    box1.add(b1);
		    box1.add(Box.createHorizontalStrut(15));
		    box1.add(b2);
		    box1.add(Box.createHorizontalStrut(15));
		    box1.add(b3);
		    box1.add(Box.createHorizontalStrut(15));
		    box1.add(b4);
		    box.add(box1);
		   //将整个盒子放到大的jpanel里
		  JPanel jPanel=new JPanel();
		  jPanel.add(box,BorderLayout.CENTER);
		   this.add(jPanel,BorderLayout.SOUTH);
		   setVisible(true);
			setSize(500,500);
			
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		   }
		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()== b1){//查询
			 String nameString=studenttext.getText();//获得填写的学号，班级
			 String classString=classtext.getText();
			 if(nameString.equals("")&&classString.equals("")) {   //若未填写学号，班级，显示所有数据
					DefaultTableModel dtm = handlepresent.showTable();
					table.setModel(dtm);
					}
			 else if(classString.equals("")){//若班级栏为空，按照学号查找
				 Present xPresent=handlepresent.findbyname(nameString);
					if(xPresent!=null)
					{   
						DefaultTableModel dtm = handlepresent.findresult(nameString);
						table.setModel(dtm);
					}
					else JOptionPane.showMessageDialog(null, "查无此人", "查询", 1);
					 
			 }
			 else if(nameString.equals(""))            //若学号栏空，按照班及查找
			 {
				 Present xPresent=handlepresent.findbyclass(classString);
					if(xPresent!=null)
					{   
						DefaultTableModel dtm = handlepresent.findresultbyclass(classString);
						table.setModel(dtm);
					}
					else JOptionPane.showMessageDialog(null, "查无此人", "查询", 1);
				
			 }
			 else{             //若都填写，按具体信息查找
				 Present p=new Present(classString, nameString, null, null, null);
				 Present xPresent=handlepresent.findzonghe(p);
					if(xPresent!=null)
					{   
						DefaultTableModel dtm = handlepresent.findresultbyzonghe(xPresent);
						table.setModel(dtm);
					}
					else JOptionPane.showMessageDialog(null, "查无此人", "查询", 1);
					
			 }
		      }
			
				if(e.getSource()== b2){//删除
				//请输入要删除的员工的姓名，并删除
			  String nameString=studenttext.getText();
			  	
						  nameString=studenttext.getText();     //获得填写的学生信息
						  String classnum=classtext.getText();
						  String timeString=timetext.getText();
						  String typeString=(String)comboBox.getSelectedItem();
						  String courString=coursetext.getText();
						  
						  Present a=new Present(classnum, nameString, courString, typeString, timeString);
						  if(nameString.equals("")||classnum.equals("")||courString.equals("")||timeString.equals(""))
							  JOptionPane.showMessageDialog(null, "请输入条件", "删除失败", 1);    //若有未填写的地方，提示
							
						  else if(handlepresent.findzonghedelete(a)!=null)            //查找删除
					    {
					    int x= JOptionPane.showInternalConfirmDialog(this,"确定删除？","取消" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
					    if(x==0){
						 handlepresent.deletep(a);
						 JOptionPane.showMessageDialog(null, "删除成功", "删除成功", 1);
						 DefaultTableModel dtm = handlepresent.showTable();
					     table.setModel(dtm);
					     }
						 }
						  else JOptionPane.showMessageDialog(null, "查无此人", "删除失败", 1);
				}
			if(e.getSource() == b3){//增加
				//请输入学生所有信息，不能有空
				if((classtext.getText().equals(""))||(studenttext.getText().equals(""))||(coursetext.getText().equals(""))||(timetext.getText().equals("")))
				{ 
				JOptionPane.showMessageDialog(table, "学生信息不完善", "添加失败", 1);
				}
				else {//查找添加是否重复，重复给出错误提示
				Present p=new Present(classtext.getText(), studenttext.getText(),
				coursetext.getText(),(String)comboBox.getSelectedItem(), timetext.getText());
					if(handlepresent.findbyzonghe(p))
					{JOptionPane.showMessageDialog(null, "已有此学生", "添加失败", 1);
					}
					
				else 
				{
					if(handlepresent.add(p)==true)
				       JOptionPane.showMessageDialog(null, "添加成功", "添加成功", 1);
					DefaultTableModel dtm = handlepresent.showTable();
				    table.setModel(dtm);
					}
				}
			}
			if(e.getSource()==b4){         //在表格里修改数据，点击修改按钮，修改
				  	int row=table.getSelectedRow();   //获得改动的前数据
					    String classnum = (String) table.getValueAt(row,0);
						String number = (String) table.getValueAt(row,1);
						String course = (String) table.getValueAt(row,2);
						String type = (String) table.getValueAt(row,4);
						String time = (String) table.getValueAt(row,3);
						Present beforePresent=new Present(classnum, number, course, type, time);
						int a = table.getEditingRow();
						 int c = table.getEditingColumn();//获得改动后的数据
						 table.getCellEditor(a,c).stopCellEditing();
						 classnum = (String) table.getValueAt(row,0);
						 number = (String) table.getValueAt(row,1);
						 course = (String) table.getValueAt(row,2);
						 type = (String) table.getValueAt(row,4);
						 time = (String) table.getValueAt(row,3);
						 Present nowPresent=new Present(classnum, number, course, type, time);
					   int x= JOptionPane.showInternalConfirmDialog(table,"确定修改？","取消" ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
					    	  if(x==0){
				    		handlepresent.deletep(beforePresent);//删除之前的数据，添加修改后的数据
							handlepresent.add(nowPresent);
								
					JOptionPane.showMessageDialog(null, "修改成功", "成功", 1);
				   }
				    	 else  JOptionPane.showMessageDialog(null, "修改失败", "失败", 1);
					}
			
		}
		   
}




